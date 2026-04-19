package com.omr;

import org.baseclass.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class Sample extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		browserLaunch();
		maximizeWindow();
		enterAppUrl("https://adactinhotelapp.com/");
	}

	@Test
	private void appLogin() {
		LoginPage loginPage = new LoginPage();
		loginPage.login("abc@gmail.com", "hello@123");
	}

	@AfterClass
	private void afterClass() {
//		closeBrowser();
	}

}
