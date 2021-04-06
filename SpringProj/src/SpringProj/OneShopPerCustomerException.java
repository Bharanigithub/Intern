package SpringProj;

public class OneShopPerCustomerException extends Exception{
	String msg;
	public OneShopPerCustomerException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
}
