package SeleniumGradleProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestCase001 extends Template {
public static void main(String[] args) throws InterruptedException {
	TestCase001 obj= new TestCase001();
	obj.testMethod();
}
	@Override
	public void testMethod() throws InterruptedException {
		System.out.println("logged in");
		WebElement userName=driver.findElement(By.id("email"));
		
		//created object for Actions Class and pass the driver as a argument for Actions constructor
		Actions builder=new Actions(driver);
		
		//create the set of actions on the Username text box
		Action seriesOfActions=builder.moveToElement(userName).click()
				.keyDown(userName,Keys.SHIFT).sendKeys(userName,"mallakarthik@mail.com")
				.keyUp(userName,Keys.SHIFT).build();
		
		//perform all the mentioned action statements.
		seriesOfActions.perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		  
		//scroll by pixels
		 js.executeScript("window.scrollBy(0,800)");
		 
		 TimeUnit.SECONDS.sleep(5);
		 
		 //scroll the web page till webelement is visible
		   js.executeScript("arguments[0].scrollIntoView();",userName );
		
		  //used to scroll the till last  element
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}

}
