package ProjectDTO;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="ItemTransaction")
public class ItemTransactionDTO implements Cloneable {
	private static ItemTransactionDTO itemTransactionDTO;
	@EmbeddedId
	private CompKey compKey;
	private int qty;
	@Override
	protected ItemTransactionDTO clone() throws CloneNotSupportedException {
		return (ItemTransactionDTO)super.clone();
	}
	public static ItemTransactionDTO createObject() throws Exception {
		if(itemTransactionDTO==null) {
			itemTransactionDTO=new ItemTransactionDTO();
		}
		return itemTransactionDTO.clone();
	}
	public ItemTransactionDTO() {
		
	}
	public synchronized final int getQty() {
		return qty;
	}
	public synchronized final void setQty(int qty) {
		this.qty = qty;
	}
	public CompKey getCompKey() {
		return compKey;
	}
	public void setCompKey(CompKey compKey) {
		this.compKey = compKey;
	}
	
}