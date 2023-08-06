package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.Design;
import com.utility.EstablishConnection;

public class UserPurchaseHistroy {


	public void getUserPurchaseHistroy() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = EstablishConnection.getConnection();
			ps = con.prepareStatement("select * from BUYPRODUCT");
			ResultSet result = ps.executeQuery();
			while (result.next() != false) {
				System.out.println("Order Id      >> " + result.getInt("id"));
				System.out.println("User Name     >> " + result.getString("userName"));
				System.out.println("Product Id    >> " + result.getString("productId"));
				System.out.println("Quantity      >> " + result.getString("quantity"));
				System.out.println("Product price >> " + result.getString("pricePerUnit"));
				System.out.println("Total Bill    >> " + result.getString("total_price"));
				System.out.println("------------------------------------------------------------------");
				System.out.println();
			}
           Design d= new Design();
           d.AdminPanelOperation();
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
