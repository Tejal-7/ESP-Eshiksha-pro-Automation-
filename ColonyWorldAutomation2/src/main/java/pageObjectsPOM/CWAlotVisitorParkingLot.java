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

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWAlotVisitorParkingLot extends BaseClass {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select;
	String SMsg="Visitor Parking Lot added Successfully";
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[5]/a[1]/i[1]")
	WebElement parking;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[5]/ul[1]/li[3]/a[1]")
	WebElement visitor_parking_lot;
	@FindBy(xpath="//select[@id='block']")
	WebElement select_block;
	@FindBy(xpath="//input[@id='penaltyCharges']")
	WebElement penalty_charges;
	@FindBy(xpath="//input[@id='slotname']")
	WebElement parking_slot_Name;
	@FindBy(xpath="//input[@id='visitorParkingLots']")
	WebElement alot_slot;
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement SuccessPopup;
	@FindBy(xpath="//strong[contains(text(),'Visitor Parking Lot added Successfully')]")
	WebElement success_msg ;
	
	public CWAlotVisitorParkingLot() {
		PageFactory.initElements(driver, this);
	}
	public void clickAllotVisitorParking() {
	Action.JSClick(driver, parking);
	Log.info("Parking is clicked ");
	test=ExtentManager.test.info("Parking is clicked ");
	Action.JSClick(driver, visitor_parking_lot);
	Log.info("Visitor parking lot is clicked");
	test=ExtentManager.test.info("Visitor parking lot is clicked");
			
	}
	public void inpAlotVisitorsParking() {
		fake = new Faker ();
		select = new Select( select_block);
		select .selectByVisibleText("B");
		Log.info("Block is selected");
		test=ExtentManager.test.info("Block is selected");
		
		Action.type(penalty_charges, "50");
		Log.info("Penalty charges are added ");
		test=ExtentManager.test.info("Penalty charges are added ");
	     String parkingSlotname = fake.regexify("[a-z]");
	
		Action.type( parking_slot_Name, parkingSlotname);
		Log.info("Parking slot name is entered: "+  parkingSlotname);
		test=ExtentManager.test.info("Parking slot name is entered: "+  parkingSlotname);
		Action.JSClick(driver, alot_slot);
		Log.info("Alot slot is clicked");
		test=ExtentManager.test.info("Alot slot is clicked");
	}
	public void verifyValidation() {
	boolean status = SuccessPopup.isDisplayed();
	if (status= true) {
		System.out.println("Validation poup is displayed");
		
	}
	else {
		System.out.println("Validation popup is not displaying");
	}
	test=ExtentManager.test.info("Validation poup is displayed");
	Log.info("Validation poup is displayed");
	}
	public void verify() {
	boolean status2 = success_msg.isDisplayed();
	try {
	String msg = success_msg.getText();
	System.out.println(msg);
	Assert.assertEquals(msg, SMsg);
	Log.info("Validation message is displayed as : "+ msg);

	//test= ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Verification message is dispyaed as : "+ msg,ExtentColor.GREEN ));
	}
	catch (Exception e ) {
		 Log.error("Exception occurred while verifying success message: " + e.getMessage());	
	}
	
	}
	
	
}
