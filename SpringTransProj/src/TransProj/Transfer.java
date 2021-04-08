package TransProj;

public interface Transfer {
	public void credit(int accid,int amt)throws Exception;
	public void debit(int accid,int amt)throws Exception;
}
