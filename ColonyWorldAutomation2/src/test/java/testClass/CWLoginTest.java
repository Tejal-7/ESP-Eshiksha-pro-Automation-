package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWLoginPomClass;

public class CWLoginTest extends BaseClass  {
	CWLoginPomClass loginCW;
String user ="adminbrighthomes@colonyworld.com";
String pass="12345";

@BeforeMethod
public void beforeMethod() {
	launchApp();
}
@Test
public void CWLogin() throws InterruptedException {
	loginCW= new CWLoginPomClass();
	loginCW.colonyWorldogin(user, pass);
}
@AfterMethod
public void afterMethod() {
	driver.quit();
}

}
