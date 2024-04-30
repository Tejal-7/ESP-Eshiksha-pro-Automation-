package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import action.Action;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWAddUserPOM extends BaseClass  {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select ;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[4]/a[1]/i[1]")
	WebElement users ;
	@FindBy(xpath="//a[contains(text(),'Add Users')]")
	WebElement addUsers ;
	@FindBy(xpath="//select[@id='asociety1']")
	WebElement select_society;
	@FindBy(xpath="//select[@id='group']")
	WebElement select_group;
@FindBy(xpath="//select[@id='block']")
WebElement selectBlock;
@FindBy(xpath="//input[@id='name']")
WebElement name;
@FindBy(xpath="//input[@id='contact']")
WebElement contactNo ;
@FindBy(xpath="//input[@id='email']")
WebElement userName ;
@FindBy(xpath="//input[@id='password']")
WebElement password;
@FindBy(xpath="//input[@id='addUsers']")
WebElement add_user ;
@FindBy(xpath="(//div[@class='modal-content'])[6]")
WebElement validation_popup;
@FindBy(xpath="//strong[contains(text(),'User Added Successfully.')]")
WebElement validation_msg;
public CWAddUserPOM() {
	PageFactory.initElements(driver, this);

}
public void clickAddUser() {
	Action.JSClick(driver, users);
	Log.info("Users is clicked");
	test= ExtentManager.test.info("Users is clicked");
	Action.JSClick(driver,  addUsers);
	Log.info("Add users is clicked");
	test=ExtentManager.test.info("Add users is clicked");
	
}
public void selectAddUser() {
select = new Select(select_society);
select.selectByIndex(1);
Log.info("Society is selected");
test=ExtentManager.test.info("Society is selected");
select = new Select (select_group);
select.selectByIndex(1);
Log.info("Group is selected");
test=ExtentManager.test.info("Group is selected");
select = new Select ( selectBlock);
select.selectByIndex(4);
Log.info("Block is selected");
test=ExtentManager.test.info("Block is selected");

}
public void inpAddUser() {
	fake = new Faker ();
	String name1 = fake.name().firstName();
	Action.type(name, name1);
	Log.info("Name is entered: "+ name1);
	test=ExtentManager.test.info("Name is entered: "+ name);
String phn = fake.number().digits(10);
Action.type(contactNo, phn);
Log.info("Contact number is enetered:"+ phn);
test=ExtentManager.test.info("Contact number is enetered:"+ phn);;
String un = fake.internet().emailAddress();
userName.clear();
Action.type(userName, un);
Log.info("Username is entered: " + un);
test= ExtentManager.test.info("Username is entered: " + un);
String pwd = fake.number().digits(5);
Action.type(password, pwd);
Log.info("Password is entered ");
test=ExtentManager.test.info("Password is entered");
}
public void clickAddUser1() throws InterruptedException {
	Action.JSClick(driver,add_user);
	Log.info("Add user is clicked ");
	test=ExtentManager.test.info("Add user is clicked");
	Thread.sleep(500);
}
public void verifyValidation() throws InterruptedException {
	boolean status = validation_popup.isDisplayed();
	if (status= true) {
		System.out.println("Validation popup is displayed");
		Log.info("Validation popup is displayed");
		test=ExtentManager.test.info("Validation popup is displayed");
		Thread.sleep(500);
	}	
	else {
		System.out.println("Validation popup is not displaying");
	}
	boolean status1 = validation_msg.isDisplayed();
String msg= 	validation_msg.getText();
System.out.println(msg);
Assert.assertEquals(msg, "User Added Successfully.");
Log.info("Validation message is displayed :" + msg);
test=ExtentManager.test.log(Status.PASS,MarkupHelper .createLabel("Validation message is displayed :" + msg, ExtentColor.GREEN));
}



}
