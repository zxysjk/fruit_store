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
    	return ("编号["+id+"] 名称：<"+name+"> 单价："+price+" 数量："+quantity +" 描述："+description);
     }
    
}

class Apple extends Fruit{

	Apple(int i, BigDecimal p, String d, BigDecimal q) {
		super(i, "苹果", p, d, q);
		// TODO 自动生成的构造函数存根
	}
	Apple(int i, BigDecimal p, String d) {
		super(i, "苹果", p, d);
		// TODO 自动生成的构造函数存根
	}
	Apple(){super("苹果");}
}

class Pear extends Fruit{

	Pear(int i, String n, BigDecimal p, String d, BigDecimal q) {
		super(i,"梨子", p, d, q);
		// TODO 自动生成的构造函数存根
	}
	Pear(int i, BigDecimal p, String d) {
		super(i, "梨子", p, d);
		// TODO 自动生成的构造函数存根
	}
	Pear(){super("梨子");}
}

class Watermelon extends Fruit{
	Watermelon(int i, String n, BigDecimal p, String d, BigDecimal q) {
		super(i,"西瓜", p, d, q);
		// TODO 自动生成的构造函数存根
	}
	Watermelon(int i, BigDecimal p, String d) {
		super(i, "西瓜", p, d);
		// TODO 自动生成的构造函数存根
	}
	Watermelon(){super("西瓜");}
}
