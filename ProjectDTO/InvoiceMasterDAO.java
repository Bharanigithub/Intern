package ProjectDTO;

import java.util.List;

public interface InvoiceMasterDAO {
	public int insert(InvoiceMasterDTO inv);
	public int update(InvoiceMasterDTO inv);
	public int delete(int invno);
	public InvoiceMasterDTO findById(int invno);
	public List<InvoiceMasterDTO> findAll();
}
