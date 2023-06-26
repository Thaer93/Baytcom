package com.home.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.home.page.SearchJobs;

import resources.Base;

public class SearchJobsTest extends Base {

	private WebDriver driver;

	private SearchJobs _searchJobs ;



	@BeforeTest
	public void Setup() {

		// initialize the driver and navigate to the home page, DriverSetup invoked from Bass class.
		driver = DriverSetup();

		//to initialaize driver in SearchJobs class
		_searchJobs = new SearchJobs(driver);

	}


	@Test
	public void testMethod2() throws InterruptedException {

		_searchJobs.SearchJobAndLocation("quality assurance");

	}

	@AfterTest
	  public void tearDown() {
	    // quit the driver and release resources
	    driver.quit();
	  }


}
