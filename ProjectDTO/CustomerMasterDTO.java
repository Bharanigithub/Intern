package ProjectDTO;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Customer")
public class CustomerMasterDTO implements Cloneable {
	private static CustomerMasterDTO customerMasterDTO;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custno;
	private String email;
	private String name;
	private String phone;
	private String address;
	@Override
	protected CustomerMasterDTO clone() throws CloneNotSupportedException {
		return (CustomerMasterDTO)super.clone();
	}
	public static CustomerMasterDTO createObject() throws Exception {
		if(customerMasterDTO==null) {
			customerMasterDTO=new CustomerMasterDTO();
		}
		return customerMasterDTO.clone();
	}
	public CustomerMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	public synchronized final int getCustno() {
		return custno;
	}
	public synchronized final void setCustno(int custno) {
		this.custno = custno;
	}
	public synchronized final String getEmail() {
		return email;
	}
	public synchronized final void setEmail(String email) {
		this.email = email;
	}
	public synchronized final String getName() {
		return name;
	}
	public synchronized final void setName(String name) {
		this.name = name;
	}
	public synchronized final String getPhone() {
		return phone;
	}
	public synchronized final void setPhone(String phone) {
		this.phone = phone;
	}
	public synchronized final String getAddress() {
		return address;
	}
	public synchronized final void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerDetialsDto [custno=" + custno + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	

}