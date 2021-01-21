package com.test.JUnitTestCase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.controller.Bank;
import com.model.CustomerModel;

public class TestFundTransfer {
	Bank bankObj = new Bank();
	Scanner sc = new Scanner(System.in);
	public List<CustomerModel> customerList = bankObj.customerList;

	@Test
	public void testFundTransfer() {
		while(true){
			bankObj.Register();
			System.out.println("Do you want to register one more account?\nPress 1 if Yes and 0 if No: ");
			int ch = sc.nextInt();
			if(ch==0){
				break;
			}
		}

		bankObj.Login();
		assertEquals("shivanitaru", bankObj.loginModelObj.getUsername());
		assertEquals("shivani@123", bankObj.loginModelObj.getPassword());

		double remitterBeforeBalance = bankObj.customerModelObj.getBalance();
		double beneficiaryBeforeBalance = 0.0;
		double remitterAfterBalance = remitterBeforeBalance;
		double beneficiaryAfterBalance;
		double testBeneficiaryAfterBalance = 0.0;
		System.out.println("Enter Beneficiary Account Number:");
		bankObj.beneficiaryAccountNumber = sc.nextInt();
		for (CustomerModel c : customerList) {
			System.out.println(c.getAccountNumber());
			if (c.getAccountNumber() == bankObj.beneficiaryAccountNumber) {
				beneficiaryBeforeBalance = c.getBalance();
			}
		}
		beneficiaryAfterBalance = beneficiaryBeforeBalance;
		bankObj.fundTransfer();
		remitterAfterBalance -= bankObj.fundTransferAmount;
		beneficiaryAfterBalance += bankObj.fundTransferAmount;
		assertEquals(remitterAfterBalance, bankObj.customerModelObj.getBalance(), 0.0);

		for (CustomerModel c : customerList) {
			if (c.getAccountNumber() == bankObj.beneficiaryAccountNumber) {
				testBeneficiaryAfterBalance = c.getBalance();
			}
		}
		assertEquals(beneficiaryAfterBalance, testBeneficiaryAfterBalance, 0.0);

	}

}