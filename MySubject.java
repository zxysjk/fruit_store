import java.util.Vector;

public abstract class MySubject{
	protected static  Vector notices=new Vector();
	public void attach(MyObserver observer)
	{
		notices.add(observer);
	}
	public void detach(MyObserver observer)
	{
		notices.remove(observer);
	}
	public abstract void xiu(String s);
	
}