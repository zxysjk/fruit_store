import java.math.BigDecimal;

public class Fruit{
	 private int id;
	 private String name;
	 private BigDecimal price;
	 private String description;
	 private BigDecimal quantity; 
	 Fruit(){}
	 Fruit(int i,String n,BigDecimal p,String d)
	 {
		 id=i;
    	 name=n;
    	 price=p;
    	 description=d;
	 }
	 Fruit(Fruit f,BigDecimal q)
	 {
		 id=f.getId();
    	 name=f.getName();
    	 price=f.getPrice();
    	 description=f.getDescription();
    	 quantity=q;
	 }
     Fruit(int i,String n,BigDecimal p,String d,BigDecimal q)
     {
    	 id=i;
    	 name=n;
    	 price=p;
    	 description=d;
    	 quantity=q;
     }
	public Fruit(String string) {
		name=string;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal q1) {
		this.quantity = q1;
	}
     public String toString()
     {
    	return ("���["+id+"] ���ƣ�<"+name+"> ���ۣ�"+price+" ������"+quantity +" ������"+description);
     }
    
}

class Apple extends Fruit{

	Apple(int i, BigDecimal p, String d, BigDecimal q) {
		super(i, "ƻ��", p, d, q);
		// TODO �Զ����ɵĹ��캯�����
	}
	Apple(int i, BigDecimal p, String d) {
		super(i, "ƻ��", p, d);
		// TODO �Զ����ɵĹ��캯�����
	}
	Apple(){super("ƻ��");}
}

class Pear extends Fruit{

	Pear(int i, String n, BigDecimal p, String d, BigDecimal q) {
		super(i,"����", p, d, q);
		// TODO �Զ����ɵĹ��캯�����
	}
	Pear(int i, BigDecimal p, String d) {
		super(i, "����", p, d);
		// TODO �Զ����ɵĹ��캯�����
	}
	Pear(){super("����");}
}

class Watermelon extends Fruit{
	Watermelon(int i, String n, BigDecimal p, String d, BigDecimal q) {
		super(i,"����", p, d, q);
		// TODO �Զ����ɵĹ��캯�����
	}
	Watermelon(int i, BigDecimal p, String d) {
		super(i, "����", p, d);
		// TODO �Զ����ɵĹ��캯�����
	}
	Watermelon(){super("����");}
}
