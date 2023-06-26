package com.home.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchJobs {

	private WebDriver driver;

	// initialize driver object of this class when send it from test class
	public SearchJobs(WebDriver driver) {
		this.driver = driver;
	}

	// locate the Web page elements

	private By _searchInput = By.xpath("//*[@id=\"text_search\"]");
	private By _searchJobsBtn = By.xpath("//*[@id=\"search_icon_submit\"]");

	// fill search input and click search method
	public void SearchJobAndLocation(String searchValue) throws InterruptedException {

		// Wait load web page for any web elements locator
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		// fill search input job title
		driver.findElement(_searchInput).sendKeys(searchValue);

		// select an option from dropdown location
		driver.findElement(By.id("search_country1__r")).click();

		// this loop for moving through dropdown many times if needed
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.xpath("//*[@id=\"search_country1__r\"]")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.id("search_country1__r")).click();

		// click after choose location
		driver.findElement(_searchJobsBtn).click();

		// get all results in a resultList
		List<WebElement> resultList = driver.findElements(By.className("has-pointer-d"));

		// print size of lsit
		System.out.println("size of list: " + resultList.size());

		// loop to check resulst job title and dexription one by one if matches search
		// keyword
		for (int i = 0; i < resultList.size(); i++) {

			System.out.println("job element index is: " + i);

			// click on each job element to display details and locate class name and job
			// descriptions

			resultList.get(i).findElement(By.className("jb-title")).click();
			Thread.sleep(1000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			String actualJobTitle = resultList.get(i).findElement(By.className("jb-title")).getText().toLowerCase();
			System.out.println("actual job title: " + actualJobTitle);

			String actualJobDesc = resultList.get(i).findElement(By.xpath("//*[@id=\"view_inner\"]/div[1]/div[2]"))
					.getText().toLowerCase();


			System.out.println();
			System.out.println("*******");

			// js code to scroll by spicific amount to make the elements within the viewport
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int scrollAmount = 180; // Adjust the value as needed
			String scrollScript = String.format("window.scrollBy(0, %d);", scrollAmount);
			js.executeScript(scrollScript);


			// Assert.assertTrue break the loop on first false condition.
			Assert.assertTrue(actualJobTitle.contains(searchValue.toLowerCase())
					|| actualJobDesc.contains(searchValue.toLowerCase()));

		}

	}

	// fill search input and click search method
	public void easyApply(String searchValue) throws InterruptedException {

		// Wait load web page for any web elements locator
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		// fill search input job title
		driver.findElement(_searchInput).sendKeys(searchValue);

		// select an option from dropdown location
		driver.findElement(By.id("search_country1__r")).click();

		// this loop for moving through dropdown many times if needed
		for (int i = 0; i < 10; i++) {
			driver.findElement(By.xpath("//*[@id=\"search_country1__r\"]")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.id("search_country1__r")).click();

		// click after choose location
		driver.findElement(_searchJobsBtn).click();




}
}
