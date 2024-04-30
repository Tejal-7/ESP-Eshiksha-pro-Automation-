package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.asserts.SoftAssert;
import action.Action;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class CWGenerateShareCertf extends BaseClass {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
	@FindBy(xpath="//a[contains(text(),'Share Certificate')]")
	WebElement shareCert;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[3]/a[1]/i[1]")
	WebElement flats  ;
	@FindBy(xpath="//input[@id='add_range']")
	WebElement addRange;
	@FindBy(xpath="//input[@id='sh_prefix']")
	WebElement sharePreFix ;
	@FindBy(xpath="//input[@id='sh_from']")
	WebElement rangeFrom ;
	@FindBy(xpath="//input[@id='sh_from']")
	WebElement rangeTo;
	@FindBy(xpath="//input[@id='generate_cer']")
	WebElement  geneCert;

	public  CWGenerateShareCertf () {
		PageFactory.initElements(driver, this);
	}
	public void clickShareCert(){
		Action.JSClick(driver, flats);
		Log.info("Flats is clicked ");
		test= ExtentManager.test.info("Flats is clicked");
		Action.JSClick(driver, shareCert);
		Log.info("Share certificate is clicked ");
		test=ExtentManager.test.info("Share certificate is clicked ");
	}
	public void inpShareCert() {
		fake= new Faker();
	Action.JSClick(driver, addRange);
	Log.info("Add range clicked");
	test=ExtentManager.test.info("Add range clicked");
	sharePreFix.clear();
	 String cName = fake.name().username();
	Action.type(sharePreFix, cName );
	Log.info("Share prefix name is provided: "+ cName);
	rangeFrom.clear();
	int CNumber = fake.number().numberBetween(100,200);	
	 rangeFrom.sendKeys(String.valueOf(CNumber));
	 Log.info("Range From is enetered:" +CNumber );
	test=ExtentManager.test.info("Range From is enetered:" +CNumber);
	rangeTo.clear();
	int Cnumber2= fake.number().numberBetween(200,300);
	rangeTo.sendKeys(String.valueOf(Cnumber2));
	Log.info("Range to is entered: "+Cnumber2 );
	test=ExtentManager.test.info("Range to is entered: "+Cnumber2);
	Action.JSClick(driver,geneCert);
	Log.info("geneCert is clicked ");
	test=ExtentManager.test.info("geneCert is clicked ");

	
	
	}
				
	

	
}