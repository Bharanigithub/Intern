package day22;

import java.io.Serializable;

public class ItemTransactionDTO implements Serializable {
	int invNo;
	int itemNo;
	int qty;
	public final int getInvNo() {
		return invNo;
	}
	public final void setInvNo(int invNo) {
		this.invNo = invNo;
	}
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final int getQty() {
		return qty;
	}
	public final void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ Invoice No="+invNo+", Item No="+itemNo+", Quantity="+qty+"]";
	}
}
