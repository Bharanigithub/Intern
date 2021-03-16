package day22;

import java.util.Set;

public interface ItemTransactionDAO {
	public int insertQty(ItemTransactionDTO itemTransactionDTO);
	public int deleteQty(int itemno,int invno);
	public int updateQty(ItemTransactionDTO itemTransactionDTO);
	public Set<ItemTransactionDTO> getItemTransaction(int itemno,int invno);
	public Set<ItemTransactionDTO> getItemTransactionAll();
}
