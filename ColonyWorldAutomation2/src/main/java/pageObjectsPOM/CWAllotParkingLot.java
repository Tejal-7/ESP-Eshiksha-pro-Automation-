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
import com.github.javafaker.Faker;
import action.Action;
import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWAllotParkingLot extends BaseClass  {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[5]/a[1]/i[1]")
	WebElement parking;
	@FindBy(xpath="//a[contains(text(),'Allot Parking Lots')]")
	WebElement allot_parkinglots;
	@FindBy(xpath="//select[@id='block']")
	WebElement selectBlock;
	@FindBy(xpath="//select[@id='flat']")
	WebElement  select_flat;
	@FindBy(xpath="//input[@id='slotname']")
	WebElement slot_name;
	@FindBy(xpath="//input[@id='allotParkingLots']")
	WebElement allotSlot;
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement verification_popup;
	@FindBy(xpath="//strong[contains(text(),'Parking Lot added Successfully')]")
	WebElement verificaton_msg;
	
	String vmsg= "Parking Lot added Successfully";
	public CWAllotParkingLot() {
		PageFactory.initElements(driver, this);
	}
	public void clickParkingLots() {
		Action.JSClick(driver, parking);
		Log.info("Parking is clicked");
		test=ExtentManager.test.info("Parking is clicked");
		Action.JSClick(driver, allot_parkinglots);
		Log.info("Parking Lots is clicked");
		test= ExtentManager.test.info("Parking lots is clicked");
		
	}
	public void inpParkingLots() {
		select = new Select(selectBlock);
		select.selectByVisibleText("B");
		Log.info("Block is selected");
		test=ExtentManager.test.info("Block is selected");
		select = new Select (select_flat);
		select.selectByVisibleText("Maria Skiles");
		Log.info("Flat is selected");
		test=ExtentManager.test.info("Flat is selected");
		Action.type(slot_name, "Maria b/07")	;	
		Log.info("Slot name is entered");
		test=ExtentManager.test.info("Slot name is entered");
		Action.JSClick(driver, allotSlot);
		Log.info("Allot Slot is clicked");
		test=ExtentManager.test.info("Allot Slot is clicked");
	}
	public void verifyValidation() {
		boolean status = verification_popup.isDisplayed();
		 if (status =true) {
			 System.out.println("Verification popup is displayed");
		 }
		 else {
			 System.out.println("Verification popup is not displayed");
		 }
		 Log.info("Verification popup displayed");
		 test=ExtentManager.test.info("Verification popup displayed");
	boolean status2 = verificaton_msg.isDisplayed();
	try {
		String MSG = verificaton_msg.getText();
		System.out.println(MSG);
		Assert.assertEquals(MSG, vmsg);
		Log.info("Verification message is dispyaed as : "+ MSG);
		test= ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Verification message is dispyaed as : "+ MSG,ExtentColor.GREEN ));
	}
	catch (Exception e) {
		e.getMessage();
	}
	}
	
}
