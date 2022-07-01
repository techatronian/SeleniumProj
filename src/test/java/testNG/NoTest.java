package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class NoTest {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method NoTest...");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method NoTest...");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class NoTest...");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class NoTest...");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite NoTest...");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite NoTest...");
	}

}
