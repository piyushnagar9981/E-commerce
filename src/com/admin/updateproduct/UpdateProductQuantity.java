package com.admin.updateproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.utility.EstablishConnection;

public class UpdateProductQuantity {

	public void updateQuantity() {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);

		try {
			con = EstablishConnection.getConnection();//

			ps = con.prepareStatement("update product set availableQuantity=? where productId=?");
			
			System.out.println("Update the quantity of product ");
			int quantity = input.nextInt();
			System.out.println("Enter the id of product you want to update the Quantity : ");
			int productId = input.nextInt();
			ps.setInt(1, quantity);
			ps.setInt(2, productId);

			@SuppressWarnings("unused")
			int update = ps.executeUpdate();

			System.out.println(productId + " Product updated Successfully...");
			System.out.println("------------------------------------");
		} catch (Exception e) {
			System.out.println("please Enter Numeric values for Quantity");
			this.updateQuantity();
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
