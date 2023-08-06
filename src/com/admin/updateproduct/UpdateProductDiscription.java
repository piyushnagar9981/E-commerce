package com.admin.updateproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.utility.EstablishConnection;

public class UpdateProductDiscription {

	public void updateDiscription() {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);

		try {
			con = EstablishConnection.getConnection();//

			ps = con.prepareStatement("update product set discription=? where productId=?");

			System.out.println("Update the Discription of product ");
			String discription = input.nextLine();
			System.out.println("Enter the id of product you want to update the Discription : ");
			int productId = input.nextInt();
			ps.setString(1, discription);
			ps.setInt(2, productId);

			@SuppressWarnings("unused")
			int update = ps.executeUpdate();

			System.out.println(productId + " Product updated Successfully...");
			System.out.println("------------------------------------");
		} catch (Exception e) {
			System.out.println("please use alphanumeric values for Discription");
			this.updateDiscription();
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
