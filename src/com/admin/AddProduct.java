package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.main.Design;
import com.utility.EstablishConnection;

public class AddProduct {

	public void addProduct() {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner input = new Scanner(System.in);

		try {

			con = EstablishConnection.getConnection();//

			ps = con.prepareStatement("insert into product values(?,?,?,?,?)");

			System.out.println("Enter number of product you want to add : ");
			int count = input.nextInt();
			for (int i = 1; i <= count; i++) {
				System.out.println("Enter Product Id :");
				int productId = input.nextInt();
				System.out.println("Enter Product Name :");
				String productName = input.next();
				System.out.println("Enter Product Discrption :");
				input.next();
				String discription = input.nextLine();
				System.out.println("Enter Product price :");
				int price = input.nextInt();
				System.out.println("Enter Product Availabale Quantity :");
				int availableQuantity = input.nextInt();
				ps.setInt(1, productId);
				ps.setString(2, productName);
				ps.setString(3, discription);
				ps.setInt(4, price);
				ps.setInt(5, availableQuantity);

				int add = ps.executeUpdate();

				System.out.println(add + " Product added Successfully...");
				System.out.println("------------------------------------");
				Design d = new Design();
				d.AdminPanelOperation();
			}
		} catch (Exception e) {
			System.out.println("product with this Id is already exist in our system");
			Design d = new Design();
			d.AdminPanelOperation();
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
