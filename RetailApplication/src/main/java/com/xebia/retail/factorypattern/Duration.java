package com.xebia.retail.factorypattern;

public class Duration implements User{

	//if Duration of user>=2 years, applicable for 5% discount
	public int getDiscount() {
		
		System.out.println("User is applicable for the 5% Discount");
		return 5;
	}

}
