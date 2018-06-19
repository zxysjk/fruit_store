public class User extends MyObserver
{
  private String userName=new String();
  private Cart cart=new Cart();
  private String state="Normal"; 
  private int password;
  User(){}
  User(String n,int p,String s)
  {
	  userName=n;
	  password=p;
	  state=s;
  }
  //默认为普通账户
  User(String n)
  {
	  userName=n;
  }
  
  public void responce()
  {
	  System.out.println(getUserName()+"收到");
  }
  
  //显示购物车
 public void showCart()
  {
	 System.out.print("尊敬的"+getUserName()+",");
	 getCart().li();
	 System.out.println("----------------------------------------------------");
  }
 
 //getter&&setter函数
  public int getPassword() {
		return password;
	}
 /* public void setPassword(int password) {
		this.password = password;
	}*/
 public String getUserName() 
 {
	return userName;
 }
 public void setUserName(String userName) 
 {
	this.userName = userName;
 }
 public Cart getCart() 
 {
	return cart;
 }
 public void setCart(Cart cart) 
 {
	this.cart = cart;
 }
 public String getState() 
 {
	return state;
 }
 public void setState(String s) 
 {
	state=s;
 }
  
 public void addItem(Fruit it)
 {
	 getCart().addCartItem(it);
 }
 public void deleteItem(Fruit it)
 {
	 getCart().deleteCartItem(it);
 }
 public void clearCart()
 {
	 getCart().clearCartItem();
 }
 //策略模式
 public void calOrder()
	{
	 System.out.println("尊敬的"+getUserName()+",您的订单如下：");
		if(getState().equals("VIP")) 
			{ChooseAccount ac=new VIPAccount();
			 ac.printOrderInfo(getCart());
			}
		else if(getState().equals("Normal")) 
		{
			ChooseAccount ac=new NormalAccount();
			 ac.printOrderInfo(getCart());
		}
		else
		{
			System.out.println("嘎吱，状态错误");
	    }
	//System.out.println("----------------------------------------------------");
	}


}