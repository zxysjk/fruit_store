public class fruitFactory extends MySubject
{
	private static fruitFactory instance = null;
	private fruitFactory(){}
	public static fruitFactory getInstance()
	{
		if(instance==null) {
			//System.out.println("��ϲ��ӵ����һ���µ���~");
			instance =new fruitFactory();
		}
		else
		{
			//System.out.println("emmm����������Ŀǰֻ��һ�ҵ�");
		}
		return instance;
	}

	public Fruit produceFruit(String name) {
	if(name=="Apple") 
	{
		//System.out.println("�ṩ��ˮ������ƻ��");
		return new Apple();
	}
	else if(name=="Pear") 
	{
		//System.out.println("�ṩ��ˮ����������");
		return new Pear();
	}
	else if(name=="Watermelon") 
	{
		//System.out.println("�ṩ��ˮ����������");
		return new Watermelon();
	}
	else 
	{
		//System.out.println("�ݲ�֧�ָ���ˮ��");
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