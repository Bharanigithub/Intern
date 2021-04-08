package TransProj;

public class InsufficientMoneyException extends Exception {
	String msg;
	public InsufficientMoneyException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
}
