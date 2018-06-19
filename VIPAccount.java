import java.math.BigDecimal;

public class VIPAccount extends ChooseAccount
{	
	public void printOrderInfo(Cart c) {
		BigDecimal discount=new BigDecimal(String.valueOf(0.9));
		//BigDecimal discount=new BigDecimal(Double.toString(0.9));
		BigDecimal money=c.getTotalPrice().multiply(discount);

		System.out.println(c.toString()+"您是"+getAccount()+",享受9折优惠");
		System.out.println("结算金额："+money+"\n");
	}
	public String getAccount() {
		return "VIP客户";
	}

		
	
}