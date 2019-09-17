package com.xebia.retail.commonUtitility;
public class ShopingCart {

	/**
	 * @param discount
	 * @param totalAmount
	 * @return
	 */
	public double calculateTotalBill(int discount,double totalAmount) {

		System.out.println("Total Amount is:"+totalAmount);
		
		int addDiscount = 0;
		
		double s,finalAmount = 0;
		
		if(totalAmount>100) {
			
			addDiscount=(int) (totalAmount/100)*5;
			finalAmount=totalAmount-addDiscount;
			System.out.println("User is eligible for additional discount:"+addDiscount);
		}
		
		if(discount>1) {
			
			s=totalAmount*discount;
			double perAmount=s/100;
			System.out.println("User is eligible for % "+discount+" Discount:"+perAmount);
			totalAmount=totalAmount-perAmount;

			finalAmount=totalAmount-addDiscount;
				
		}
		
		else {
			
			System.out.println("User is not eligible for any % based discount:");
			//finalAmount=finalAmount;
		}
			
			

		System.out.println("final amount customer needs to pay::"+finalAmount);
		
		return finalAmount;
	}
	
	/*public static void main(String[] args) {
		
	ShopingCart obj=new ShopingCart();
	double amt=	obj.calculateTotalBill(0, 99);
	System.out.println(amt);
		
	}*/
	
}
