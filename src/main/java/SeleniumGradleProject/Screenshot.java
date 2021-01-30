package SeleniumGradleProject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Screenshot {
	
	static String fileWithPath="C://Users//kmalla//Downloads//screenshots//screenshots.png";
	public static String takeScreenShot(WebDriver driver) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
				return fileWithPath;
                

    }
	
	public static void saveScreenShot(WebDriver driver,ExtentTest test) throws Exception {
		test.log(LogStatus.PASS, test.addScreenCapture(takeScreenShot(driver)));
	}
}
