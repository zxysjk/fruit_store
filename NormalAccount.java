import java.math.BigDecimal;

public class NormalAccount extends ChooseAccount
{
	public void printOrderInfo(Cart c) {
		BigDecimal transfer=new BigDecimal(5);
		BigDecimal money=c.getTotalPrice().add(transfer);
		System.out.println(c.toString()+"����"+getAccount()+"��������ͷ�5Ԫ");
		System.out.println("�����"+money+"\n");
	}
	public String getAccount() {
		return "��ͨ�ͻ�";
	}
}


