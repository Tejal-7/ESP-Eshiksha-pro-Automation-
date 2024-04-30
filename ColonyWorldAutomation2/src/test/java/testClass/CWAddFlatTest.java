package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddFlats;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddFlatTest extends BaseClass{
	CWAddFlats flats;
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void addFlats() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		flats=new 	CWAddFlats();
		flats.addFlat();
		flats.selectBlocks();
		flats.AddFlat2();
		flats.verifySuccessMsg();
	
	}
	@Test
	public void editFlat() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		flats=new 	CWAddFlats();
		flats.	updateFlat();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	
	
	
	
}
