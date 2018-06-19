import java.sql.*;
import java.util.Vector;
import java.math.BigDecimal;

public class Sell {

	public static Vector<Fruit> nowFruit(Statement stmt) throws SQLException
	{
        //查询当日水果
		Fruit f=new Fruit();
		Vector<Fruit> fruits=new Vector<Fruit>();
		String sql1= "SELECT fruitID, fruitName, price,description,quantity FROM fruit";
		ResultSet rs=stmt.executeQuery(sql1);
        System.out.println("今日水果:");

        while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("fruitID");
            String name = rs.getString("fruitName");
            BigDecimal price=new BigDecimal(String.valueOf(rs.getDouble("price")));
            String description = rs.getString("description");
            
            f=new Fruit(id,name,price,description);
            System.out.println("编号["+id+"] 名称：<"+name+"> 价格："+price +" 描述："+description);
            fruits.addElement(f);
            }
        	rs.close();
        	System.out.println("----------------------------------------------------");
            return fruits;
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
	
	public static Vector<Fruit> addFruit(Statement stmt,boolean b) throws SQLException
	{
		
		// 执行增加操作，添加（'7','芒果',5,'yellow',5）项
        //System.out.println("执行增加数据操作，增加芒果一项");
        String sql2= "insert into fruit values(7,'芒果',5,'yellow',5)";
        stmt.execute(sql2);
        
        if(b==true)
        {
        System.out.print("此时查询结果,");
        return nowFruit(stmt);
        }
        else
        	return new Vector<Fruit>();
	}
	public static Vector<Fruit> deleteFruit(Statement stmt,boolean b) throws SQLException
	{
		// 执行删除操作，删除芒果项
        //System.out.println("执行删除数据操作，删除芒果一项");
        String sql3= "delete from fruit where fruitName='芒果'";
        stmt.execute(sql3);
        if(b==true) {
        System.out.print("此时查询结果,");
        return nowFruit(stmt);
        }
        else
        	return new Vector<Fruit>();
     }
	public static Vector<Fruit> AlterFruit(Statement stmt,boolean b) throws SQLException
	{
		// 执行更新操作，将奇异果更名为猕猴桃
        //System.out.println("执行更新数据操作，将猕猴桃更名为奇异果");
        String sql4= "update  fruit set fruitName='奇异果' where fruitName='猕猴桃'";
        stmt.execute(sql4);
        
        if(b==true) {
        System.out.print("此时查询结果,");
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
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开链接
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruits?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","");
            System.out.println("已连接上数据库...");
            stmt = conn.createStatement();
           
            //查询当前水果
            Vector<Fruit> fruits=nowFruit(stmt);
            //查询苹果
            fruits=selectApple(stmt);
            
            //添加商品
            addFruit(stmt,false);
             noty("商家添加芒果");
            deleteFruit(stmt,false);
            noty("商家删除芒果");

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
    
