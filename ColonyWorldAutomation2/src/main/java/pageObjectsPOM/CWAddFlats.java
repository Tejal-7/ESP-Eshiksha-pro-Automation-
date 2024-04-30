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

public class CWAddFlats extends BaseClass {
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
	@FindBy(xpath="//a[contains(text(),'Add Flat')]")
	WebElement addFlat  ;
	@FindBy(xpath="//select[@id='block']")
	WebElement selectBlock;
	@FindBy(xpath="//input[@id='name']")
	WebElement flatname;
	@FindBy(xpath="//input[@id='coverd']")
	WebElement coveredArea;
	@FindBy(xpath="//input[@id='carpet']")
	WebElement carpetArea;
	@FindBy(xpath="//input[@id='addFlat']")
	WebElement addFlatbutton;
	@FindBy(xpath="(//div[@class='modal-content'])[4]")
	WebElement successPopup;
	@FindBy(xpath="//strong[contains(text(),'Flat Created Successfully')]")
	WebElement SuccessMsg;
	@FindBy(xpath="//a[contains(text(),'View Flats')]")
	WebElement viewFlat;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='main-container']/div[@id='page-content']/div[@id='Div2']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]")
	WebElement pageNo;
	@FindBy(xpath="//tbody/tr[3]/td[5]/a[1]")
	WebElement editButton;
	@FindBy(xpath="//input[@id='updateFlat']")
	WebElement updateFlat;
	@FindBy(xpath="(//div[@class='modal-content'])[4]")
	WebElement UpdatePopup;
	@FindBy(xpath="//strong[contains(text(),'Flat Update Successfully')]")
	WebElement updateMsg;
	public CWAddFlats () {
		PageFactory.initElements(driver, this);
	}
	public void addFlat() {
		Action.JSClick(driver,flats );
		Log.info("Flats is clicked");
	test=ExtentManager.test.info("Flats is clicked");
	
	Action.JSClick(driver, addFlat);
	Log.info("Add Flat is clicked");
	test=ExtentManager.test.info("Add Flat is clicked");
	}
	public void selectBlocks() {
		select= new Select (selectBlock);
	select.selectByIndex(2);
	String blockName = select.getFirstSelectedOption().getText();
	System.out.println(blockName);
	Log.info("Block is selected :" + blockName);
	test=ExtentManager.test.info("\"Block is selected :\" + blockName");
		
	}
	public void AddFlat2() {
		fake= new Faker();
		String flat= fake.name().name();
		Action.type(flatname, flat);
		Log.info("Flat name is eneterd : " +flatname);
		test = ExtentManager.test.info("Flat name is eneterd : " +flatname);
			 int cover =fake.number().numberBetween(1000, 2000);
			 coveredArea.sendKeys(String.valueOf(cover));	
			Log.info("Covered area is entered: " + cover);
			test= ExtentManager.test.info("Covered area is entered: " + cover);
			
			int carpet=fake.number().numberBetween(500, 1000);
			carpetArea.sendKeys(String.valueOf(carpet));
			Log.info("Carpet area is entered :" +carpet);
			test= ExtentManager.test.info("Carpet area is entered :" +carpet);
		Action.JSClick(driver,addFlatbutton);
		Log.info("Add flat is clicked");
		test=ExtentManager.test.info("Add flat is clicked");
			
					
	}
	public void verifySuccessMsg() {
		boolean status1 = successPopup.isDisplayed();
		if (status1= true) {
		System.out.println("Popup is displayed");	
		}
		else {
		System.out.println("popup is not displaying ");
		}
		
		Log.info("Popup is displayed");
		test=ExtentManager.test.info("Popup is displayed");
	boolean vMsg = SuccessMsg.isDisplayed();
    String SMsg = SuccessMsg.getText();
	System.out.println(SMsg);
	Assert.assertEquals(SMsg, "Flat Created Successfully");
	Log.info("Flat is created succesfully :" + SMsg);
	test=ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Flat is created succesfully: "+ SMsg, ExtentColor.GREEN));
				
	}
	////////Edit Flats////////
	
		public void updateFlat() {	
			Action.JSClick(driver,viewFlat);
			Log.info("View Flat is clicked");
			test=ExtentManager.test.info("View Flat is clicked");
			Action.JSClick(driver,pageNo);
			Log.info("Moved to next page ");
			test= ExtentManager.test.info("Moved to next page ");
			Action.JSClick(driver, editButton);
			Log.info("Edit button is clicked ");
			test=ExtentManager.test.info("Edit button is clicked ");
			Action.JSClick(driver, updateFlat);
			Log.info("Update button clicked ");
			test= ExtentManager.test.info("Update button clicked ");
		boolean status = UpdatePopup.isDisplayed();
		if (status=true) {
			System.out.println("popup is displayed");
		}
		else {
			System.out.println("popup is not displaying ");
		}
		Log.info("Popup displayed");
		test=ExtentManager.test.info("Popup Displayed");
		boolean uMsg = updateMsg.isDisplayed();
		
		String umsg1= updateMsg.getText();
		System.out.println(umsg1);
		Log.info("Update message is :" + umsg1);
		test=ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Update message is :" + umsg1, ExtentColor.GREEN));
		
		
		}


}
