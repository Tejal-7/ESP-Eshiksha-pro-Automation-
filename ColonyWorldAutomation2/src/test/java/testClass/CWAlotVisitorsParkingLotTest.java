package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAlotVisitorParkingLot;
import pageObjectsPOM.CWLoginPomClass;

public class CWAlotVisitorsParkingLotTest extends BaseClass {
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWAlotVisitorParkingLot  parking;
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void visitorsParking() throws InterruptedException {
		loginCW = new CWLoginPomClass ();
		loginCW.colonyWorldogin(user, pass);
		parking	=new CWAlotVisitorParkingLot();
		parking.clickAllotVisitorParking();
		parking.inpAlotVisitorsParking();
		parking.verifyValidation();
		parking.verify();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
