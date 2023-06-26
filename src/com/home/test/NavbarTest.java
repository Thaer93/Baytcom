package com.home.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.home.page.HomeNavbar;

import resources.Base;

public class NavbarTest {

	private WebDriver driver;
	private HomeNavbar _homenav;
	private Base base;
	private ExtentReports extent;
	private ExtentTest test;
	boolean assertionResult;

	@BeforeMethod
	public void beforeTest() throws InterruptedException {
		// navigate to the home page
		driver.get("https://www.bayt.com/en/jordan/");
		Thread.sleep(1000);
	}


	@BeforeTest
	public void Setup() {

		// initialize the driver and navigate to the home page
		base = new Base();
		driver = base.DriverSetup();

		//initialize driver
		_homenav = new HomeNavbar(driver);
		
		//initialize extent object
		extent = base.InitializeExtentReport();
	}



	@Test
	public void testLogo() {
		
		_homenav.logoLink();
		
		try {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/jordannnn/");
		assertionResult = true;
		}
		
		catch (AssertionError e) {
		    assertionResult = false;
		  
		}
		
		if (assertionResult) {
		test = extent.createTest("Test the Logo clickable link","");
		test.log(Status.INFO, "logo link opened");
		test.pass("link worked successfully");
		}
		else {
			test = extent.createTest("Test the Logo clickable link","");
			test.log(Status.INFO, "logo link not opened");
			test.fail("logo link Test case failed");
		}

	}



	@Test
	public void testFindJobs() {
		_homenav.findJobsLink();
		Assert.assertEquals(driver.getCurrentUrl(),("https://www.bayt.com/en/jordan/jobs/search/"));
		test = extent.createTest("Test the find jobs clickable link","");
		test.log(Status.INFO, "find job page link opened");
		test.pass("link worked successfully");
	}


	//invoke login method for any test case has to log-in
//	@Test()
//	public void loginForTest() throws InterruptedException {
//		Thread.sleep(4000);
//		_homenav.login();
//	}

	@Test()
	public void testCreateYourCV() {

		_homenav.createYourCVLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/register-j/?native_source=CreateYourCV");
		test = extent.createTest("Test the create your CV clickable link","");
		test.log(Status.INFO, "page link opened");
		test.pass("link worked successfully");

	}

	@Test()
	public void testBlog() {

		_homenav.blogLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/blog/");
		test = extent.createTest("Test the Blog clickable link","");
		test.log(Status.INFO, "page link opened");
		test.pass("link worked successfully");

	}

	@Test()
	public void testcvServices() {

		_homenav.CvServicesLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/cv-writing/?native_source=CVW-top-menu");
		test = extent.createTest("Test the CV Services clickable link","");
		test.log(Status.INFO, "page link opened");
		test.pass("link worked successfully");
	}


	@Test()
	public void testLogin(){

		_homenav.loginPageLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/login/");
		test = extent.createTest("Test the login pages clickable link","");
		test.log(Status.INFO, "page link opened");
		test.pass("link worked successfully");
	}

	@Test()
	public void testRegister() {

		_homenav.registerPageLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.bayt.com/en/register-j/");
		test = extent.createTest("Test the Register page clickable link","");
		test.log(Status.INFO, "page link opened");
		test.pass("link worked successfully");

	}

	@Test()
	public void testForEmployers() {

		_homenav.forEmployersPageLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://business.bayt.com/jo/");
		test = extent.createTest("Test the For Employers clickable link","");
		test.log(Status.INFO, "page link opened");
		test.pass("link worked successfully");
	}


	@AfterTest
	  public void tearDown() {
	    // quit the driver and release resources
	    driver.quit();
	    extent.flush();
	  }


}
