package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.admin.AddProduct;
import com.admin.AdminLogin;
import com.admin.UserData;
import com.admin.UserPurchaseHistroy;
import com.admin.updateproduct.UpdateProductDiscription;
import com.admin.updateproduct.UpdateProductName;
import com.admin.updateproduct.UpdateProductPrice;
import com.admin.updateproduct.UpdateProductQuantity;
import com.order.AddToCart;
import com.order.Bill;
import com.user.UserLogin;
import com.user.UserRegistration;
import com.user.ViewProduct;

public class Design {

	// =================================================================================================================//
	public void menu1() {
		System.out.println("1.Admin Panel");
		System.out.println("2.User Panel");
		System.out.println("3.Use as Guest");
		System.out.println("====================");
		System.out.println("Please Select the Operation you want to perform");
		System.out.println("-----------------------------------------------");
	}

	public void menu2() {
		System.out.println("1.User Registration");
		System.out.println("2.User Login");
		System.out.println("3.Exit");
		System.out.println("====================");
		System.out.println("Please Select the Operation you want to perform");
		System.out.println("-----------------------------------------------");
	}

	public void menu3() {
		System.out.println("1.View Product");
		System.out.println("2.Add Product");
		System.out.println("3.Update Product");
		System.out.println("4.View User Details");
		System.out.println("5.User Purchase History");
		System.out.println("6.Exit");

		System.out.println("====================");
		System.out.println("Please Select the Operation you want to perform");
		System.out.println("-----------------------------------------------");
	}

	public void menu4() {
		System.out.println("1.View Product");
		System.out.println("2.Add to Cart");
		System.out.println("3.Buy Product");
		System.out.println("4.Exit");

		System.out.println("====================");
		System.out.println("Please Select the Operation you want to perform");
		System.out.println("-----------------------------------------------");
	}

	public void menu5() {
		System.out.println("1.Update product Name");
		System.out.println("2.Update product Discription");
		System.out.println("3.Update product price");
		System.out.println("4.Update product Quantity");
		System.out.println("5.Exit");

		System.out.println("====================");
		System.out.println("Please Select the Operation you want to perform");
		System.out.println("-----------------------------------------------");
	}
	// =================================================================================================================//

	public void selectPrimaryOperation() {
		Scanner input = new Scanner(System.in);
		this.menu1();
		try {
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("You have Selected Admin Panel");
				System.out.println("-----------------------------");
				System.out.println("Please Enter Login credentials to get Access");
				System.out.println("----------------------------------------------");
				AdminLogin login = new AdminLogin();
				login.login();

				break;
			case 2:
				System.out.println("You have Selected User Panel");
				System.out.println("----------------------------");
				this.userPanelOperation();

				break;
			case 3:
				System.out.println("You have Selected Use as Guest");
				System.out.println("------------------------------");
				com.guest.ViewProduct product = new com.guest.ViewProduct();
				product.getProductDetails();

				break;
			default:
				System.out.println("Invalid Input, please try again by entering correct option between 1 to 3");
				System.out.println("----------------------------------------------------------");

				this.selectPrimaryOperation();
			}
		} catch (InputMismatchException e) {
			System.out.println("please Enter Numeric values between 1-3");
			System.out.println("---------------------------------------");
			this.selectPrimaryOperation();

		} finally {
			input.close();
		}

	}

	// =================================================================================================================//

	public void userPanelOperation() {
		Scanner input = new Scanner(System.in);
		this.menu2();
		try {
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("You have Selected User Registration");
				System.out.println("-----------------------------------");
				UserRegistration register = new UserRegistration();
				register.registerUser();

				break;
			case 2:
				System.out.println("You have Selected User Login");
				System.out.println("----------------------------");
				UserLogin newLogin = new UserLogin();
				newLogin.login();

				break;
			case 3:
				System.out.println("You have Selected to Exit, please wait we are taking you to the Home Page");
				System.out.println("-------------------------------------------------------------------------");
				this.selectPrimaryOperation();
				break;
			default:
				System.out.println("Invalid Input, please try again by entering correct option between 1 to 3");
				System.out.println("-------------------------------------------------------------------------");

				this.userPanelOperation();
			}
		} catch (InputMismatchException e) {
			System.out.println("please Enter Numeric values between 1-3");
			System.out.println("---------------------------------------");
			this.userPanelOperation();
		} finally {
			input.close();
		}
	}

	// =================================================================================================================//

	public void AdminPanelOperation() {
		Scanner input = new Scanner(System.in);
		this.menu3();
		try {
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("You have Selected View Product");
				System.out.println("-----------------------------------");
				com.admin.ViewProduct viewProduct = new com.admin.ViewProduct();
				viewProduct.getProductDetails();

				break;
			case 2:
				System.out.println("You have Selected Add Product");
				System.out.println("----------------------------");
				AddProduct addProduct = new AddProduct();
				addProduct.addProduct();

				break;
			case 3:
				System.out.println("You have Selected Update Product");
				System.out.println("----------------------------");
				this.updateProduct();
				break;
			case 4:
				System.out.println("You have Selected view User Details");
				System.out.println("------------------------------------");
				UserData userData = new UserData();
				userData.getUserDetails();
				break;
			case 5:
				System.out.println("You have Selected view User Purchase History");
				System.out.println("--------------------------------------------");
                 UserPurchaseHistroy history = new UserPurchaseHistroy();
                 history.getUserPurchaseHistroy();
				break;
			case 6:
				System.out.println("You have Selected to Exit, please wait we are taking you to the Home Page");
				System.out.println("-------------------------------------------------------------------------");
				this.selectPrimaryOperation();
				break;
			default:
				System.out.println("Invalid Input, please try again by entering correct option between 1 to 3");
				System.out.println("-------------------------------------------------------------------------");

				this.AdminPanelOperation();
			}
		} catch (InputMismatchException e) {
			System.out.println("please Enter Numeric values between 1-5");
			System.out.println("---------------------------------------");
			this.AdminPanelOperation();
		} finally {
			input.close();
		}
	}

