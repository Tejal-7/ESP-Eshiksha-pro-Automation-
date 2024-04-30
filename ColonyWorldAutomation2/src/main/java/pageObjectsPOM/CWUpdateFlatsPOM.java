package pageObjectsPOM;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
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

import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWUpdateFlatsPOM extends BaseClass {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	Select select ;

	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[3]/a[1]/i[1]")
	WebElement flats ;
	@FindBy(xpath="//a[contains(text(),'Update Flats')]")
	WebElement updateFlat;
@FindBy(xpath="//select[@id='allot']")
WebElement selectUserType;
@FindBy(xpath="//select[@id='userList']")
WebElement select_user;
@FindBy(xpath="//select[@id='nomination']")
WebElement nominatio_registered;
@FindBy(xpath="//select[@id='lienSelect']")
WebElement select_lien;
@FindBy(xpath="//input[@id='lienDate']")
WebElement lien_date;
@FindBy(xpath="//textarea[@id='lienRemark']")
WebElement remarks;
@FindBy(xpath="//input[@id='allotFlats']")
WebElement allotFlats;
@FindBy(xpath="(//div[@class='modal-content'])[3]")
WebElement verification_popup;
@FindBy(xpath="//strong[contains(text(),'Update Flats Successfully')]")
WebElement verification_msg;
@FindBy(xpath="//a[contains(text(),'View Lien')]")
WebElement view_lien;
@FindBy(xpath="//td[contains(text(),'Ronak Singh')]")
WebElement name;
@FindBy(xpath="//body/div[@id='messageModal']/div[2]/div[1]/div[3]/button[1]")
WebElement close_btn;

public CWUpdateFlatsPOM () {
	PageFactory.initElements(driver, this);
}
public void clickUpdateFlats() {
	Action.JSClick(driver, flats);
	Log.info("Flats is clicked");
	test=ExtentManager.test.info("Flats is clicked");
	Action.JSClick(driver, updateFlat);
	Log.info("Update Flats is clicked");
	test=ExtentManager.test.info("Update Flats is clicked");
	
}
public void selectUpdateFlats() throws InterruptedException {
	fake = new Faker();
	select = new Select (selectUserType);
	//select.selectByIndex(1);
	select.selectByIndex(2);
	Log.info("Tenant user type is selected");
	test=ExtentManager.test.info("Tenant user type is selected");
	//Log.info("resident user type is selected");
	//test=ExtentManager.test.info("Resident user type is selected");
select = new Select (select_user);
select.selectByVisibleText("Ronak Singh");
Log.info("User is selected");
test=ExtentManager.test.info("User is selected");
Thread.sleep(500);
select = new Select (nominatio_registered);
select.selectByIndex(1);
Log.info("Nomination is selected");
test=ExtentManager.test.info("Nomination is selected");
select = new Select (select_lien);
select.selectByIndex(2);
Log.info("Lien is selected");
test=ExtentManager.test.info("Lien is selected");
Date dates = fake.date().birthday();
lien_date.sendKeys(String.valueOf(dates));
Action.type(remarks, "Yes");
Log.info("Remark is Added ");
}
	public void clickAllotFlat() {
		Action.JSClick(driver, allotFlats);
		Log.info("Allots flats is clicked");
		test =ExtentManager.test.info("Allots flats is clicked");
	}
	public void verifyValidation() {
	boolean vPopup = verification_popup.isDisplayed();
	
try {	
	if (vPopup=true) {
		System.out.println("verification popup is displayed");
		
	}
	else {
		System.out.println("Verification popup is not displaying ");
	}}
catch(Exception e) {
	e.getMessage();
}
Log.info("Verification popup is displaying ");
boolean status= verification_msg.isDisplayed();
try {String msg = verification_msg.getText();
System.out.println(msg);

	Log.info("Verification message displayed succesfully : "+ msg );
	test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Verification message displayed succesfully : "+msg ,ExtentColor.GREEN));
}
	catch(Exception e)
{
		e.getMessage();
		}

}
	public void viewLien() throws InterruptedException {
		
		Action.JSClick(driver, close_btn);
		
	
		Thread.sleep(500);
		Action.moveToElement(driver, view_lien);
		Thread.sleep(500);
		Log.info("View lien is clicked");
		test=ExtentManager.test.info("View lien is clicked");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("scrollBy, (0,-100)");
		Action.moveToElement(driver, name);
		
		boolean Lien_name = name.isDisplayed();
		if (Lien_name=true) {
			System.out.println( Lien_name);
		}
		else {
			System.out.println("name is displaying ");
		}
	}

}