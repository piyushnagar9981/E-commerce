package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.exception.UserNotFoundException;
import com.main.Design;
import com.order.AddToCart;
import com.utility.EstablishConnection;

public class UserLogin {

	public void login() {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);

		try {
			con = EstablishConnection.getConnection();
			ps = con.prepareStatement("select * from USERREGISTRATION");
			System.out.println("Enter User Name :");
			String username = input.next();
			System.out.println("Enter Password :");
			String userPassword = input.next();

			ResultSet result = ps.executeQuery();
			if (result.next()) {
				if (username.equals(result.getString("userName"))) {
					if (userPassword.equals(result.getString("password"))) {
						System.out.println("Login Successfull");
                        System.out.println("-------------------");
                        Design d = new Design();
                        d.orderOperation();
                       
					} 
				}else {
					new UserNotFoundException("User Not found, please check your login in credentials");

				}
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

}
