package com.register.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.register.page.Register;

import resources.Base;

public class RegisterTest extends Base {

	private WebDriver driver;
	private Register _register ;





	@BeforeTest()
	public void Setup() {
		driver = DriverSetup();
		_register = new Register(driver);

	}

	@BeforeMethod()
	public void beforeMethod() throws InterruptedException {
		driver.get("https://www.bayt.com/en/register-j/");
		Thread.sleep(3000);
	}

	//valid test
//	@Test()
//	public void sucessRegisteration() throws InterruptedException {
//		_register.successRegistration("798915577");
//		Thread.sleep(3000);
//		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/profile/minified-profile/");
//	}



	//invalid register with registered E-mail
	@Test()
	public void testRegisteredEmail() throws InterruptedException{
		_register.registeredEmail("798915577", "teodoro.huels@gmail.com");
		Thread.sleep(3000);

		String actualError = driver.findElement(By.id("JsMiniRegistrationForm_email_em_")).getText();
		String expectedError = "This email is already registered.";
		Assert.assertEquals( actualError, expectedError );
	}

//
//
//
//	//invalid register with same phone number
	@Test()
	public void registerWithRegisteredPhNum() throws InterruptedException{
		_register.successRegistration("798915577");
		Thread.sleep(3000);

		String actualError = driver.findElement(By.id("mobPhoneAreaCode__r")).getText();
		String expectedError = "Phone number already registered";
		Assert.assertEquals( actualError, expectedError );
	}
//
//
//	//invalid test
	@Test()
	public void emptyFields(){
		_register.emptyRegisteration();
	}
//
//
//	//invalid test
		@Test()
		public void invalidEmail1(){
			_register.validEmailForm1("123");

		}
//
		@Test()
		public void invalidEmail2(){
			_register.validEmailForm1("user@.com");
		}
//
//
	@Test()
	public void invalidEmail3(){
		_register.validEmailForm1("abcd");
	}

	//invalid input integer numbers in first and last name fields
//		@Test()
		public void validateFnameAndLname(){
			_register.validFirsttAndLastName("1234", "54321");

		}
//
//	//invalid input short password
	@Test()
	public void validatePasswordLength(){
		_register.validatePasswordLength("1234");

	}
//
//
//	//invalid input simple password
	@Test()
	public void validatePasswordComplex(){
		_register.validatePasswordLength("12345678");

	}
//
//	//invalid input simple password
	@Test()
	public void validatePhoneArea() throws InterruptedException{
		_register.PhoneAreaCode("jordan", "962");
	}
////
	@Test()
	public void verifySignInLink(){
		_register.clickOnSignInLink();
	}
////
	@Test()
	public void verifyTermsAndCond(){
		_register.clickOntermsAndConditions();
	}
////
	@Test()
	public void verifyPrivacyPolicy(){
		_register.clickOnprivacyPolicyLink();
	}


	@AfterTest
	  public void tearDown() {
	    // quit the driver and release resources
	    driver.quit();
	  }















}
