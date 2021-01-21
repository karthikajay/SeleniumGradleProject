package SeleniumGradleProject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Template {
	
		
	
	WebDriver driver;
		
	

	public abstract void testMethod();

	@Test
	public void executeTest() {
		testMethod();
	}

	@BeforeTest
	public void login() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disble-notifications");
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		
		
		driver.get("https://www.facebook.com");
	}
	
	@AfterTest
	public void logout() throws InterruptedException {
	TimeUnit.SECONDS.sleep(5);
		driver.quit();
	}

}
