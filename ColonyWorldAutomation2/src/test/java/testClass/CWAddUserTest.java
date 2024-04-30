package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddUserPOM;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddUserTest extends BaseClass  {
	CWAddUserPOM adduser;
	CWLoginPomClass loginCW;
	String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void addUser() throws InterruptedException {
	adduser= new 	CWAddUserPOM();
	loginCW= new CWLoginPomClass();
	loginCW.colonyWorldogin(user, pass);
	adduser.clickAddUser();
	adduser.selectAddUser();
	adduser.inpAddUser();
	adduser.clickAddUser1();
	adduser.verifyValidation();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
}
