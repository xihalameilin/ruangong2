package utility;

import java.io.Serializable;

public class ResultMessage implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private  String message;
	
	private boolean issuccess;
	
	public ResultMessage(boolean issuccess,String message){
		this.issuccess=issuccess;
		this.message=message;
	}

	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isIssuccess() {
		return issuccess;
	}


	public void setIssuccess(boolean issuccess) {
		this.issuccess = issuccess;
	}


	@Override
	public String toString() {
		if(issuccess==true)
			return "Result : Success , Message : "+message;
		else
			return "Result : Fail , Message : "+message;
	}	

}
