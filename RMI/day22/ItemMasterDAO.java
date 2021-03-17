package day22;

import java.util.Set;

public interface ItemMasterDAO {
	public int insertItemDetailsMaster(ItemMasterDTO obj);
	public int updateItemDetailsMaster(ItemMasterDTO obj);
	public int deleteItemDetailsMaster(int itemno);
	public ItemMasterDTO getItemDetailsMaster(int itemno);
	public Set<ItemMasterDTO> getItemDetailsMasterAll();
}