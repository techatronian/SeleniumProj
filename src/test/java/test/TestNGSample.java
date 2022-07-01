package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGSample {

	@BeforeMethod
	public void LoginApplication() {
		System.out.println("Login Application");
	}
	
	@AfterMethod
	public void LogoutApplication() {
		System.out.println("Logout Application");
	}
	
	@BeforeClass
	public void InsertTestData() {
		System.out.println("Load Testdata");
	}
	
	@AfterClass
	public void ClearTestData() {
		System.out.println("Clear Testdata");
	}
	
	
	
	@Test
	public void Val_LoginTestCase() {
		System.out.println("Login Check");
	}
	
	@Test
	public void Val_AddAccountTestCase() {
		System.out.println("Add Account check");
	}
	
	@Test
	public void Val_RemoveAccountTestCase() {
		System.out.println("RemoveAccount check");
	}
}
