package day22;

import java.io.Serializable;

public class CustomerMasterDTO implements Serializable{
	private int customerNo;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private String customerAddress;
	public int getCustomerNo() {
		return customerNo;
	}
	public final void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public final String getCustomerName() {
		return customerName;
	}
	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public final String getCustomerPhone() {
		return customerPhone;
	}
	public final void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public final String getCustomerEmail() {
		return customerEmail;
	}
	public final void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public final String getCustomerAddress() {
		return customerAddress;
	}
	public final void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CustomerMasterDTO [Customer No=" + customerNo + ", Customer Name=" + customerName + ", Customer Phone No=" + customerPhone + ", Customer Email=" + customerEmail + ", Customer Address=" + customerAddress + "]";
	}
}
