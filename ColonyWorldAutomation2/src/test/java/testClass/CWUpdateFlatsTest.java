package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;

import pageObjectsPOM.CWLoginPomClass;
import pageObjectsPOM.CWUpdateFlatsPOM;

public class CWUpdateFlatsTest extends BaseClass{
	CWLoginPomClass loginCW;
	CWUpdateFlatsPOM update_Flat;
String user ="adminbrighthomes@colonyworld.com";
String pass="12345";
@BeforeMethod
public void beforeMethod() {
	launchApp();
}
@Test
public void updateflat() throws InterruptedException {
	loginCW= new CWLoginPomClass();
	loginCW.colonyWorldogin(user, pass);
	update_Flat= new CWUpdateFlatsPOM ();
	update_Flat.clickUpdateFlats();
	update_Flat.selectUpdateFlats();
	update_Flat.clickAllotFlat();
	update_Flat.verifyValidation();
	update_Flat.viewLien();
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
