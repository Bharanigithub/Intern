package ProjectDTO;

import java.util.List;

public interface ItemMasterDAO {
	public int insert(ItemMasterDTO item);
	public int update(ItemMasterDTO item);
	public int delete(int itemno);
	public ItemMasterDTO findById(int itemno);
	public List<ItemMasterDTO> findAll();
}
