import java.math.BigDecimal;

public class VIPAccount extends ChooseAccount
{	
	public void printOrderInfo(Cart c) {
		BigDecimal discount=new BigDecimal(String.valueOf(0.9));
		//BigDecimal discount=new BigDecimal(Double.toString(0.9));
		BigDecimal money=c.getTotalPrice().multiply(discount);

		System.out.println(c.toString()+"����"+getAccount()+",����9���Ż�");
		System.out.println("�����"+money+"\n");
	}
	public String getAccount() {
		return "VIP�ͻ�";
	}

		
	
}