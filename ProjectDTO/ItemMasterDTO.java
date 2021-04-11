package ProjectDTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Item")
public class ItemMasterDTO implements Cloneable {
	private static ItemMasterDTO itemMasterDTO;
	@Id
	private int itemno;
	private String desc;
	private int units;
	private int price;
	private int shopno;
	private String itemImg;
	@Override
	public ItemMasterDTO clone() throws CloneNotSupportedException {
		return (ItemMasterDTO)super.clone();
	}
	public static ItemMasterDTO createObject() throws Exception {
		if(itemMasterDTO==null) {
			itemMasterDTO=new ItemMasterDTO();
			return itemMasterDTO;
		}
		return itemMasterDTO.clone();
	}
	public ItemMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	public synchronized final int getItemno() {
		return itemno;
	}
	public synchronized final void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public synchronized final String getDesc() {
		return desc;
	}
	public synchronized final void setDesc(String desc) {
		this.desc = desc;
	}
	public synchronized final int getUnits() {
		return units;
	}
	public synchronized final void setUnits(int units) {
		this.units = units;
	}
	public synchronized final int getPrice() {
		return price;
	}
	public synchronized final void setPrice(int price) {
		this.price = price;
	}
	public synchronized final int getShopno() {
		return shopno;
	}
	public synchronized final void setShopno(int shopno) {
		this.shopno = shopno;
	}
	public synchronized final String getItemImg() {
		return itemImg;
	}
	public synchronized final void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	
	@Override
	public String toString() {
		return "ItemDetailsMasterDto [itemno=" + itemno + ", desc=" + desc + ", units=" + units + ", price=" + price
				+ "]";
	}
	
	
}