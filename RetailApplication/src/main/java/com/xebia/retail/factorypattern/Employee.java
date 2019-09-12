package com.xebia.retail.factorypattern;

public class Employee implements User {

	public int discount() {
		
		System.out.println("User is applicable for the 30% Discount");
		
		return 30;
	}

}
