package utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	
	
	
	
	public static void setExtent() throws IOException {
		String dateName = new SimpleDateFormat("EEE, MMM d, yyyy ,hh mm aaa").format(new Date());
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"TestReport - "+dateName+".html");
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("ProjectName", "Colony World ");
		extent.setSystemInfo("Tester", "Tejal");                     
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("Browser", "Chrome");
	
	}
	
	public static void endReport() {
		extent.flush();
}
}