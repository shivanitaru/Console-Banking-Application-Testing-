package com.test.JUnitTestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.controller.Bank;

public class TestFundTransfer {
	Bank bankObj = new Bank();

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
		assertEquals("Shivanini", bankObj.customerModelObj.getName());
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

		// double beforeDeposit = bankObj.customerModelObj.getBalance();
		// bankObj.deposit();
		// double depositAmount = bankObj.depositAmount;
		// double afterDeposit = beforeDeposit + depositAmount;
		// assertEquals(afterDeposit,bankObj.customerModelObj.getBalance(),0.0);
	}

}