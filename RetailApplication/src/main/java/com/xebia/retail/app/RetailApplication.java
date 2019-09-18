package com.xebia.retail.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import com.xebia.retail.commonUtitility.ReadDataFromCSV;
import com.xebia.retail.commonUtitility.ShopingCart;
import com.xebia.retail.factorypattern.AffiliateCustomerDiscount;
import com.xebia.retail.factorypattern.Discount;
import com.xebia.retail.factorypattern.DurationDiscount;
import com.xebia.retail.factorypattern.EmployeeDiscount;
import com.xebia.retail.factorypattern.GeneralDiscount;
import com.xebia.retail.factorypattern.ZeroDiscount;
import com.xebia.retail.model.ProductDetails;
import com.xebia.retail.model.UserDetails;

/**
 * @author Mudassir
 * 
 *
 */
public class RetailApplication {

	/**
	 * @param loggedUserName
	 * @param prodPurchased  Reading Data from CSV files based on loggedUserName &
	 *                       prodPurchased
	 * @return
	 * @throws ParseException
	 */
	public Discount getDiscountDetails(String loggedUserName, String prodPurchased) throws ParseException {

		ReadDataFromCSV obj = new ReadDataFromCSV();

		// Getting user details fromCSV File based on loggedUserName
		UserDetails userDetails = obj.readCustomerData(loggedUserName);

		// Product Details from csv file based on prodPurchased
		ProductDetails prodDetails = obj.readProductData(prodPurchased);

		if ((prodDetails.getProdCategory().equals("Groceries"))) {

			if (prodDetails.getPrice() > 100) {

				return new GeneralDiscount();
			}

			else {

				return new ZeroDiscount();

			}

		}

		switch (userDetails.getCustType()) {

		case "Employee":
			return new EmployeeDiscount();

		case "Affilaite":
			return new AffiliateCustomerDiscount();

		}

		int totalDuration = getDuration(userDetails.getRegistrationDate());

		if (totalDuration >= 2) {

			return new DurationDiscount();
		}
		if (prodDetails.getPrice() > 100) {

			return new GeneralDiscount();

		}

		return new ZeroDiscount();

	}

	/**
	 * @param date calculating duration of user
	 * @return
	 * @throws ParseException
	 */
	private static int getDuration(String date) throws ParseException {

		int duration = 0;
		try {

			DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
			Date date2 = (Date) formatter.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);
			String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
					+ cal.get(Calendar.YEAR);
			// logger.info("formatedDate : " + formatedDate);

			String[] splitDate = formatedDate.split("/");

			int days = Integer.parseInt(splitDate[0]);

			int month = Integer.parseInt(splitDate[1]);

			int years = Integer.parseInt(splitDate[2]);

			LocalDate endofCentury = LocalDate.of(years, month, days);
			LocalDate now = LocalDate.now();

			Period diff = Period.between(endofCentury, now);

			duration = diff.getYears();

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException("Invalid date[" + date + "]from userDetails csv file it should be dd-MMM-yy:");
		}

		return duration;
	}

	public static void main(String[] args) throws ParseException {

		RetailApplication obj = new RetailApplication();

		Discount discountDetails = obj.getDiscountDetails("Ravi", "TV"); // kindly provide the customer name & prod
																				// name from csv
		int discount = discountDetails.getDiscount(); // It will return applicable discount to the customer

		if (discount >= 1) {
			ShopingCart cart = new ShopingCart(); // calculating total bill
			cart.calculateTotalBill(discount, 10000); // need to provide prodAmount from csv file
		}

	}
}
