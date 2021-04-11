package ProjectDTO;

import java.util.*;

public interface CustomerMasterDAO {
	public int insert(CustomerMasterDTO cus);
	public int update(CustomerMasterDTO cus);
	public int delete(int cusno);
	public CustomerMasterDTO findById(int cusno);
	public List<CustomerMasterDTO> findByName(String name);
	public List<CustomerMasterDTO> findAll();
}
