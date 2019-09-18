package com.xebia.retail.commonUtitility;

public class ShopingCart {

	/**
	 * @param discount
	 * @param totalAmount calculating total bill based on given percentage and bill amount                   
	 * @return
	 */

	public double calculateTotalBill(int discount, double totalAmount) {

		System.out.println("Total Amount is:" + totalAmount);

		int addDiscount = 0;

		double amount, finalAmount = 0;

		if (totalAmount > 100) {

			addDiscount = (int) (totalAmount / 100) * 5;
			finalAmount = totalAmount - addDiscount;
			System.out.println("User is eligible for additional discount:" + addDiscount);
		}

		if (discount > 1) {

			amount = totalAmount * discount;
			double perAmount = amount / 100;
			System.out.println("User is eligible for % " + discount + " Discount:" + perAmount);
			totalAmount = totalAmount - perAmount;

			finalAmount = totalAmount - addDiscount;

		}

		else {

			System.out.println("User is not eligible for any % based discount:");
			// finalAmount=finalAmount;
		}

		System.out.println("final amount customer needs to pay::" + finalAmount);

		return finalAmount;
	}

}
