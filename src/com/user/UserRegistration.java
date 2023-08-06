package com.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.Design;
import com.utility.EstablishConnection;

public class UserRegistration {

	public void getRegistered(String firstName, String lastName, String userName, String password, String city,
			String eMail, long phone) {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		try {
			con = EstablishConnection.getConnection();
			ps = con.prepareStatement(
					"insert into UserRegistration(firstName,lastName,userName,password,city,email,phone) values(?,?,?,?,?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, userName);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, eMail);
			ps.setLong(7, phone);

			int registered = ps.executeUpdate();
			if (registered == 1) {
				System.out.println("You have been registered in our system Sucessfully");
	            Design d = new Design();
	            d.userPanelOperation();
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
	}

	public void registerUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Details : ");
		System.out.println("========================");

		System.out.println("Enter your first name : ");
		String firstName = input.next();
		System.out.println("Enter your last name : ");
		String lastName = input.next();
		System.out.println("Enter your User name : ");
		String userName = input.next();
		System.out.println("Enter your password  : ");
		String password = input.next();
		System.out.println("Enter your city : ");
		String city = input.next();
		System.out.println("Enter your email : ");
		String eMail = input.next();
		System.out.println("Enter your phone number : ");
		long phone = input.nextLong();
		this.getRegistered(firstName, lastName, userName, password, city, eMail, phone);
		input.close();
	}

}