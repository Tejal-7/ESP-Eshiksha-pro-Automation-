package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddTenant;

import pageObjectsPOM.CWLoginPomClass;

public class CWAddTenantTests extends BaseClass {
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWAddTenant tenant ;
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test 
	public void addTenant() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
		tenant= new CWAddTenant();
		tenant.clickAddTenant();
		tenant.inpAddTenant();
		tenant.selectAddTenant();
		tenant.clickAddResident();
		tenant.VerifyValidation();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
