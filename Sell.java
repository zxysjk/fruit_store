import java.sql.*;
import java.util.Vector;
import java.math.BigDecimal;

public class Sell {

	public static Vector<Fruit> nowFruit(Statement stmt) throws SQLException
	{
        //��ѯ����ˮ��
		Fruit f=new Fruit();
		Vector<Fruit> fruits=new Vector<Fruit>();
		String sql1= "SELECT fruitID, fruitName, price,description,quantity FROM fruit";
		ResultSet rs=stmt.executeQuery(sql1);
        System.out.println("����ˮ��:");

        while(rs.next()){
            // ͨ���ֶμ���
            int id  = rs.getInt("fruitID");
            String name = rs.getString("fruitName");
            BigDecimal price=new BigDecimal(String.valueOf(rs.getDouble("price")));
            String description = rs.getString("description");
            
            f=new Fruit(id,name,price,description);
            System.out.println("���["+id+"] ���ƣ�<"+name+"> �۸�"+price +" ������"+description);
            fruits.addElement(f);
            }
        	rs.close();
        	System.out.println("----------------------------------------------------");
            return fruits;
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
	
	public static Vector<Fruit> addFruit(Statement stmt,boolean b) throws SQLException
	{
		
		// ִ�����Ӳ�������ӣ�'7','â��',5,'yellow',5����
        //System.out.println("ִ���������ݲ���������â��һ��");
        String sql2= "insert into fruit values(7,'â��',5,'yellow',5)";
        stmt.execute(sql2);
        
        if(b==true)
        {
        System.out.print("��ʱ��ѯ���,");
        return nowFruit(stmt);
        }
        else
        	return new Vector<Fruit>();
	}
	public static Vector<Fruit> deleteFruit(Statement stmt,boolean b) throws SQLException
	{
		// ִ��ɾ��������ɾ��â����
        //System.out.println("ִ��ɾ�����ݲ�����ɾ��â��һ��");
        String sql3= "delete from fruit where fruitName='â��'";
        stmt.execute(sql3);
        if(b==true) {
        System.out.print("��ʱ��ѯ���,");
        return nowFruit(stmt);
        }
        else
        	return new Vector<Fruit>();
     }
	public static Vector<Fruit> AlterFruit(Statement stmt,boolean b) throws SQLException
	{
		// ִ�и��²����������������Ϊ⨺���
        //System.out.println("ִ�и������ݲ�������⨺��Ҹ���Ϊ�����");
        String sql4= "update  fruit set fruitName='�����' where fruitName='⨺���'";
        stmt.execute(sql4);
        
        if(b==true) {
        System.out.print("��ʱ��ѯ���,");
        return nowFruit(stmt);
        }
        else 
        	return new Vector<Fruit>();
        
	}
	public static void noty(String s)
	{

		fruitFactory.getInstance().xiu(s);
	}
	public static void atta(Vector<User> users)
	{
		for(User u:users)
		{
			MyObserver obs=u;
			fruitFactory.getInstance().attach(obs);
		}
	}

    public static void main(String[] args) throws ClassNotFoundException {
        
    	User u1=new User("zxy",123,"Normal");
        User u2=new User("zxc",123,"Normal");
        Vector<User> users=new Vector<User>();
        users.add(u1);
        users.add(u2);
        atta(users);
        
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.cj.jdbc.Driver");
            // ������
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruits?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","");
            System.out.println("�����������ݿ�...");
            stmt = conn.createStatement();
           
            //��ѯ��ǰˮ��
            Vector<Fruit> fruits=nowFruit(stmt);
            //��ѯƻ��
            fruits=selectApple(stmt);
            
            //�����Ʒ
            addFruit(stmt,false);
             noty("�̼����â��");
            deleteFruit(stmt,false);
            noty("�̼�ɾ��â��");

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
    
