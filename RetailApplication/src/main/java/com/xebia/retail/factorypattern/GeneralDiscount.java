package com.xebia.retail.factorypattern;

public class GeneralDiscount implements Discount {
	
	//offering discount $5 per $100
	public int getDiscount() {
		
		System.out.println("User is applicable for the Discount is 5 per 100:");
		
		return 1;
	}

}
