package com.xebia.retail.factorypattern;

public class AffiliateCustomer implements User {

	public int discount() {
		
		System.out.println("User is applicable for the 10% Discount");
		return 10;
	}
	
	

}
