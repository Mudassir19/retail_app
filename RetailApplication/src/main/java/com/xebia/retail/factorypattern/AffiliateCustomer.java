package com.xebia.retail.factorypattern;

public class AffiliateCustomer implements User {

	//Offering discount 10% if user is affiliate customer
	public int getDiscount() {
		
		System.out.println("User is applicable for the 10% Discount:");
		return 10;
	}
	
	

}
