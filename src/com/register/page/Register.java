package com.register.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class Register {

	private WebDriver driver;
	private Faker faker = new Faker(); //to generate fake data



	public Register(WebDriver driver) {
		this.driver = driver;
	}


	String signInUrl = "https://www.bayt.com/en/login/";

	//locate register page elements.
	private By _firstName = By.xpath("//*[@id=\"JsMiniRegistrationForm_firstName\"]");
	private By _lastName = By.xpath("//*[@id=\"JsMiniRegistrationForm_lastName\"]");
	private By _email = By.xpath("//*[@id=\"JsMiniRegistrationForm_email\"]");
	private By _password = By.xpath("//*[@id=\"JsMiniRegistrationForm_password\"]");
	private By _phoneNumber = By.xpath("//*[@id=\"JsMiniRegistrationForm_mobPhone\"]");
	private By _makeMyProfilePublic = By.xpath("//*[@id=\"JsMiniRegistrationForm_emailSubscriptions\"]/label");
	private By _registerBtn = By.xpath("//*[@id=\"register\"]");
	private By _phoneAreaCode = By.xpath("//*[@id=\"mobPhoneAreaCode__r\"]");
	private By _phoneAreaCodeSearch = By.xpath("//*[@id=\"yw1\"]/div[2]/div[4]/div/div[1]/div/div/div[1]/div[2]/div/input");
	private By _signInLink = By.xpath("/html/body/section/div[1]/div/div/p/a");



	//valid scenarios
	public void successRegistration(String phoneNum) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//generate fake data
		String fName = faker.name().firstName();
		String lName = faker.name().lastName();
		String eMail = faker.internet().emailAddress();
		String password = faker.internet().password();
		String pNumber = phoneNum;

		//print register info
		System.out.println("first name is: " + fName);
		System.out.println("E-mail is: " + eMail);
		System.out.println("password is: " + password);
		System.out.println("phone is: " + pNumber);

		//fill input fields
		driver.findElement(_firstName).sendKeys(fName);
		driver.findElement(_lastName).sendKeys(lName);
		driver.findElement(_email).sendKeys(eMail);
		driver.findElement(_password).sendKeys(password);
		driver.findElement(_phoneNumber).sendKeys(pNumber);

		//check/uncheck (default is checked)
		driver.findElement(_makeMyProfilePublic).click();

		//click submit
		driver.findElement(_registerBtn).click();
		Thread.sleep(4000);


		//to logout
        if (driver.getCurrentUrl().equals("https://www.bayt.com/en/profile/minified-profile/")) {

        	Thread.sleep(3000);

        	//click on i'll do it later
        	 driver.findElement(By.xpath("//*[@id=\"doItLater\"]")).click();
        	 Thread.sleep(2000);

        	//click on three dots
         	driver.findElement(By.cssSelector("#yw1 > li.is-first > ul > li:nth-child(7)")).click();
        	 	Thread.sleep(2000);

        	 	//click on logout
        	 	driver.findElement(By.cssSelector("#yw1 > li.is-first > ul > li.popover-owner.is-active > div > ul > li.has-divider > a")).click();
        	 	Thread.sleep(2000);
        }
        else if(driver.getCurrentUrl().equals("https://www.bayt.com/en/myworkspace-j/")) {
        	Thread.sleep(2000);

        	//click on three dots
         	driver.findElement(By.cssSelector("#yw1 > li.is-first > ul > li:nth-child(7)")).click();
        	 	Thread.sleep(2000);

        	 	//click on logout
        	 	driver.findElement(By.cssSelector("#yw1 > li.is-first > ul > li.popover-owner.is-active > div > ul > li.has-divider > a")).click();
        	 	Thread.sleep(2000);
        }



	}



	public void registeredEmail(String phoneNum, String email) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//generate fake data
		String fName = faker.name().firstName();
		String lName = faker.name().lastName();
		String eMail = email;
		String password = faker.internet().password();
		String pNumber = phoneNum;

		//print register info
		System.out.println("first name is: " + fName);
		System.out.println("E-mail is: " + eMail);
		System.out.println("password is: " + password);
		System.out.println("phone is: " + pNumber);

		//fill input fields
		driver.findElement(_firstName).sendKeys(fName);
		driver.findElement(_lastName).sendKeys(lName);
		driver.findElement(_email).sendKeys(eMail);
		driver.findElement(_password).sendKeys(password);
		driver.findElement(_phoneNumber).sendKeys(pNumber);

		//check/uncheck (default is checked)
		driver.findElement(_makeMyProfilePublic).click();

		//click submit
		driver.findElement(_registerBtn).click();
	}



	//test case of en empty register form
	public void emptyRegisteration() {
		driver.findElement(_registerBtn).click();
		String actualError = driver.findElement(By.id("JsMiniRegistrationForm_email_em_")).getText();
		String expectedError = "Required Field";
		Assert.assertEquals( actualError, expectedError );

		}


	//invalid first and lname input
	public void validFirsttAndLastName(String fname, String lname ) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(_firstName).sendKeys(fname);
		driver.findElement(_lastName).sendKeys(lname);
		driver.findElement(_registerBtn).click();

		String fnameErrMessage = driver.findElement(By.id("JsMiniRegistrationForm_firstName_em_")).getText();
		String lnameErrMessage = driver.findElement(By.id("JsMiniRegistrationForm_lastName_em_")).getText();
		String expectedfNameMessage = "First Name can only include your name.";
		String expectedlNameMessage = "Last Name can only include your name.";

		Assert.assertEquals(fnameErrMessage, expectedfNameMessage);
		Assert.assertEquals(lnameErrMessage, expectedlNameMessage);

		}

	//invalid email input
	public void validEmailForm1(String invalidEmail) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(_email).sendKeys(invalidEmail);
		driver.findElement(_registerBtn).click();

		String actMessage = driver.findElement(By.id("JsMiniRegistrationForm_email_em_")).getText();
		String expectedMessage = "Email Address is not a valid email address.";

		Assert.assertEquals(actMessage, expectedMessage);

		}

	//invalid password input
	public void validatePasswordLength(String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(_password).sendKeys(password);
		driver.findElement(_registerBtn).click();

		String actErrMsg = driver.findElement(By.id("JsMiniRegistrationForm_password_em_")).getText();
		String expeMsg = "Password is too short (minimum is 8 characters).";

		Assert.assertEquals(actErrMsg, expeMsg);

	}

	//invalid password input
	public void validatePasswordComplexity(String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(_password).sendKeys(password);
		driver.findElement(_registerBtn).click();

		String actErrMsg = driver.findElement(By.id("JsMiniRegistrationForm_password_em_")).getText();
		String expeMsg = "Password too easy, must be complex";

		Assert.assertEquals(actErrMsg, expeMsg);
	}



	public void PhoneAreaCode(String Country, String countryCode) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(_phoneAreaCode).click();

		driver.findElement(_phoneAreaCodeSearch).sendKeys(Country);

		Thread.sleep(2000);

		driver.findElement(_phoneAreaCode).sendKeys(Keys.ARROW_DOWN);

		driver.findElement(_phoneAreaCode).click();

		//to get an attribute value, locate lement then attribute
		WebElement element = driver.findElement(By.cssSelector("#yw1 > div.form-section.m0t > div:nth-child(4) > div > div.input-pack > div > i"));
		String dataDialValue = element.getAttribute("data-dial");

		System.out.println("Actual country code: " + dataDialValue);

		Assert.assertEquals(dataDialValue, countryCode);

	}


	//invalid phone number input
	public void validatePhoneNumberLength(String phoneNum) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(_phoneNumber).sendKeys(phoneNum);
		driver.findElement(_registerBtn).click();

		String actErrMsg = driver.findElement(By.id("JsMiniRegistrationForm_mobPhone_em_")).getText();
		String expeMsg = "Phone Number is too short (minimum is 6 characters).";

		Assert.assertEquals(actErrMsg, expeMsg);

	}


	//verify sign in link
	public void clickOnSignInLink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(_signInLink).click();

		Assert.assertEquals(driver.getCurrentUrl(), signInUrl);
	}


		public void clickOntermsAndConditions() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.bayt.com/en/pages/terms/");

			Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/pages/terms/");
		}


		public void clickOnprivacyPolicyLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.bayt.com/en/pages/privacy-statement/");

			Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/pages/privacy-statement/");
		}




}
