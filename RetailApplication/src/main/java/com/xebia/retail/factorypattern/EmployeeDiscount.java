package com.xebia.retail.factorypattern;

public class EmployeeDiscount implements Discount {

	//Offering discount 30% if user is Employee of store
	public int getDiscount() {
		
		System.out.println("User is applicable for the 30% Discount:");
		
		return 30;
	}

}
