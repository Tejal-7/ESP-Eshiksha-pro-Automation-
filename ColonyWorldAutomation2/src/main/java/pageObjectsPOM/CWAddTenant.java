package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;
import action.Action;
public class CWAddTenant  extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select ;
	
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[3]/a[1]/i[1]")
	WebElement  flats ;
	@FindBy(xpath="//a[contains(text(),'Add Tenant')]")
	WebElement add_tenant;
	@FindBy(xpath="//input[@id='name']")
	WebElement tenant_name;
	@FindBy(xpath="//input[@id='email']")
	WebElement username ;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//input[@id='contact1']")
	WebElement contact_no;
	@FindBy(xpath="//select[@id='block']")
	WebElement select_block;
	@FindBy(xpath="//select[@id='flat']")
	WebElement select_flat ;
	@FindBy(xpath="//input[@id='perFromDate']")
	WebElement start_date;
	@FindBy(xpath="//input[@id='perToDate']")
	WebElement end_date ;
	@FindBy(xpath="//input[@id='addResidents']")
	WebElement add_resident;
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement validationPopup;
	@FindBy(xpath="//strong[contains(text(),'Resident Created  Successfully')]")
	WebElement validationMsg;
	
	
	public CWAddTenant() {
		PageFactory.initElements(driver, this);
	}
	public void clickAddTenant() {
		Action.JSClick(driver,   flats );
		Log.info("Flats is clicked");
		test=ExtentManager.test.info("Flats is clicked");
		Action.JSClick(driver, add_tenant);
		Log.info("Add Tenant is clicked");
		
	}
	public void inpAddTenant() {
		fake = new Faker();
	String name = fake.name().firstName();
	Action.type( tenant_name, name);
	Log.info("Tenat name is entered : "+ name);
	test=ExtentManager.test.info("Tenat name is entered : "+ name);
	String un = fake.internet().emailAddress();
	Action.type(username, un);
	Log.info("Username is entered: "+ un);
	test=ExtentManager.test.info("Username is entered: "+ un);
String pass = fake.number().digits(5);
Action.type(password, pass);
Log.info("Password is entered : "+ pass);
test=ExtentManager.test.info("Password is entered : "+ pass);
String phn = fake.number().digits(10);
Action.type(contact_no, phn);
Log.info("Contact number is entered : "+ phn);
test=ExtentManager.test.info("Contact number is entered : "+ phn);

	}
	public void selectAddTenant() throws InterruptedException {
		select = new Select (select_block);
		select.selectByVisibleText("B");
		Log.info("Block is selected ");
		test = ExtentManager.test.info("Block is selected");
		
		select = new Select(select_flat);
		select.selectByVisibleText("Lonny Friesen");
		Log.info("Flat is selected");
		test=ExtentManager.test.info("Flat is selected ");
		Thread.sleep(500);	
		DateAndTime sDate = fake.date ();
		start_date.sendKeys(String.valueOf(sDate));
		Log.info("Date is entered : "+ sDate);
		test=ExtentManager.test.info("Date is entered : "+ sDate);
		DateAndTime eDate = fake.date();
		end_date.sendKeys(String.valueOf(eDate));
		
	}
	public void clickAddResident() {
		Action.JSClick(driver, add_resident);
		Log.info("Add resident is clicked");
		test=ExtentManager.test.info("Add resident is clicked");
	}
	public void VerifyValidation() {
		boolean status = validationPopup.isDisplayed();
		if (status=true) {
			
			System.out.println("verification popup is displayed");
			}
			else {
				System.out.println("Verification popup is not displaying ");
			}
		Log.info("Verification popup is displayed");
		test= ExtentManager.test.info("Verification popup is displayed");
		
		boolean status1 = validationMsg.isDisplayed();
		String vMsg = validationMsg.getText();
	System.out.println(vMsg);
	Assert.assertEquals(vMsg,"Resident Created Successfully");
	Log.info("Verification message is displayed successfully: "+ vMsg);
	test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Verification message is displayed successfully: "+ vMsg, ExtentColor.GREEN));
		}
	
	
		
	
}
