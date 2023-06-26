package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Base {

    public String _mainUrl = "https://www.bayt.com/en/jordan/";
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;

    public WebDriver DriverSetup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        // Initialize the driver and navigate to the home page
        System.setProperty("webdriver.chrome.driver", "D:\\My files\\Backup\\QA\\chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.get(_mainUrl);

        return driver;
    }
    


    public ExtentReports InitializeExtentReport() {
        // Create an instance of ExtentHtmlReporter
        htmlReporter = new ExtentHtmlReporter("extent-report.html");

        // Create an instance of ExtentReports
        extent = new ExtentReports();

        // Attach the HTML reporter to ExtentReports
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
