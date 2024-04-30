package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddOwners;
import pageObjectsPOM.CWGenerateShareCertf;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddOwnerTest extends BaseClass{
	CWLoginPomClass loginCW;String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWAddOwners owner ;
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void addOwner() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		owner= new CWAddOwners();
		owner.addOwner();
		owner.inpAddOwner();
		owner.selectBlockFlat();
		
	owner.	verifyValidation() ;
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
