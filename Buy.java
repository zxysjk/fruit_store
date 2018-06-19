import java.sql.*;
import java.util.Scanner;
import java.util.Vector;
import java.math.BigDecimal;

public class Buy {
	public static void choose(User u1,Vector<Fruit> fruits,Scanner reader)
	{
		 System.out.println("  ��ѡ����");
        System.out.println("��������ƷID������:");
        while(reader.hasNext())
        {	
        	int index=reader.nextInt();
        	BigDecimal q=new BigDecimal(String.valueOf(reader.nextDouble()));
        	Fruit f=new Fruit(fruits.elementAt(index-1),q);
        	System.out.println(f+"  ��ӳɹ� !");
        	u1.addItem(f);
        }
        System.out.println("----------------------------------------------------");
        //reader.close();
	}
	public static User login(Statement stmt,Scanner in) throws SQLException
	{
		System.out.println("  ��¼����");
        Vector<User> users=new Vector<User>();//���ڴ洢�û�������
        User u=new User();//������ʱ����
        String sql_1="Select userName,password,state from user";
        ResultSet rs2=stmt.executeQuery(sql_1);
        while(rs2.next()){
            String userName = rs2.getString("userName");
            int password = rs2.getInt("password");
            String state = rs2.getString("state");
            u=new User(userName,password,state);
            users.addElement(u);//�洢���ݿ��û�������
           }
       
        System.out.println("�������û�����");
        String UName=in.next();
        //System.out.println(UName);
        System.out.println("���������룺");
        int password=in.nextInt();
        //System.out.println(password);
        //in.close();
        
        for(User i:users)
        {//System.out.println(i.getUserName()+i.getPassword()+i.getState());
           if(i.getUserName().equals(UName))
        	{
        		if(i.getPassword()==password) 
        			{
        			u=new User(i.getUserName(),i.getPassword(),i.getState());
        			break;
        			}
        		else 
        			{
        			//u=null;
        			u=new User("Guest",0,"Normal");
        			System.out.println("�������");
        	        }
        	}
           else{
        	   //u=null;
        	   u=new User("Guest",0,"Normal");
                 }
        }
        if(u.getUserName().equals("Guest")) 
        {
        System.out.println("��½ʧ�ܣ������οͷ�ʽ���");	
        }
        else 
        	System.out.println("��ӭ"+u.getUserName()+"����½�ɹ�!");
        System.out.println("----------------------------------------------------");
        return u;
        }
	
	public static Vector<Fruit> selectApple(Statement stmt) throws SQLException
	{
    //��ѯ����ˮ��
	//Fruit f=new Fruit();
	Fruit apple=fruitFactory.getInstance().produceFruit("Apple");//����ģʽ&�򵥹���ģʽ
	Vector<Fruit> fruits=new Vector<Fruit>();
	String sql5= "SELECT fruitID, fruitName, price,description,quantity FROM fruit where fruitName='ƻ��'";
	ResultSet rs=stmt.executeQuery(sql5);
    System.out.println("����ƻ��:");

    while(rs.next()){
        // ͨ���ֶμ���
        int id  = rs.getInt("fruitID");
        String name = rs.getString("fruitName");
        BigDecimal price=new BigDecimal(String.valueOf(rs.getDouble("price")));
        String description = rs.getString("description");
        apple=new Apple(id,price,description);
        System.out.println("���["+id+"] ���ƣ�<"+name+"> �۸�"+price +" ������"+description);
        fruits.addElement(apple);
        }
    rs.close();
    System.out.print("\n");
    return fruits;
       
    }
	public static Vector<Fruit> nowFruit(Statement stmt) throws SQLException
	{
        //��ѯ����ˮ��
		Fruit f=new Fruit();
		Vector<Fruit> fruits=new Vector<Fruit>();
		String sql1= "SELECT fruitID, fruitName, price,description,quantity FROM fruit";
		ResultSet rs=stmt.executeQuery(sql1);
        System.out.println("����ˮ��");

        while(rs.next()){
            // ͨ���ֶμ���
            int id  = rs.getInt("fruitID");
            String name = rs.getString("fruitName");
            BigDecimal price=new BigDecimal(String.valueOf(rs.getDouble("price")));
            String description = rs.getString("description");
            
            f=new Fruit(id,name,price,description);
            System.out.println("���["+id+"] ���ƣ�<"+name+"> ���ۣ�"+price +" ������"+description);
            fruits.addElement(f);
            }
        System.out.println("----------------------------------------------------");
            return fruits;
        }
	
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.cj.jdbc.Driver");
            // ������
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruits?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","");
            System.out.println("�����������ݿ�...");
            stmt = conn.createStatement();
            Scanner re=new Scanner(System.in);
            
            //��ѯ��ǰƻ��
            Vector<Fruit> fruits=selectApple(stmt);
            //��ѯ����ˮ��
            fruits=nowFruit(stmt);
            //��½���û���zxy����123
            User u1=login(stmt,re);

        
            //��ӹ��ﳵ
            choose(u1,fruits,re);
            //�رղ�ѯ���
            re.close();
           //��ʾ���ﳵ
            u1.showCart();
           //��������
            u1.calOrder();
            
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
              if(stmt!=null) stmt.close();
               }catch(SQLException se2){}// ʲô������
                }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        
    }
    
