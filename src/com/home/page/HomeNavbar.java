package com.home.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeNavbar {


// this class implements locates and methods to test All navbar links

	private WebDriver driver;


	//initialize driver object when it called from intended test class
	public HomeNavbar(WebDriver driver) {
		this.driver=driver;
	}


	//locate navbar links
	private By _logoLink = By.xpath("//*[@id=\"baytLogo\"]/img");
	private By _homeLink = By.xpath("//*[@id=\"yw0\"]/li[1]/a");
	private By _findJobsLink = By.xpath("//*[@id=\"yw0\"]/li[2]/a");
	private By _createYourCVLink = By.xpath("//*[@id=\"yw0\"]/li[3]/a");
	private By _blogLink = By.xpath("//*[@id=\"yw0\"]/li[4]/a");
	private By _CvServicesLink = By.xpath("//*[@id=\"yw0\"]/li[5]/a");
	private By _loginPageLink = By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[1]/a");
	private By _registerPageLink = By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[2]/a");
	private By _forEmployersPageLink = By.xpath("//*[@id=\"yw0\"]/li[8]/ul/li[4]/a");



		//Click on logo link
		public void logoLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_logoLink).click();
		}

		//Click on home link
		public void homeLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_homeLink).click();
		}

		//Click on find jobs link
		public void findJobsLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_findJobsLink).click();
		}

		//Click on create Your CV link
		public void createYourCVLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_createYourCVLink).click();
		}

		//Click on blog link
		public void blogLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_blogLink).click();
		}

		//Click on cv services link
		public void CvServicesLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_CvServicesLink).click();
		}

		//Click on login link
		public void loginPageLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_loginPageLink).click();
		}

		//Click on register link
		public void registerPageLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_registerPageLink).click();
		}

		//Click on for employers link
		public void forEmployersPageLink() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(_forEmployersPageLink).click();
		}



}
