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
		bankObj.Register();
		assertEquals("Vini", bankObj.customerModelObj.getName());
		assertEquals(20, bankObj.customerModelObj.getAge(), 0.0);
		assertEquals(942125299, bankObj.customerModelObj.getMobileNumber(), 0.0);
		assertEquals("vini@gmail.com", bankObj.customerModelObj.getEmailId());
		assertEquals(152639652, bankObj.customerModelObj.getAadhaarNumber(), 0.0);
		assertEquals("Saving Account", bankObj.customerModelObj.getAccountType());
		assertEquals("Swargate", bankObj.customerModelObj.getBranchName());
		assertEquals(101, bankObj.customerModelObj.getAccountNumber(), 0.0);
		assertEquals("vinimehta", bankObj.customerModelObj.getUsername());
		assertEquals("vini@123", bankObj.customerModelObj.getPassword());

		bankObj.Register();
		assertEquals("Shivani", bankObj.customerModelObj.getName());
		assertEquals(20, bankObj.customerModelObj.getAge(), 0.0);
		assertEquals(848658299, bankObj.customerModelObj.getMobileNumber(), 0.0);
		assertEquals("shivani@gmail.com", bankObj.customerModelObj.getEmailId());
		assertEquals(857526315, bankObj.customerModelObj.getAadhaarNumber(), 0.0);
		assertEquals("Current Account", bankObj.customerModelObj.getAccountType());
		assertEquals("Hadapsar", bankObj.customerModelObj.getBranchName());
		assertEquals(102, bankObj.customerModelObj.getAccountNumber(), 0.0);
		assertEquals("shivanitaru", bankObj.customerModelObj.getUsername());
		assertEquals("shivani@123", bankObj.customerModelObj.getPassword());

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