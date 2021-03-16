package day22;

import java.util.Set;

public interface CustomerMasterDAO {
	public int insertCustomer(CustomerMasterDTO cusMasterDTO);
	public int deleteCustomer(int cusno);
	public int updateCustomer(CustomerMasterDTO cusMasterDTO);
	public CustomerMasterDTO getCustomerMaster(int cusno);
	public Set<CustomerMasterDTO> getCustomerMasterAll();
}
