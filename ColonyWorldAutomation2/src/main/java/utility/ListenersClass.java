package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import action.Action;
import baseClass.BaseClass;

public class ListenersClass extends ExtentManager  implements ITestListener {
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		//test.createNode(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(Status.PASS, "Pass Test case is: " + result.getName());
			test.log(Status.PASS,
					MarkupHelper.createLabel("Test Case PASSED : " + result.getName(), ExtentColor.GREEN));
		}
	}

	public void onTestFailure(ITestResult result)  {
		//in extent write testcase failed and font colour red 
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//Takes Screenshot 
			//String imgPath = Action.screenShot(Action.driver, result.getName());
			String imgPath = Action.screenShot(BaseClass.driver, result.getName());
			//adding screenshot to extent report 
			test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			//test.addScreenCaptureFromPath(Action.screenShot(BaseClass.driver, result.getName()));
			String screenshotName = result.getName();
			System.out.println("This is the Name Of the screenshot");
			System.out.println(screenshotName);
			//test.fail(action.screenShot(BaseClass.driver , result.getName()));
			//test.addScreencastFromPath("//eclipse-workspace/GahCom/ScreenShots");
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	}

}
