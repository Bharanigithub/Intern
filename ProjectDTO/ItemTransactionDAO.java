package ProjectDTO;

import java.util.List;

public interface ItemTransactionDAO {
	public int insert(ItemTransactionDTO itemTran);
	public int update(ItemTransactionDTO itemTran);
	public int delete(int itemno,int invno);
	public ItemTransactionDTO findById(int itemno,int invno);
	public List<ItemTransactionDTO> findAll();
}
