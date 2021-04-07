package hiberProj;

import java.io.Serializable;

public class Comment implements Serializable {
	private String msg;
	public Comment() {
		
	}
	
	public Comment(String msg) {
		this.msg = msg;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}
	
}
