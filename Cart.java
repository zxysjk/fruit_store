import java.math.BigDecimal;
import java.util.Vector;

public class Cart
{
	private Vector <Fruit> fruits=new Vector<Fruit> ();
	private MyIterator it = new fruitIterator();
	BigDecimal totalPrice;
	Cart(){}
	Cart(Vector<Fruit> ct)
	{
		fruits=ct;		
	}
	
	//遍历函数
	public void li()
	{
		System.out.println("您的购物车如下：");
		for(it.first();!it.isLast();it.next())
			System.out.println(it.currentItem().toString());
		System.out.println();
	}
	
	//迭代器模式
	 public MyIterator createIterator() 
	 {
		 return new fruitIterator();
	 };
	 
	 private class fruitIterator implements MyIterator
	 {
	    private int Index=0;
	    public void next() 
	    {
	 	   if(Index<fruits.size())
	 		   Index++;
	    }
	    public void first() 
	    {
	 	   Index=0;
	    }
	    public boolean isLast() {
	 	   return Index==fruits.size();
	    }
	  
	    public Fruit currentItem() {
	 	   return fruits.get(Index);
	    }
     }//迭代器类为private
	
	public Vector<Fruit> getCart() {
		return fruits;
	}
	
	public BigDecimal getTotalPrice() {
		calTotalPrice();
		return totalPrice;
	}

	public void calTotalPrice()
	{
		totalPrice=new BigDecimal(0);
		for(Fruit i:fruits)
		totalPrice=totalPrice.add(i.getPrice());
	}
	
	public void addCartItem(Fruit it) 
	{
		/*for(Fruit i:fruits)
			{if(i.getItem()==it.getItem())
				{i.setQuantity(i.getQuantity()+it.getQuantity());
			    break;}
	       else */
	    	fruits.add(it);
			//}
	    calTotalPrice();
	}
	public void deleteCartItem(Fruit it)
	{
		getCart().remove(it);
		calTotalPrice();
	}
	public void deleteCartItem(int id)
	{
		getCart().remove(id);
		calTotalPrice();
	}
	public void clearCartItem()
	{
		getCart().clear();
		calTotalPrice();
	}
	
	public String toString()
    {
		
		String st =new String();
		/*for (Iterator<Fruit> iter = fruits.iterator(); iter.hasNext();) 
		{
		 st+=iter.toString();
		}*/
		for(Fruit i:getCart())
			st+=(i.toString()+"\n");
       return (st+"价格总计："+getTotalPrice()+"元"+"\n");
   }
}