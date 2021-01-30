package SeleniumGradleProject;

import com.relevantcodes.extentreports.LogStatus;

public class WebTable extends Template{

	public static void main(String[] args) throws Exception {

		WebTable obj=new WebTable();
		obj.testMethod();
		
	}

	@Override
	public void testMethod() throws Exception {

		test.log(LogStatus.INFO, "Configured Report");
		
		Screenshot.saveScreenShot(driver,test);
	}

}
