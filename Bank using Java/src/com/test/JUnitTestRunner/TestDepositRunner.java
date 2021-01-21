package com.test.JUnitTestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.test.JUnitTestCase.TestDeposit;

public class TestDepositRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(TestDeposit.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());

	}

}