package pageObjectsPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.ExtentManager;
import action.Action;
import baseClass.BaseClass;

import utility.ListenersClass;
import utility.Log;

public class CWLoginPomClass extends BaseClass  {

	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	// Declaration 
	@FindBy(xpath="//input[@id='username']")
	WebElement emailInput;
	@FindBy(xpath="//input[@id='password']")
	WebElement  inputPassword;
@FindBy(xpath="//div[@id='userview']")
WebElement getCaptcha;
@FindBy(xpath="//input[@id='usercapcha']")
WebElement enterCaptcha;
@FindBy(xpath="//button[@id='submitbutton']")
WebElement loginBtn;
@FindBy(xpath="//i[@class='fa fa-angle-down']")
WebElement dropdownBtn;
@FindBy(xpath="//i[@class='fa fa-ban fa-fw pull-right']")
WebElement logOutBtn;

public CWLoginPomClass() {
	PageFactory.initElements(driver, this);
}
public void colonyWorldogin(String username , String password) throws InterruptedException{
	Log.info("Colony world Login");
	Action.type(emailInput, username);
	//test = Extent.test.info("Username Entered : " + username);
	Log.info("Username is entered Succesfully");
	
	Action.type(inputPassword, password);
	Log.info("Password Entered Succesfully");
//	test=Extent.test.info("Passweord Entered : " + password);
	String captchas= getCaptcha.getText();
	System.out.println(captchas);
	Action.type(enterCaptcha, captchas);
	Thread.sleep(1000);
	//test=Extent.test.info("Captch entered :" +captchas);
	Log.info("Captch entered :" +captchas);
	
	
	Action.JSClick(driver, loginBtn);
	Thread.sleep(1000);
	Log.info("Logged in succesfully");
	test=ExtentManager.test.info("Submit button is clicked succesfully and logged in ");
	
}
public void logOut() {
Action.JSClick(driver, dropdownBtn)	;



}

}
