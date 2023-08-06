package com.admin.updateproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.Design;
import com.utility.EstablishConnection;

public class UpdateProductName {

	public void updateName() {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);

		try {
			con = EstablishConnection.getConnection();//

			ps = con.prepareStatement("update product set productName=? where productId=?");
			
			System.out.println("Update the name of product ");
			String name = input.nextLine();
			System.out.println("Enter the id of product you want to update the Name : ");
			int productId = input.nextInt();
			ps.setString(1, name);
			ps.setInt(2, productId);

			@SuppressWarnings("unused")
			int update = ps.executeUpdate();

			System.out.println(productId + " Product updated Successfully...");
			System.out.println("------------------------------------");
		} catch (Exception e) {
			System.out.println("please use Alphabets for product Name");
			this.updateName();
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
