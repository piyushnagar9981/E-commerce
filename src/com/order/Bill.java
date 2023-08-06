package com.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.utility.EstablishConnection;

public class Bill {

	public void buyProduct(String userName, int productId, int quantity) {
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);
		try {
			con = EstablishConnection.getConnection();//
			ps = con.prepareStatement("insert into buyProduct(userName,productId,quantity,pricePerUnit,total_Price) values(?,?,?,?,?)");
			
			ps.setString(1, userName);
			ps.setInt(2, productId);
			ps.setInt(3, quantity);
			int pricePerUnit=this.getPrice(productId);
			ps.setInt(4, pricePerUnit);
			int totalPrice=quantity * pricePerUnit;
			ps.setInt(5, totalPrice);
			int i = ps.executeUpdate();
			System.out.println(i + " product added Successfully...");

			System.out.println("Want to buy more products enter \"Y\" else enter anyKey ");
			String addMore = input.next();
            if(addMore.equalsIgnoreCase("y")) {
            	this.addProduct();
            }else {
            	System.out.println("\n************ Bill *****************");
        		System.out.println("Customer Name    : " + userName);
        		System.out.println("Product Id       : " + productId);
        		System.out.println("Quantity         : " + quantity);
        		System.out.println("Price per unit   : " + pricePerUnit);
        		System.out.println("Total Amount     : " + totalPrice);
        		System.out.println("**************************************");
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null || ps != null) {
					con.close();
					ps.close();
					input.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//===============================================================================================================================
	public  int getPrice(int productId) {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		int price = 0;
		try {
			con = EstablishConnection.getConnection();
			ps = con.prepareStatement("select price from product where productId=?");
			ps.setInt(1, productId);
			ResultSet result = ps.executeQuery();
			while (result.next() != false) {

			   price = result.getInt("price");
				//System.out.println("Product price >> " + price);
				System.out.println("------------------------------------------------------------------");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null || ps != null) {
					con.close();
					ps.close();
                   
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return price;

	}
	//==================================================================================================================================================
	
	public void addProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter User Name :");
		String userName = input.next();
		System.out.println("Enter Product Id :");
		int productId = input.nextInt();
		System.out.println("Enter Product Quantity :");
		int quantity = input.nextInt();

		this.buyProduct(userName, productId, quantity);
		input.close();
	}

}
