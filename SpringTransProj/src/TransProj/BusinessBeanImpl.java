package TransProj;
public class BusinessBeanImpl implements BusinessBean{
	//association
	private Transfer mtb;
	public Transfer getMtb() {
		return mtb;
	}
	public void setMtb(Transfer mtb) {
		this.mtb = mtb;
	}
	
	@Override
	public void doTransaction(int creditaccountid, int debitaccountid, int amt) throws Exception {		
		
		
		mtb.credit(creditaccountid, amt);
		mtb.debit(debitaccountid, amt);
	}
}