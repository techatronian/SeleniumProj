package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestSuite1 {

	@Test
	@Parameters("ToolName")
	public void myTest01(String ToolName) {
		System.out.println("Testcase01 and the tool name is "+ToolName);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test TestSuite1");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test TestSuite1");
	}
	
	
	@Test
	public void myTest02() {
		System.out.println("Testcase02");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method TestSuite1...");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method TestSuite1...");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class TestSuite1...");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class TestSuite1...");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite TestSuite1...");
	}

}
