package SeleniumGradleProject;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class WindowHandling extends Template{
//main method
	public static void main(String[] args) throws InterruptedException {
		WindowHandling obj=new WindowHandling();
		obj.testMethod();
		//Use this URL(http://demo.guru99.com/popup.php) in template class for window handling demonstration.
		//ignore if the same URL is present in Template class
	}

	@Override
	public void testMethod() throws InterruptedException {

		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		//getting the string value of parent or first tab and storing it in mainWindow variable
		String mainWindow=driver.getWindowHandle();

		System.out.println("Parent Window  Handle is:" +mainWindow);

		// To handle all new opened window, getting the string value of all the opened tabs and stored it in collection Set as s1		
		Set<String> s1=driver.getWindowHandles();		

		//using this iterator interface to use predefined methods called hasNext() and next()
		Iterator<String> i1=s1.iterator();		

		//verifying whether the string value is present or not. if present will try to switch to second tab 
		while(i1.hasNext())			
		{		
			//getting the string value of second tab from the iterator and storing it in ChildWindow string variable
			String ChildWindow=i1.next();		

			//if the parent and main tab is not same then it goes into if block
			if(!mainWindow.equalsIgnoreCase(ChildWindow))			
			{    		

				// Switching to Child tab
				driver.switchTo().window(ChildWindow);

				driver.findElement(By.xpath("//td[text()='Email ID']//following::input[1]"))
				.sendKeys("mallakarthik@gmail.com");

				driver.findElement(By.xpath("//input[@type='submit']")).click();

				TimeUnit.SECONDS.sleep(7);

				// Closing the Child Window.
				driver.close();		
			}		
		}		
		// Switching to Parent tab i.e Main tab.
		driver.switchTo().window(mainWindow);				
	}


}


