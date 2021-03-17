package day22;

import java.util.Set;


public interface CustomerMasterDAO {
	public int insertCustomerDetials(CustomerMasterDTO obj);
	public int deleteCustomerDetials(int custno);
	public int updateCustomerDetials(CustomerMasterDTO obj);
	public CustomerMasterDTO getCustomerDetials(int custno);
	public Set<CustomerMasterDTO> getCustomerDetialsAll();
}