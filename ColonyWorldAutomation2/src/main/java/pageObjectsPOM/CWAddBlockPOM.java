package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

public class CWAddBlockPOM  extends BaseClass {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	@FindBy(xpath="(//i[@class='fa fa-angle-right sidebar-nav-indicator'])[1]")
	WebElement blocks;
@FindBy(xpath="//a[contains(text(),'Add Block')]")
	WebElement addBlock;
@FindBy(xpath="//input[@id='name']")
WebElement blockName ;
@FindBy(xpath="//input[@id='addBlock']")
WebElement addBlockBtn;
@FindBy(xpath="(//div[@class='modal-content'])[3]")
WebElement SuccessPopup;
@FindBy(xpath="//strong[contains(text(),'Block Created Successfully')]")
WebElement validationMsg;
@FindBy(xpath="//tbody/tr[1]/td[3]/a[1]")
WebElement editButton ;
@FindBy(xpath="//input[@id='updateBlock']")
WebElement updateBtn;
@FindBy(xpath="(//div[@class='modal-content'])[3]")
WebElement verificationPopup1;
@FindBy(xpath="//strong[contains(text(),'Block Update Successfully')]")
WebElement validationMsg1;
@FindBy(xpath="//a[contains(text(),'View Blocks')]")
WebElement viewBlocks;
@FindBy(xpath="//tbody/tr[10]/td[3]/a[2]/i[1]")
WebElement deleteBtn;



public CWAddBlockPOM() {
	PageFactory.initElements(driver,this);	
}
public void clickBlocks(){
Action.JSClick(driver, blocks);
Log.info("Blocks is clicked succesfully");
test=ExtentManager.test.info("Blocks is clicked succesfully");
	Action.JSClick(driver, addBlock);
	Log.info("Add blocks clicked succesfully");
test=ExtentManager.test.info("Add blocks clicked succesfully");


}
public void inpBlockName () throws InterruptedException {
	fake= new Faker();
	String bName= fake.name().name();
	Action.type(blockName , bName);
	Log.info("Block name is entered Succesfully");
	test=ExtentManager.test.info("Block name is entered Succesfully");
	Thread.sleep(1000);
}
public void clickAddBlock() throws InterruptedException {
	Action.JSClick(driver, addBlockBtn);
	Log.info("Add block is clicked succesfully");
	test =ExtentManager.test.info("Add block is clicked succesfully");
	Thread.sleep(500);
}
public void verifySuccessPopup() {
	boolean status = SuccessPopup.isDisplayed();
	if (status=true) {
		System.out.println("Success popup is displayed");
	}else {
		System.out.println("Sucesss popup is not displaying ");
	}
	 Log.info("Sucess popup is displayed");
	 test= ExtentManager.test.info("Success popup is displayed");
}
public void verifySuccessMsg() {
	boolean successMsg = validationMsg.isDisplayed();
	
	String vMs= validationMsg.getText();
System.out.println(vMs);
Assert.assertEquals(successMsg, true);
	Log.info("Validation message is displayed:" + vMs);
	test= ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Validation message is displayed: "+ vMs,ExtentColor.GREEN));
}
////////////////////////////////////////////Edit Block///////////////////////////////////////
public void editBlock() throws InterruptedException {
	Action.moveToElement(driver, viewBlocks);
	Action.JSClick(driver,  viewBlocks);
	Action.moveToElement(driver,editButton );
	Action.JSClick(driver, editButton );
	Log.info("Edit button is clicked succesfully");
	test=ExtentManager.test.info("Edit button is clicked succesfully");
	Thread.sleep(500);
	Action.moveToElement(driver,  blockName);
	fake = new Faker();
	 String bn = fake.animal().name();	
	Action.type(blockName, bn );
	Log.info("Updated block name is added ");
	test=ExtentManager.test.info("Updated block name is added ");
	Action.JSClick(driver, updateBtn);
	Log.info("update button is clicked succesfully");
	
	
}
public void verifyEditSuceessMsg() {
	 boolean status1 = verificationPopup1.isDisplayed();
	 Assert.assertEquals(status1, true);
Log.info("update success popup is displayed");
test=ExtentManager.test.info("update success popup is displayed");
boolean Vmsg1 = validationMsg1.isDisplayed();
Assert.assertEquals(Vmsg1, true);
String msg1= validationMsg1.getText();
System.out.println(msg1);
Log.info("Validation msg is displayed succesfully");
test=ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("validation msg is displayed succesfully:"+ msg1,ExtentColor.GREEN));
}
//////////////////////////////////DeleteBlock////////////////////////////////


}
