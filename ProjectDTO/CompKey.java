package ProjectDTO;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompKey implements Serializable {
	private int invno;
	private int itemno;
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	
}
