package com.xebia.retail.app;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import com.xebia.retail.commonUtitility.ReadDataFromCSV;
import com.xebia.retail.commonUtitility.ShopingCart;
import com.xebia.retail.factorypattern.AffiliateCustomer;
import com.xebia.retail.factorypattern.DiscountNotApplicable;
import com.xebia.retail.factorypattern.Duration;
import com.xebia.retail.factorypattern.Employee;
import com.xebia.retail.factorypattern.GeneralDiscount;
import com.xebia.retail.factorypattern.User;
import com.xebia.retail.model.ProductDTO;
import com.xebia.retail.model.UserDTO;

/**
 * @author Mudassir
 * Date: 11 Sept 2019
 *
 */
public class RetailApplication {
	
	/**
	 * @param name
	 * @param item
	 * @return
	 * @throws ParseException
	 */
	public User getDiscount(String name,String item) throws ParseException {
		
		ReadDataFromCSV obj=new ReadDataFromCSV();
		
		//Getting user details fromCSV File based on customer name
		UserDTO userDetails=obj.readCustomerData(name);

		String empName=userDetails.getCustName();
	
		String empType =userDetails.getCustType();
	
		String duration=userDetails.getRegistrationDate();
	
		//Product Details from csv file based om item
		ProductDTO prodDetails=obj.readProductData(item);
		
		
		String prodName=prodDetails.getProdName();
		
		String prodCategory =prodDetails.getProdCategory();
	
		double price=prodDetails.getPrice();
		
		if( (empName != null && !empName.isEmpty()) && (prodName != null && !prodName.isEmpty()) ){
			
			if( (empType.equals("Employee")) && (!prodCategory.equals("Groceries")) ) {
				
				return new Employee();
			}
			
			else if( (empType.equals("Affilaite")) && (!prodCategory.equals("Groceries"))  ) {
				
				return new AffiliateCustomer();
				
			}
			else if ( (empType.equals("Others")) && (!prodCategory.equals("Groceries"))  ){
				
				int totalDuration=getDuration(duration);
				
				System.out.println("Time Period is:"+totalDuration);
				
				if(totalDuration>=2) {
				
				return new Duration();
				}
				if( (totalDuration<2) && (price>100)) {
					
					return new GeneralDiscount();
					
				}
			
				
				
			}
				else if(price>100) {
						
						return new GeneralDiscount();
					}
			
				else if(price<100) {
					
					System.out.println("Discount is not applicable");
					return new DiscountNotApplicable();
				}
		}
	
					else {
						
						System.out.println("Either Invalid User or Item not available");
						return new DiscountNotApplicable();
					}
			return null;
				
}	
			

	/**
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static int getDuration(String date) throws ParseException {

		int duration = 0;
		try {
			
			
			String dateStr =date;
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
			Date date2 = (Date)formatter.parse(dateStr);
			//System.out.println(date2);        

			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);
			String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			//System.out.println("formatedDate : " + formatedDate); 
			
			

			String[] str=formatedDate.split("/");

			int days=Integer.parseInt(str[0]);

			int month=Integer.parseInt(str[1]);	
			
			int years=Integer.parseInt(str[2]);

			LocalDate endofCentury = LocalDate.of(years, month, days);
			LocalDate now = LocalDate.now();
			 
			Period diff = Period.between(endofCentury, now);

			duration = diff.getYears();

		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		
		return duration;
	}
		

	public static void main(String[] args) throws IOException, ParseException {
		
		RetailApplication obj=new RetailApplication();
		
		User user=obj.getDiscount("Mudassir","TV"); // kindly provide the customer name & prod name from csv file 
		
		int discount=user.discount(); //It will return applicable discount to the customer
										
	
		//if(discount==null)
	
		System.out.println("Applicable Discount:"+discount);
		if(discount>=1) {
		ShopingCart cart=new ShopingCart();  // calculating total bill
		cart.calculateTotalBill(discount,10000); // need to provide prodAmount from csv file
		}
		
		
		
		
	}
}
