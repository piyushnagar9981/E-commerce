package com.order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.Design;
import com.utility.EstablishConnection;

public class AddToCart {

	
	public void addProductToCart() {

		Connection con = null;
		java.sql.PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);

		try {

			con = EstablishConnection.getConnection();//

			ps = con.prepareStatement("insert into Cart (productId,quantity) values(?,?)");

			System.out.println("Enter number of product you want to add to Cart : ");
			int count = input.nextInt();
			for (int i = 1; i <= count; i++) {
				System.out.println("Enter Product Id :");
				int productId = input.nextInt();
				System.out.println("Enter Product Quantity :");
				int quantity = input.nextInt();

				ps.setInt(1, productId);
				ps.setInt(2, quantity);

				int add = ps.executeUpdate();

				System.out.println(add + " Product added Successfully...");
				System.out.println("------------------------------------");
				Design d = new Design();
				d.orderOperation();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
}
