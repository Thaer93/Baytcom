package com.login.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage {

	private WebDriver driver;
	private ExtentTest test;
	



	public LoginPage(WebDriver driver ) {
		this.driver = driver ;
	}


	//receive the initialized test object from login test class to use it within this class
	public void passExtentObject(ExtentTest test) {
		this.test = test;
	}


	//locators
	private By _email = By.xpath("//*[@id=\"LoginForm_username\"]");
	private By _password = By.xpath("//*[@id=\"LoginForm_password\"]");
	private By _loginBth = By.xpath("//*[@id=\"login-button\"]");



	//Login
	public boolean login(String username, String password) throws InterruptedException {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    // Enter username
	    driver.findElement(_email).sendKeys(username);
	    Thread.sleep(2000);
	    test.log(Status.INFO, "username entered");

	    // Enter password
	    driver.findElement(_password).sendKeys(password);
	    Thread.sleep(2000);
	    test.log(Status.INFO, "password entered");

	    // Click login button
	    driver.findElement(_loginBth).click();
	    Thread.sleep(3000);
	    test.log(Status.INFO, "login button clicked");

	    // Verify if login is successful return true
	    if (driver.getCurrentUrl().equals("https://www.bayt.com/en/profile/minified-profile/") ||
	        driver.getCurrentUrl().equals("https://www.bayt.com/en/myworkspace-j/") ||
	        driver.getCurrentUrl().equals("https://www.bayt.com/en/profile/complete-cv/index/?complete_your_cv=1")) {
	    	 
	    	
	    	//click on three dots
         		driver.findElement(By.cssSelector("#yw1 > li.is-first > ul > li:nth-child(7)")).click();
        	 	Thread.sleep(2000);

        	 	//click on logout
        	 	driver.findElement(By.cssSelector("#yw1 > li.is-first > ul > li.popover-owner.is-active > div > ul > li.has-divider > a")).click();
        	 	Thread.sleep(2000);
        	 	//test.log(Status.INFO, "logged out");
        	 	driver.get("https://www.bayt.com/en/login/");
        	 	 test.log(Status.INFO, "logged-in success");
        	 	return true;
        	 	
	        }
	        
	     else {
	        driver.get("https://www.bayt.com/en/login/");
	        test.log(Status.INFO, "logged-in failed");
	        return false;
	    }
	    
	}

}
