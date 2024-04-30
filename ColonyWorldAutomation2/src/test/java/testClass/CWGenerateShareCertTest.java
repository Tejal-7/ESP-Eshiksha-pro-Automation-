package testClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWGenerateShareCertf;
import pageObjectsPOM.CWLoginPomClass;

public class CWGenerateShareCertTest extends BaseClass {
	CWLoginPomClass loginCW;String user ="adminbrighthomes@colonyworld.com";
	String pass="12345";
	CWGenerateShareCertf cert;
	
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	@Test
	public void generateCertificate() throws InterruptedException {
		loginCW= new CWLoginPomClass();
		loginCW.colonyWorldogin(user, pass);
	cert= new 	CWGenerateShareCertf ();
	cert.clickShareCert();
	cert.inpShareCert();
	}
}
