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

	@Test(priority = 3)
	public void myTest01() {
		System.out.println("Testcase02");

	}

	@Test(priority = 2)
	public void myTest02() {
		System.out.println("Testcase01");
	}

	@Test(priority = 1)
	public void myTest03() {
		System.out.println("Testcase03");
	}
}
