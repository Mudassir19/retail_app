package com.xebia.retail.factorypattern;

public class Duration implements User{

	public int discount() {
		
		System.out.println("User is applicable for the 5% Discount");
		return 5;
	}

}
