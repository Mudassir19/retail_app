package com.xebia.retail.model;

public class UserDTO {
	
	
	private String custName;
	private String custType;
	private String registrationDate;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	@Override
	public String toString() {
		return "UserDTO [custName=" + custName + ", custType=" + custType + ", registrationDate=" + registrationDate
				+ "]";
	}
	
	
	
	
	

}
