package vo;

import java.io.Serializable;

public class PersonAccountVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ±‡∫≈
	 */
	private String number;
	/*
	 * √‹¬Î
	 */
	private String password;
	/*
	 * …Ì∑›
	 */
	private String identity;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	

}
