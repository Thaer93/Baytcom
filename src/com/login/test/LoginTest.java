package com.login.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.login.page.LoginPage;

import resources.Base;



public class LoginTest {

	//Declare the needed objects

	private WebDriver driver;
    private Base base;
    private LoginPage loginPage;
    private ExtentReports extent;
	private ExtentTest test;
	private String testDataFile = "ExtData/testdata.xlsx";
	private String sheetName = "loginData" ;



	@BeforeTest
    public void setUp() {
        base = new Base();
        driver = base.DriverSetup();
        loginPage = new LoginPage(driver);
        driver.get("https://www.bayt.com/en/login/");

        // Initialize extent object from base class
        extent = base.InitializeExtentReport();
    }



	@Test()
	public void testLogin() throws FileNotFoundException, IOException, InterruptedException {

		//initialize extent object and pass it to login page class to use it there.
		test = extent.createTest("Login Test","this is test case of a login function");
		loginPage.passExtentObject(test);


		try (FileInputStream fis = new FileInputStream(testDataFile);
         Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheet(sheetName);

     // Iterate over rows in the sheet
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            
            System.out.println("Processing Row: " + rowNum);

            // Get the test data from the row
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            boolean expectedLoginResult = row.getCell(2).getBooleanCellValue();

            // Execute the login test case
            boolean actualLoginResult = loginPage.login(username, password);


            // Compare the actual result with the expected result
            if (actualLoginResult == expectedLoginResult) {
               test.pass("actual and expected result equaled");
            }

            else {
                System.out.println("Test case failed for username: " + username + "Password: " + password);
                test.fail("Test Case Failed");
            }
           

        }//close loop
        fis.close();


    } catch (IOException e) {
        e.printStackTrace();
    }

	 }


	@AfterTest
	  public void tearDown() {
	    // quit the driver and release resources
	    driver.quit();
	    extent.flush();

	  }

	}



