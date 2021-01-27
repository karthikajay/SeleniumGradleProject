package SeleniumGradleProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SampleAlerts extends Template {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SampleAlerts obj= new SampleAlerts();
		obj.testMethod();

	}

	@Override
	public void testMethod() throws InterruptedException {

		try {
			
		
		WebElement customerID=driver.findElement(By.xpath("//td[text()='Customer ID']//following::input[1]"));
		customerID.sendKeys("12345");
		
		//to verify the Customer ID text box is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Customer ID']//following::input[1]")).isDisplayed());
				
		
		WebElement submit=driver.findElement(By.xpath("//td[text()='Customer ID']//following::input[2]"));
		submit.click();
		
		TimeUnit.SECONDS.sleep(3);
		
		Alert alert=driver.switchTo().alert();
		
		String expected=alert.getText();
		System.out.println("Text in alerts are:" +expected);
		alert.accept();
		
		//to verify the value of alert
		Assert.assertEquals("Do you really want to delete this Customer?",expected);
		
		//to verify the value of alert
		Assert.assertNotEquals("Do you really want to delete this Customer",expected);
		
		TimeUnit.SECONDS.sleep(3);
		alert.accept();
		
		driver.switchTo().defaultContent();
		}catch(AssertionError e) {
			System.out.println("Exception occured is:" +e);
			
		}catch(Exception e) {
			System.out.println("Exception occured is:" +e);
			
		}
	}

}
