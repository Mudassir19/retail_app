package com.xebia.retail.factorypattern;

public class ZeroDiscount implements Discount{

	public int getDiscount() {
		
		System.out.println("User is not applicable for the any discount:");
		return 0;
	}

}
