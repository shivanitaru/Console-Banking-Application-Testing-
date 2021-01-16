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
				if (loginModelObj.getPassword().equals(c.getPassword()))
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

		System.out.println("Enter Your Name : ");
		customerModelObj.setName(sc.next());

		System.out.println("Enter Your Age : ");
		customerModelObj.setAge(sc.nextInt());

		System.out.println("Enter Your Mobile Number : ");
		customerModelObj.setMobileNumber(sc.nextLong());

		System.out.println("Enter Your Email Id : ");
		customerModelObj.setEmailId(sc.next());

		System.out.println("Enter Your Aadhaar Number : ");
		customerModelObj.setAadhaarNumber(sc.nextLong());

		while (true) {
			System.out.println("Choose Your Account Type : \n" + "1. Saving\n" + "2. Current");
			int accountChoice = sc.nextInt();
			switch (accountChoice) {
			case 1:
				customerModelObj.setAccountType("Saving Account");
				break;
			case 2:
				customerModelObj.setAccountType("Current Account");
				break;
			default:
				System.out.println("\nInvalid Choice! Try Again...\n");
			}
			if (customerModelObj.getAccountType() != null)
				break;
		}

		while (true) {
			System.out.println(
					"Choose Your Branch : \n" + "1. Hadapsar\n" + "2. Swargate\n" + "3. JM Road\n" + "4. Bund Garden");
			int branchChoice = sc.nextInt();

			switch (branchChoice) {
			case 1:
				customerModelObj.setBranchName("Hadapsar");
				break;
			case 2:
				customerModelObj.setBranchName("Swargate");
				break;
			case 3:
				customerModelObj.setBranchName("JM Road");
				break;
			case 4:
				customerModelObj.setBranchName("Bund Garden");
				break;
			default:
				System.out.println("\nInvalid Choice! Try Again...");
			}
			if (customerModelObj.getBranchName() != null)
				break;
		}

		customerModelObj.setAccountNumber(generateAccountNumber());

		System.out.println("Congratulations Your Account is Created Successfully");

		System.out.println("Your Account Number is " + (customerModelObj.getAccountNumber()));

		System.out.println("Set Username for your account");
		customerModelObj.setUsername(sc.next());
		System.out.println("Set Password for your account");
		customerModelObj.setPassword(sc.next());
		
		customerModelObj.setBalance(2500);
		System.out.println(
				"Your Data is Registered!!!\nYou can start using our services by logging in. \nHappy Banking!!!");
		System.out.println("Your Initial Balance is : Rs" + customerModelObj.getBalance());
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
		if (access == 1) {
			System.out.println("Login Successful!!!");
			dashboardMenu();
		} else {
			System.out.println("\nLogin Failed!!!\n\n" + "Please enter valid credentials");
		}
	}

	private void dashboardMenu() {
		boolean flag = true;
		while (flag) {
			System.out.println("\n\nWelcome to Bank of Pune, The Bank Of Richest");
			System.out.println("1.Deposit Amount");
			System.out.println("2.Withdraw Amount");
			System.out.println("3.Fund Transfer");
			System.out.println("4.Get Account Details");
			System.out.println("5.Get Bank Balance ");
			System.out.println("6.Exit");
			int choice;
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				fundTransfer();
				break;
			case 4:
				getAccountDetails();
				break;
			case 5:
				viewBalance();
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
		customerModelObj.setBalance(customerModelObj.getBalance() + depositAmount);
		viewBalance();
	}

	public void withdraw() {
		System.out.println("Enter the Amount You want to Withdraw");
		double withdrawAmount = sc.nextDouble();
		try {
			if (customerModelObj.getBalance() == 1000 && (customerModelObj.getBalance() - withdrawAmount) < 1000)
				throw new MinimumBalance();
			else{
				customerModelObj.setBalance(customerModelObj.getBalance() - withdrawAmount);
				viewBalance();
			}
		} catch (MinimumBalance m) {
			System.out.println(m);
		}
	}

	public void getAccountDetails() {
		System.out.println("========================================");
		System.out.println("Name \t\t\t: " + customerModelObj.getName());
		System.out.println("Age  \t\t\t: " + customerModelObj.getAge());
		System.out.println("Mobile Number \t\t: " + customerModelObj.getMobileNumber());
		System.out.println("Email Id \t\t: " + customerModelObj.getEmailId());
		System.out.println("Aadhaar Number \t\t: " + customerModelObj.getAadhaarNumber());
		System.out.println("Account Type \t\t: " + customerModelObj.getAccountType());
		System.out.println("Branch Name \t\t: " + customerModelObj.getBranchName());
		System.out.println("Balance \t\t: " + customerModelObj.getBalance());
		System.out.println("========================================");
	}

	private void viewBalance(){
		System.out.println("================================");
		System.out.println("Your Bank Balance is " + customerModelObj.getBalance());
		System.out.println("================================");
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