import java.math.BigDecimal;

public class NormalAccount extends ChooseAccount
{
	public void printOrderInfo(Cart c) {
		BigDecimal transfer=new BigDecimal(5);
		BigDecimal money=c.getTotalPrice().add(transfer);
		System.out.println(c.toString()+"您是"+getAccount()+"，需加配送费5元");
		System.out.println("结算金额："+money+"\n");
	}
	public String getAccount() {
		return "普通客户";
	}
}


