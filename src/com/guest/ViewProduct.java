package com.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.Design;
import com.utility.EstablishConnection;

public class ViewProduct {

	public void getProductDetails() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = EstablishConnection.getConnection();
			ps = con.prepareStatement("select * from product");
			ResultSet result = ps.executeQuery();
			while (result.next() != false) {
				System.out.println("Product Id >> " + result.getString("productId"));
				System.out.println("Product Name >> " + result.getString("productName"));
				System.out.println("Discription >> " + result.getString("Discription"));
				System.out.println("Product price >> " + result.getString("price"));
				System.out.println("Available Quantity >> " + result.getString("availableQuantity"));
				System.out.println("------------------------------------------------------------------");
				System.out.println();
			}
			System.out.println(
					"Note : Guest can only view Product. \n      To buy product please get Register \n       and login to place your order");
			System.out.println("------------------------------------------");
			Design d = new Design();
			d.selectPrimaryOperation();
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

	}
}