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
  //Ĭ��Ϊ��ͨ�˻�
  User(String n)
  {
	  userName=n;
  }
  
  public void responce()
  {
	  System.out.println(getUserName()+"�յ�");
  }
  
  //��ʾ���ﳵ
 public void showCart()
  {
	 System.out.print("�𾴵�"+getUserName()+",");
	 getCart().li();
	 System.out.println("----------------------------------------------------");
  }
 
 //getter&&setter����
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
 //����ģʽ
 public void calOrder()
	{
	 System.out.println("�𾴵�"+getUserName()+",���Ķ������£�");
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
			System.out.println("��֨��״̬����");
	    }
	//System.out.println("----------------------------------------------------");
	}


}