package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.Design;
import com.utility.EstablishConnection;

public class UserData {
	
	public void getUserDetails() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = EstablishConnection.getConnection();
			ps = con.prepareStatement("select * from UserRegistration");
			ResultSet result = ps.executeQuery();
			while (result.next() != false) {
				System.out.println("Enroll NO  >> " + result.getInt("id"));
				System.out.println("First Name >> " + result.getString("firstName"));
				System.out.println("Last Name  >> " + result.getString("lastName"));
				System.out.println("User Name  >> " + result.getString("userName"));
				System.out.println("Email      >> " + result.getString("eMail"));
				System.out.println("Phone      >> " + result.getLong("phone"));
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
