package com.xebia.retailTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

import com.xebia.retail.app.RetailApplication;
import com.xebia.retail.commonUtitility.ShopingCart;

public class TestRetailApplication {
	
	RetailApplication obj=new RetailApplication();
	ShopingCart cart=new ShopingCart();
	
	@Test
	public void testGetDiscount() throws ParseException {
		
		String name="Mudassir";
		String prodName="TV";
		//double amt=990;
		
		//Expected Discount % & customer name & prod name from CSV file
		assertEquals(30, obj.getUserDetails(name,prodName).getDiscount()); // kindly provide the customer name & prod name from csv file and expected pecentage discount
		
	}
	
	@Test
	public void testCalculateTotalBill() {
		
		int discount=30;
		double totalAmount=1000;
		
		//Expected total amount & discount % & total amount of bill
		assertEquals(650.0, cart.calculateTotalBill(discount, totalAmount),0.0);
		
		
	}

}
