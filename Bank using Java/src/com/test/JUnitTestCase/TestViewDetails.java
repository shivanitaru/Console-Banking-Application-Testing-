package com.test.JUnitTestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.controller.Bank;

public class TestViewDetails {

	Bank bankObj = new Bank();

	@Test
	public void testGetBalance() {
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

		bankObj.Login();
		assertEquals("vinimehta", bankObj.loginModelObj.getUsername());
		assertEquals("vini@123", bankObj.loginModelObj.getPassword());

		bankObj.getAccountDetails();

	}

}