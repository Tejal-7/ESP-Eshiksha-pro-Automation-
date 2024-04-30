package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectsPOM.CWAddBlockPOM;
import pageObjectsPOM.CWLoginPomClass;

public class CWAddBlockTest extends BaseClass {
	CWLoginPomClass loginCW;
	CWAddBlockPOM addBlock;
String user ="adminbrighthomes@colonyworld.com";
String pass="12345";
@BeforeMethod
public void beforeMethod() {
	launchApp();
}
@Test
public void addBlocksTest() throws InterruptedException {
	loginCW= new CWLoginPomClass();
	loginCW.colonyWorldogin(user, pass);
	addBlock= new CWAddBlockPOM ();
	 addBlock.clickBlocks();
	 addBlock.inpBlockName();
	 addBlock.clickAddBlock();
	 addBlock.verifySuccessPopup();
	 addBlock.verifySuccessMsg();
	
	 
	
	
}
@Test
public void editBlock() throws InterruptedException {
	loginCW= new CWLoginPomClass();
	loginCW.colonyWorldogin(user, pass);
	addBlock= new CWAddBlockPOM ();
	 addBlock.clickBlocks();
	 
	 addBlock. editBlock();
	addBlock. verifyEditSuceessMsg();
	
}
@AfterMethod
public void afterMethod() {
	driver.close();
}

}