//========================================================================================================
	public void orderOperation() {
		Scanner input = new Scanner(System.in);
		this.menu4();
		try {
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("You have Selected View product");
				System.out.println("-----------------------------------");
				ViewProduct product = new ViewProduct();
				product.getProductDetails();

				break;
			case 2:
				System.out.println("You have Selected Add to cart");
				System.out.println("-----------------------------------");
				AddToCart cart = new AddToCart();
				cart.addProductToCart();

				break;
			case 3:
				System.out.println("You have Selected Buy Product");
				System.out.println("----------------------------");
				Bill buy = new Bill();
				buy.addProduct();

				break;
			case 4:
				System.out.println("You have Selected to Exit, please wait we are taking you to the Home Page");
				System.out.println("-------------------------------------------------------------------------");
				this.userPanelOperation();
				break;
			default:
				System.out.println("Invalid Input, please try again by entering correct option between 1 to 3");
				System.out.println("-------------------------------------------------------------------------");

				this.orderOperation();
			}
		} catch (InputMismatchException e) {
			System.out.println("please Enter Numeric values between 1-5");
			System.out.println("---------------------------------------");
			this.orderOperation();
		} finally {
			input.close();
		}
	}

	// =============================================================================================================

	public void updateProduct() {
		Scanner input = new Scanner(System.in);
		this.menu5();
		try {
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("You have Selected to update product Name");
				System.out.println("-----------------------------------");
				UpdateProductName name = new UpdateProductName();
				name.updateName();
				break;
			case 2:
				System.out.println("You have Selected to update product Discription");
				System.out.println("-----------------------------------");
				UpdateProductDiscription discription = new UpdateProductDiscription();
				discription.updateDiscription();
				break;
			case 3:
				System.out.println("You have Selected to update product Price");
				System.out.println("----------------------------");
				UpdateProductPrice price = new UpdateProductPrice();
				price.updatePrice();
				break;
			case 4:
				System.out.println("You have Selected to update product Quantity");
				System.out.println("----------------------------");
				UpdateProductQuantity quantity = new UpdateProductQuantity();
				quantity.updateQuantity();
				break;
			case 5:
				System.out.println("You have Selected to Exit, please wait we are taking you to the Home Page");
				System.out.println("-------------------------------------------------------------------------");
				this.AdminPanelOperation();
				break;
			default:
				System.out.println("Invalid Input, please try again by entering correct option between 1 to 3");
				System.out.println("-------------------------------------------------------------------------");
				this.updateProduct();
			}
		} catch (InputMismatchException e) {
			System.out.println("please Enter Numeric values between 1-5");
			System.out.println("---------------------------------------");
			this.updateProduct();
		} finally {
			input.close();
		}
	}
}
