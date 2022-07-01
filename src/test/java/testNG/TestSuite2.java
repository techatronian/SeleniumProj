package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class TestSuite2 {

	@Test
	@Parameters("ToolName")
	public void myTest01(String ToolName) {
		System.out.println("Testcase01 and the toolname is "+ToolName);
	}
	
	@Test
	public void myTest02() {
		System.out.println("Testcase02");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method TestSuite2...");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method TestSuite2...");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class TestSuite2...");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class TestSuite2...");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite TestSuite2...");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite TestSuite2...");
	}

}
