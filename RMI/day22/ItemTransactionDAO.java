package day22;

import java.util.Set;

public interface ItemTransactionDAO {
	public int insertItem(ItemTransactionDTO obj);
	public int deleteItem(int invno);
	public int updateInvoice(ItemTransactionDTO obj);
	public Set<ItemTransactionDTO> getItemDetails(int invno);
	public Set<ItemTransactionDTO> getItemDetailsAll(String invno);
}