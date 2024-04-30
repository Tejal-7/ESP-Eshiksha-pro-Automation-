package pageObjectsPOM;

import java.util.Date;
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
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;



import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWAddOwners extends BaseClass {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[3]/a[1]/i[1]")
	WebElement flats;
	@FindBy(xpath="//a[contains(text(),'Add Owners')]")
	WebElement addOwner;
	@FindBy(xpath="//input[@id='name']")
	WebElement ownerName;
	@FindBy(xpath="//input[@id='isresident']")
	WebElement checkBox;
	@FindBy(xpath="//input[@id='email']")
	WebElement un;
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	@FindBy(xpath="//input[@id='reg_no']")
	WebElement regNo ;
	@FindBy(xpath="//input[@id='contact1']")
	WebElement contactNo;
	@FindBy(xpath="//input[@id='purchasedate']")
	WebElement flatPurDate ;
	@FindBy(xpath="//input[@id='purchaseprice']")
	WebElement flatPurPrice;
	@FindBy(xpath="//select[@id='block']")
	WebElement selectBlock;
	@FindBy(xpath="//select[@id='flat']")
	WebElement selectFlat;
	@FindBy(xpath="//input[@id='addOwner']")
	WebElement addOwnerBtn ;
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement successPopup;
	@FindBy(xpath="//strong[contains(text(),'Owner Created  Successfully')]")
WebElement successMsg;
	
	public CWAddOwners() {
		PageFactory.initElements(driver,this);
	}
	public void addOwner() {
		Action.JSClick(driver, flats);
		Log.info("Flats is clicked ");
		test=ExtentManager.test.info("Flats is clicked");
	Action.JSClick(driver, addOwner);
	Log.info("Add owner is clicked");
	test=ExtentManager.test.info("Add owner is clicked");
	}
	public void inpAddOwner() {
		fake = new Faker();
	String oName = fake.name().firstName();
	Action.type(ownerName, oName);
	Log.info("Owner name is added :" + oName);
	test=ExtentManager.test.info("Owner name is added :" + oName);
	Action.JSClick(driver,  checkBox);
	Log.info("Checkbox ic clicked");
	test=ExtentManager.test.info("Checkbox ic clicked");
	un.clear();
	String un1 = fake.internet().emailAddress();
	Action.type(un, un1);
	Log.info("Username is entered:" + un1);
	test=ExtentManager.test.info("Username is entered:" + un1);
	pass.clear();
String pass1 = fake.number().digits(5);
	Action.type(pass, pass1);
	Log.info("password is eneterd: "+ pass1);
	test=ExtentManager.test.info("password is eneterd: "+ pass1);
	String regno= fake.number().digits(7);
	Action.type(regNo, regno);
	Log.info("Registraion no is entered: "+regno );
	test=ExtentManager.test.info("Registraion no is entered: "+regno );
String phnNo= fake.number().digits(10);
	Action.type(contactNo, phnNo);
	Log.info("Phn number is entered"+phnNo);
	test=ExtentManager.test.info("Phn number is entered :" +phnNo);

	DateAndTime datewithouttime = fake.date();

flatPurDate.sendKeys(String.valueOf( datewithouttime));
Log.info("Flat purchase date is entered: "+  datewithouttime);
test= ExtentManager.test.info("Flat purchase date is entered: "+  datewithouttime);
String price = fake.number().digits(7);
Action.type(flatPurPrice, price);
Log.info("Flat purchase price is enetered :" + price);
test=ExtentManager.test.info("Flat purchase price is enetered :" + price);
	}
	public void selectBlockFlat() throws InterruptedException {	
		select = new Select(selectBlock);
		select.selectByIndex(2);
		Log.info("Block is selected ");
		test=ExtentManager.test.info("Block is selected ");
		select = new Select (selectFlat);
		select.selectByIndex(2);
		Log.info("Falt is selected");
		test=ExtentManager.test.info("Falt is selected");
		Action.JSClick(driver,addOwnerBtn );
		Log.info("Add owner button is clicked");
		test= ExtentManager.test.info("Add owner button is clicked");
		Thread.sleep(1000);
		
	}
	public void verifyValidation() throws InterruptedException {
	boolean status = successPopup.isDisplayed();
if (status=true) {
System.out.println("Validation popup is displayed");

}
else {
	System.out.println("Validation popup is not displayed");
}


Log.info("Validation popup is displayed");
test=ExtentManager.test.info("Validaton popup is displayed");
Thread.sleep(1000);
 boolean status1 = successMsg.isDisplayed();
  String msg = successMsg.getText();
  System.out.println(msg);
Assert.assertEquals(msg, "Owner Created Successfully");
  Log.info("Vaidation message is displayed: " + msg);
  test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Vaidation message is displayed: " + msg, ExtentColor.GREEN));
}
	/*public void clickCWFlatsPageValidationPopup() throws InterruptedException {
	
	WebDriverWait w = new WebDriverWait(driver, 20);
	w.until(ExpectedConditions.visibilityOf(  ValidationPopUp));
	//boolean popUpDisplayed = validationPopUp.isDisplayed();
	boolean popupDisplayed=  ValidationPopUp.isDisplayed();
	try {
		Assert.assertEquals(popupDisplayed, true);
		test= Extent.test.log(Status.PASS, "validation popup is visible as per the requriment");
	}
	catch(Exception e) {
		e.getMessage();*/
	}
