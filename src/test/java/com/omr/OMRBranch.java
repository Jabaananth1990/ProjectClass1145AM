package com.omr;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OMRBranch {

	@Parameters({ "username", "password" })
	@Test
	private void login(@Optional("xyz@gmail.com") String x, String y) {
		System.out.println(x);
		System.out.println(y);
	}

	private void webApp() {
		System.out.println("Selenium");

	}

	private void mobileApp() {
		System.out.println("Appium");

	}

	private void apiTest() {
		System.out.println("Rest API");

	}

	private void java() {
		System.out.println("JAVA");

	}

	private void python() {
		System.out.println("PYTHON");

	}

	private void ruby() {
		System.out.println("RUBY");

	}

}
