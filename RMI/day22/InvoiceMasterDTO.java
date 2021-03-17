package day22;

import java.io.Serializable;
import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable {
	
	private int invno;
	private LocalDate invDate;
	private int customerno;
	
	public synchronized final int getInvno() {
		return invno;
	}
	public synchronized final void setInvno(int invno) {
		this.invno = invno;
	}
	public synchronized final LocalDate getInvDate() {
		return invDate;
	}
	public synchronized final void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}
	public synchronized final int getCustomerno() {
		return customerno;
	}
	public synchronized final void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	
	@Override
	public String toString() {
		return "InvoiceMasterDto [invno=" + invno + ", invDate=" + invDate + ", customerno=" + customerno + "]";
	}
	
	
	

}