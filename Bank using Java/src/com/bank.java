package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.CustomerModel;

public class Bank {
	List<CustomerModel> customerList = new ArrayList<CustomerModel>();
	LoginModel loginModelObj = new LoginModel();
	CustomerModel customerModelObj = new CustomerModel();
	Scanner sc = new Scanner(System.in);

	int validate() {
		int flag = 0;
		System.out.println("Enter Your username");
		loginModelObj.setUsername(sc.next());
		System.out.println("Enter Your password");
		loginModelObj.setPassword(sc.next());
		for (CustomerModel c : customerList) {
			if (loginModelObj.getUsername().equals(c.getUsername())) {
				if(loginModelObj.getPassword().equals(c.getPassword()))
					System.out.println("Password Incorrect!");
				customerModelObj = c;
				System.out.println(customerModelObj.getAccountNumber());
				flag = 1;
				break;
			}
		}
		return flag;
	}

	// function to create account
	public void Register() {

		CustomerModel customerModelObj = new CustomerModel();
		System.out.println("Welcome to Bank of Pune");

		System.out.println("Enter Your Name");
		customerModelObj.setName(sc.next());

		System.out.println("Enter Your Age");
		customerModelObj.setAge(sc.nextInt());
		customerModelObj.setAccountNumber(generateAccountNumber());

		System.out.println("Congratulations Your Account is Created Successfully");

		System.out.println("Your Account Number is " + (customerModelObj.getAccountNumber()));

		System.out.println("Set Username for your account");
		customerModelObj.setUsername(sc.next());
		System.out.println("Set Password for your account");
		customerModelObj.setPassword(sc.next());

		System.out.println(
				"Your Data is Registered!!!\nYou can start using our services by logging in. \nHappy Banking!!!");
		System.out.println("Your Initial Balance is : " + customerModelObj.getBalance());
		customerList.add(customerModelObj);
	}

	public int generateAccountNumber() {

		int accountNumber = 101;
		for (CustomerModel c : customerList) {
			++accountNumber;
		}
		return accountNumber;
	}

	public void Login() {
		int access = validate();
		boolean flag = true;
		if (access == 1) {
			System.out.println("Login Successful!!!");
			dashboardMenu();
		} else {
			System.out.println("Login Failed!!!\n" + "Please enter valid credentials");
		}
	}

	private void dashboardMenu() {
		boolean flag = true;
		while (flag) {
			System.out.println("\n\nWelcome to Bank of Pune, The Bank Of Richest");
			System.out.println("1.Deposit Amount");
			System.out.println("2.Withdraw Amount");
			System.out.println("3.Get Account Details");
			System.out.println("4.Get Bank Balance ");
			System.out.println("5.Exit");
			int choice;
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
			case 3:
				fundTransfer();
			case 4:
				getAccountDetails();
				break;
			case 5:
				System.out.println("================================");
				System.out.println("Your Bank Balance is " + customerModelObj.getBalance());
				System.out.println("================================");
				break;
			case 6:
				flag = false;
				break;
			}
		}
	}

	public void deposit() {
		System.out.println("Enter the Amount You want to Deposit");
		double depositAmount = sc.nextDouble();
		double updatedBalance = customerModelObj.getBalance() + depositAmount;
	}

	public void withdraw() {
		System.out.println("Enter the Amount You want to Withdraw");
		double withdrawAmount = sc.nextDouble();
		try {
			if (customerModelObj.getBalance() == 1000 && (customerModelObj.getBalance() - withdrawAmount) < 1000)
				throw new MinimumBalance();
			else
				customerModelObj.setBalance(customerModelObj.getBalance() - withdrawAmount);
		} catch (MinimumBalance m) {
			System.out.println(m);
		}
	}

	public void getAccountDetails() {
		System.out.println("========================================");
		System.out.println("Name " + customerModelObj.getName());
		System.out.println("Age  " + customerModelObj.getAge());
		System.out.println("Balance " + customerModelObj.getBalance());
		System.out.println("========================================");
	}

	private void fundTransfer() {

	}

	public void mainMenu() {
		System.out.println("Welcome to Bank of Pune, The Bank Of Richest");
		System.out.println("1.Register");
		System.out.println("2.Login");
		int choice;
		System.out.println("Enter Your Choice");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			Register();
			break;
		case 2:
			Login();
			break;
		}
	}

	public static void main(String[] args) {
		Bank a = new Bank();
		while (true) {
			a.mainMenu();
		}
	}
}