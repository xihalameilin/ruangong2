package vo;

import java.io 

.Serializable;

public class NoticeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isnotice;
	
	private String person;
	
	private String message;

	public boolean isIsnotice() {
		return isnotice;
	}

	public void setIsnotice(boolean isnotice) {
		this.isnotice = isnotice;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
