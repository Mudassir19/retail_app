package com.xebia.retail.commonUtitility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.xebia.retail.model.ProductDetails;
import com.xebia.retail.model.UserDetails;

public class ReadDataFromCSV {

	InputStream inputStream;
	String line = "";
	String cvsSplitBy = ",";
	String[] Details = null;

	/**
	 * @param custName getting customer data based on customerName
	 * @return
	 */

	public UserDetails readCustomerData(String custName) {

		UserDetails dto = new UserDetails();

		inputStream = getClass().getClassLoader().getResourceAsStream("UserDetails.csv");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

			// br = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				Details = line.split(cvsSplitBy);

				if (Details[0].equals(custName)) {
					dto.setCustName(Details[0]);
					dto.setCustType(Details[1]);
					dto.setRegistrationDate(Details[2]);
					break;

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;

	}

	/**
	 * @param items
	 * @getting product data based on prodPurchased
	 * @return
	 */
	public ProductDetails readProductData(String prodName) {

		ProductDetails dto = new ProductDetails();

		inputStream = getClass().getClassLoader().getResourceAsStream("ProductDetails.csv");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				Details = line.split(cvsSplitBy);

				if (prodName.equals(Details[0])) {

					dto.setProdName(Details[0]);
					dto.setProdCategory(Details[1]);
					dto.setPrice(Double.parseDouble(Details[2]));

					break;

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dto;

	}

}