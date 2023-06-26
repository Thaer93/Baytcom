import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create an instance of ExtentHtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");


        // Create an instance of ExtentReports
        ExtentReports extent = new ExtentReports();

        // Attach the HTML reporter to ExtentReports
        extent.attachReporter(htmlReporter);

        // Create a test with a name and description
        ExtentTest test = extent.createTest("My First Test", "This is a sample test");

        // Log test steps with status and description
        test.log(Status.INFO, "Starting the test");
        test.log(Status.PASS, "Test step 1 passed");
        test.log(Status.PASS, "Test step 2 passed");

        // Create another test and log steps
        ExtentTest anotherTest = extent.createTest("My Second Test", "This is another test");
        anotherTest.log(Status.INFO, "Starting the second test");
        anotherTest.log(Status.FAIL, "Test step 1 failed");

        // Mark the tests as complete
        test.pass("All steps passed");
        anotherTest.fail("Test failed");

        // Flush the report to generate the output file
        extent.flush();

	}

}
