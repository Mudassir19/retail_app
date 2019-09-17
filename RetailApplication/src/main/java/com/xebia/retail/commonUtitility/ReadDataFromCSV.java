package com.xebia.retail.commonUtitility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.xebia.retail.model.ProductDetails;
import com.xebia.retail.model.UserDetails;

public class ReadDataFromCSV {

	 /**
	 * @param custName
	 * @return
	 */
	//getting customer data based on custName
	public  UserDetails readCustomerData(String custName) {
		 
		 	UserDetails dto=new UserDetails();

		 	InputStream inputStream =  getClass().getClassLoader().getResourceAsStream("UserDetails.csv");
	  
		 	BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        
	        String[] userDetails = null;
	       

	        try  {

	        	 br = new BufferedReader(new InputStreamReader(inputStream ));
	        	 while ((line = br.readLine()) != null) {

	                // use comma as separator
	              userDetails = line.split(cvsSplitBy);

	                if(userDetails[0].equals(custName)) {

	                	dto.setCustName(userDetails[0]);
	                	dto.setCustType(userDetails[1]);
	                	dto.setRegistrationDate(userDetails[2]);
	                break;
	                
	                } 

	            }
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
			return dto;
 
	 }
	 
	 
	 /**
	 * @param item
	 * @return
	 */
	//@getting product data based on prodPurchased
	public  ProductDetails readProductData(String prodName) {
		 
		 	ProductDetails dto=new ProductDetails();
		 	InputStream inputStream = 
		 	       getClass().getClassLoader().getResourceAsStream("ProductDetails.csv");
		 	
	        
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        
	        String[] userDetails = null;
	       

	        try  {
 	
	        	 br = new BufferedReader(new InputStreamReader(inputStream ));

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	              userDetails = line.split(cvsSplitBy);

	              if(prodName.equals(userDetails[0])) {

	                	dto.setProdName(userDetails[0]);
	                	dto.setProdCategory(userDetails[1]);
	                	dto.setPrice(Double.parseDouble(userDetails[2]));
	   
	                	
	                break;
	               
	                
	                } 
	              
	            }
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
			return dto;

	 }
	 
	 
//	 public static void main(String[] args) {
//		 
//		 ReadDataFromCSV obj=new ReadDataFromCSV();
//		 UserDTO user=obj.readCustomerData("Mudassir");
//		 
//		 System.out.println(user.toString());
//		 
//		 ProductDTO prod=obj.readProductData("TV");
//		 
//		 System.out.println(prod.toString());
//		 
//
//	}
	 
	}