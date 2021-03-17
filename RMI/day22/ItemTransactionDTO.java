package day22;

import java.io.Serializable;
public class ItemTransactionDTO {
	private int invno;
	private int itemno;
	private int qty;
	public synchronized final int getInvno() {
		return invno;
	}
	public synchronized final void setInvno(int invno) {
		this.invno = invno;
	}
	public synchronized final int getItemno() {
		return itemno;
	}
	public synchronized final void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public synchronized final int getQty() {
		return qty;
	}
	public synchronized final void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "ItemDetails [invno=" + invno + ", itemno=" + itemno + ", qty=" + qty + "]";
	}

	
}