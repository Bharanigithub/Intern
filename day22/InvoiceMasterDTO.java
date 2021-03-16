package day22;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
public class InvoiceMasterDTO implements Serializable{
	public final int getInvno() {
		return invno;
	}
	public final void setInvno(int invno) {
		this.invno = invno;
	}
	public final LocalDate getInvdate() {
		return invdate;
	}
	public final void setInvdate(LocalDate invdate) {
		this.invdate = invdate;
	}
	public final int getCustomerno() {
		return customerno;
	}
	public final void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	private int invno;
	private LocalDate invdate;
	private int customerno;
	
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invno=" + invno + ", invdate=" + invdate + ", customerno=" + customerno + "]";
	}
}
