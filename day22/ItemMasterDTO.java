package day22;

import java.io.Serializable;

public class ItemMasterDTO implements Serializable {
	private int itemNo;
	private int itemUnit;
	private int itemPrice;
	private String itemDesc;
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final int getItemUnit() {
		return itemUnit;
	}
	public final void setItemUnit(int itemUnit) {
		this.itemUnit = itemUnit;
	}
	public final int getItemPrice() {
		return itemPrice;
	}
	public final void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public final String getItemDesc() {
		return itemDesc;
	}
	public final void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ Item No="+itemNo+", Item Description="+itemDesc+", Item Unit="+itemUnit+", Item Price="+itemPrice+"]";
	}
}
