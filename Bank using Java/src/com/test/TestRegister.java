package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Bank;
import com.model.CustomerModel;

public class TestRegister {
Bank bankObj = new Bank();
// CustomerModel customerModelObj = new CustomerModel();
@Test
public void testRegister() {
	
	bankObj.Register();
	assertEquals("5",bankObj.customerModelObj.getName());
	assertEquals(5,bankObj.customerModelObj.getAge(), 0.0);
	assertEquals(5,bankObj.customerModelObj.getMobileNumber(), 0.0);
	assertEquals("5",bankObj.customerModelObj.getEmailId());
	assertEquals(5,bankObj.customerModelObj.getAadhaarNumber(), 0.0);
	assertEquals("Saving Account",bankObj.customerModelObj.getAccountType());
	assertEquals("Swargate",bankObj.customerModelObj.getBranchName());
	assertEquals(101,bankObj.customerModelObj.getAccountNumber(), 0.0);
	assertEquals("5",bankObj.customerModelObj.getUsername());
	assertEquals("5",bankObj.customerModelObj.getPassword());
	
 }
}
