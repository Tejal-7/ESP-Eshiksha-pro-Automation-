package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;

public class CWViewOwnersListPOM extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	Random randam ;
	Faker fake;
@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page-container']/div[@id='sidebar']/div[@id='sidebar-scroll']/div[1]/ul[1]/li[3]/a[1]/i[1]")
WebElement flats ;
@FindBy(xpath="//a[contains(text(),'View Owners List')]")
WebElement viewOwnerList ;

}
