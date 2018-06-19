public class fruitFactory extends MySubject
{
	private static fruitFactory instance = null;
	private fruitFactory(){}
	public static fruitFactory getInstance()
	{
		if(instance==null) {
			//System.out.println("恭喜您拥有了一家新店铺~");
			instance =new fruitFactory();
		}
		else
		{
			//System.out.println("emmm条件限制您目前只有一家店");
		}
		return instance;
	}

	public Fruit produceFruit(String name) {
	if(name=="Apple") 
	{
		//System.out.println("提供新水果——苹果");
		return new Apple();
	}
	else if(name=="Pear") 
	{
		//System.out.println("提供新水果——梨子");
		return new Pear();
	}
	else if(name=="Watermelon") 
	{
		//System.out.println("提供新水果——西瓜");
		return new Watermelon();
	}
	else 
	{
		//System.out.println("暂不支持该种水果");
		return null;
	}
	
 }

	public void xiu(String s) 
	{
		System.out.println(s);
		for(Object obs:notices)
		{
		((MyObserver)obs).responce();
		}	
	}
		
	
}