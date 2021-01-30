package SeleniumGradleProject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Template {



	WebDriver driver;
	WebDriverWait wait;
	static ExtentTest test;
	static ExtentReports report;


	public abstract void testMethod() throws InterruptedException, Exception;

	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\report.html");
		test = report.startTest("Web Table Test case");
	}
	@Test
	public void executeTest() throws Exception {
		testMethod();
	}

	@BeforeTest
	public void login() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disble-notifications");
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);


		driver.get("http://demo.guru99.com/popup.php");
	}

	@AfterTest
	public void logout() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		driver.quit();
	}

	@AfterClass
	public static void endTest(){
		report.endTest(test);
		report.flush();
	}

}
