package ProjectDTO;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Invoice")
public class InvoiceMasterDTO implements Serializable,Cloneable {
	private static InvoiceMasterDTO invoiceMasterDTO;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invno;
	private LocalDate invDate;
	private int customerno;
	@Override
	protected InvoiceMasterDTO clone() throws CloneNotSupportedException {
		return (InvoiceMasterDTO)super.clone();
	}
	public static InvoiceMasterDTO createObject() throws Exception {
		if(invoiceMasterDTO==null) {
			invoiceMasterDTO=new InvoiceMasterDTO();
		}
		return invoiceMasterDTO.clone();
	}
	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
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