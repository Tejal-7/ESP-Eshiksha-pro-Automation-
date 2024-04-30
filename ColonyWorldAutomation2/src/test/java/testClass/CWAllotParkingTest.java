package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAllotParkingLot;
import pageObjectsPOM.CWLoginPomClass;

public class CWAllotParkingTest extends BaseClass{
	CWLoginPomClass loginCW;String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWAllotParkingLot allotP;
	@BeforeMethod
	public void beforemethod() {
		launchApp();
	}
	@Test
	public void alotparking() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		 allotP = new CWAllotParkingLot();
		 allotP.clickParkingLots();
		 allotP.inpParkingLots();
		 allotP.verifyValidation();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
