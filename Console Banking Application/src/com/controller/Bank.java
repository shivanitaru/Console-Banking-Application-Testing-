package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.MinimumBalance;
import com.model.CustomerModel;
import com.model.LoginModel;

public class Bank {
	public List<CustomerModel> customerList = new ArrayList<CustomerModel>();
	public LoginModel loginModelObj = new LoginModel();
	public CustomerModel customerModelObj = new CustomerModel();
	public double depositAmount = 0.0;
	public double withdrawAmount = 0.0;
	public int beneficiaryAccountNumber = 0;
	public double fundTransferAmount = 0.0;
	Scanner sc = new Scanner(System.in);

	int validate() {
		int flag = 0;
		System.out.println("Enter Your username:");
		loginModelObj.setUsername(sc.next());
		System.out.println("Enter Your password:");
		loginModelObj.setPassword(sc.next());
		for (CustomerModel c : customerList) {
			if (loginModelObj.getUsername().equals(c.getUsername())) {
				if (!loginModelObj.getPassword().equals(c.getPassword())) {
					System.out.println("Password Incorrect!!");
					break;
				} else {
					customerModelObj = c;
					System.out.println(customerModelObj.getAccountNumber());
					flag = 1;
					break;
				}
			}
		}
		return flag;
	}

	// function to create account
	public void Register() {
		CustomerModel customerModelRegObj = new CustomerModel();
		System.out.println("\nWelcome to Bank of Pune!!");

		System.out.println("Enter Your Name : ");
		customerModelRegObj.setName(sc.next());

		System.out.println("Enter Your Age : ");
		customerModelRegObj.setAge(sc.nextInt());

		System.out.println("Enter Your Mobile Number : ");
		customerModelRegObj.setMobileNumber(sc.nextLong());

		System.out.println("Enter Your Email Id : ");
		customerModelRegObj.setEmailId(sc.next());

		System.out.println("Enter Your Aadhaar Number : ");
		customerModelRegObj.setAadhaarNumber(sc.nextLong());

		while (true) {
			System.out.println("Choose Your Account Type : \n" + "\t1. Saving\n" + "\t2. Current");
			int accountChoice = sc.nextInt();
			switch (accountChoice) {
			case 1:
				customerModelRegObj.setAccountType("Saving Account");
				break;
			case 2:
				customerModelRegObj.setAccountType("Current Account");
				break;
			default:
				System.out.println("\nInvalid Choice! Try Again...\n");
			}
			if (customerModelRegObj.getAccountType() != null)
				break;
		}

		while (true) {
			System.out.println("Choose Your Branch : \n" + "\t1. Hadapsar\n" + "\t2. Swargate\n" + "\t3. JM Road\n"
					+ "\t4. Bund Garden");
			int branchChoice = sc.nextInt();

			switch (branchChoice) {
			case 1:
				customerModelRegObj.setBranchName("Hadapsar");
				break;
			case 2:
				customerModelRegObj.setBranchName("Swargate");
				break;
			case 3:
				customerModelRegObj.setBranchName("JM Road");
				break;
			case 4:
				customerModelRegObj.setBranchName("Bund Garden");
				break;
			default:
				System.out.println("\nInvalid Choice! Try Again...");
			}
			if (customerModelRegObj.getBranchName() != null)
				break;
		}

		customerModelRegObj.setAccountNumber(generateAccountNumber());

		System.out.println("Congratulations Your Account is Created Successfully!!");

		System.out.println("Your Account Number is " + (customerModelRegObj.getAccountNumber()));
		System.out.println("==============================");
		System.out.println("Set Username for your account:");
		customerModelRegObj.setUsername(sc.next());
		System.out.println("Set Password for your account:");
		customerModelRegObj.setPassword(sc.next());
		System.out.println("==============================");

		customerModelRegObj.setBalance(2500);
		System.out.println(
				"Your Data is Registered!!!\nYou can start using our services by logging in. \nHappy Banking!!!");
		System.out.println("Your Initial Balance is : Rs" + customerModelRegObj.getBalance());
		System.out.println("==============================");
		customerList.add(customerModelRegObj);
		customerModelObj = customerModelRegObj;
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
			// dashboardMenu();
		} else {
			System.out.println("\nLogin Failed!!!\n\n" + "Please enter valid credentials.");
		}
	}

	public void dashboardMenu() {
		boolean flag = true;
		while (flag) {
			System.out.println("\n\nWelcome to Bank of Pune, The Bank Of Richest!!");
			System.out.println("1.Deposit Amount");
			System.out.println("2.Withdraw Amount");
			System.out.println("3.Fund Transfer");
			System.out.println("4.Get Account Details");
			System.out.println("5.Get Bank Balance ");
			System.out.println("6.Exit");
			int choice;
			System.out.println("Enter Your Choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				System.out.println("Enter Beneficiary Account Number:");
				beneficiaryAccountNumber = sc.nextInt();
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
		System.out.println("Enter the Amount You want to Deposit:");
		depositAmount = sc.nextDouble();
		customerModelObj.setBalance(customerModelObj.getBalance() + depositAmount);
		viewBalance();
	}

	public void withdraw() {
		System.out.println("Enter the Amount You want to Withdraw:");
		withdrawAmount = sc.nextDouble();
		try {
			if (customerModelObj.getBalance() == 1000 || (customerModelObj.getBalance() - withdrawAmount) < 1000)
				throw new MinimumBalance();
			else {
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

	public double viewBalance() {
		double balance = customerModelObj.getBalance();
		System.out.println("================================");
		System.out.println("Your Bank Balance is " + balance);
		System.out.println("================================");
		return balance;
	}

	public void fundTransfer() {
		int flag = 0;
		for (CustomerModel c : customerList) {
			if (beneficiaryAccountNumber == customerModelObj.getAccountNumber()) {
				System.out.println("Sorry, You have entered invalid beneficiary account number!! ");
				flag = 1;
				break;
			} else if (beneficiaryAccountNumber == c.getAccountNumber()) {
				System.out.println("Enter the Amount You want to transfer to the given beneficiary account: ");
				fundTransferAmount = sc.nextDouble();
				try {
					if (customerModelObj.getBalance() == 1000
							|| (customerModelObj.getBalance() - fundTransferAmount) < 1000)
						throw new MinimumBalance();
					else {
						customerModelObj.setBalance(customerModelObj.getBalance() - fundTransferAmount);
						c.setBalance(c.getBalance() + fundTransferAmount);
						System.out.println("Amount has been successfully transferred!!");
						viewBalance();
					}
				} catch (MinimumBalance m) {
					System.out.println(m);
				}
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Sorry, No such account with the given beneficiary account number is found!!");
		}
	}

	public void mainMenu() {
		boolean flag = true;
		System.out.println("Welcome to Bank of Pune, The Bank Of Richest!!");
		System.out.println("\t1. Register");
		System.out.println("\t2. Login");
		System.out.println("\t3. Exit");
		int choice;
		System.out.println("Enter Your Choice:");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			Register();
			break;
		case 2:
			Login();
			break;
		case 3:
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Bank a = new Bank();

		while (true) {
			a.mainMenu();
		}
	}
}