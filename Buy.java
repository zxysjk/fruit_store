import java.sql.*;
import java.util.Scanner;
import java.util.Vector;
import java.math.BigDecimal;

public class Buy {
	public static void choose(User u1,Vector<Fruit> fruits,Scanner reader)
	{
		 System.out.println("  挑选界面");
        System.out.println("请输入商品ID及数量:");
        while(reader.hasNext())
        {	
        	int index=reader.nextInt();
        	BigDecimal q=new BigDecimal(String.valueOf(reader.nextDouble()));
        	Fruit f=new Fruit(fruits.elementAt(index-1),q);
        	System.out.println(f+"  添加成功 !");
        	u1.addItem(f);
        }
        System.out.println("----------------------------------------------------");
        //reader.close();
	}
	public static User login(Statement stmt,Scanner in) throws SQLException
	{
		System.out.println("  登录界面");
        Vector<User> users=new Vector<User>();//用于存储用户及密码
        User u=new User();//创建临时变量
        String sql_1="Select userName,password,state from user";
        ResultSet rs2=stmt.executeQuery(sql_1);
        while(rs2.next()){
            String userName = rs2.getString("userName");
            int password = rs2.getInt("password");
            String state = rs2.getString("state");
            u=new User(userName,password,state);
            users.addElement(u);//存储数据库用户及密码
           }
       
        System.out.println("请输入用户名：");
        String UName=in.next();
        //System.out.println(UName);
        System.out.println("请输入密码：");
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
        			System.out.println("密码错误！");
        	        }
        	}
           else{
        	   //u=null;
        	   u=new User("Guest",0,"Normal");
                 }
        }
        if(u.getUserName().equals("Guest")) 
        {
        System.out.println("登陆失败，现以游客方式浏览");	
        }
        else 
        	System.out.println("欢迎"+u.getUserName()+"，登陆成功!");
        System.out.println("----------------------------------------------------");
        return u;
        }
	
	public static Vector<Fruit> selectApple(Statement stmt) throws SQLException
	{
    //查询当日水果
	//Fruit f=new Fruit();
	Fruit apple=fruitFactory.getInstance().produceFruit("Apple");//单例模式&简单工厂模式
	Vector<Fruit> fruits=new Vector<Fruit>();
	String sql5= "SELECT fruitID, fruitName, price,description,quantity FROM fruit where fruitName='苹果'";
	ResultSet rs=stmt.executeQuery(sql5);
    System.out.println("今日苹果:");

    while(rs.next()){
        // 通过字段检索
        int id  = rs.getInt("fruitID");
        String name = rs.getString("fruitName");
        BigDecimal price=new BigDecimal(String.valueOf(rs.getDouble("price")));
        String description = rs.getString("description");
        apple=new Apple(id,price,description);
        System.out.println("编号["+id+"] 名称：<"+name+"> 价格："+price +" 描述："+description);
        fruits.addElement(apple);
        }
    rs.close();
    System.out.print("\n");
    return fruits;
       
    }
	public static Vector<Fruit> nowFruit(Statement stmt) throws SQLException
	{
        //查询当日水果
		Fruit f=new Fruit();
		Vector<Fruit> fruits=new Vector<Fruit>();
		String sql1= "SELECT fruitID, fruitName, price,description,quantity FROM fruit";
		ResultSet rs=stmt.executeQuery(sql1);
        System.out.println("今日水果");

        while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("fruitID");
            String name = rs.getString("fruitName");
            BigDecimal price=new BigDecimal(String.valueOf(rs.getDouble("price")));
            String description = rs.getString("description");
            
            f=new Fruit(id,name,price,description);
            System.out.println("编号["+id+"] 名称：<"+name+"> 单价："+price +" 描述："+description);
            fruits.addElement(f);
            }
        System.out.println("----------------------------------------------------");
            return fruits;
        }
	
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开链接
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruits?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","");
            System.out.println("已连接上数据库...");
            stmt = conn.createStatement();
            Scanner re=new Scanner(System.in);
            
            //查询当前苹果
            Vector<Fruit> fruits=selectApple(stmt);
            //查询今日水果
            fruits=nowFruit(stmt);
            //登陆，用户名zxy密码123
            User u1=login(stmt,re);

        
            //添加购物车
            choose(u1,fruits,re);
            //关闭查询结果
            re.close();
           //显示购物车
            u1.showCart();
           //订单结算
            u1.calOrder();
            
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
              if(stmt!=null) stmt.close();
               }catch(SQLException se2){}// 什么都不做
                }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        
    }
    
