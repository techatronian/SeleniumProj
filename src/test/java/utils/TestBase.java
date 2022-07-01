package utils;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends Screenshot {

	public WebDriver driver;
	public WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterClass
	public void afterClass() {
		// clear cache
		// clear cookies
	}

	@BeforeSuite
	public void ReportInitialization() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//target/result.html");
		extent.attachReporter(spark);

		// optional
		extent.setSystemInfo("Machine", "Windows 10");
		extent.setSystemInfo("Application", "Retail application");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Suite", "Regression");		
	}
	
	@BeforeTest
	@Parameters("browserType")
	public void DriverInitialization(String browserType ) {		
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		default :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
	}
	
	@AfterTest
	public void TerminateDriver() {
		driver.quit();
	}
	

	@AfterSuite
	public void TerminateReport() {		
		extent.flush();
	}

	@BeforeMethod
	public void CreateTestforReport(Method method) {
		test = extent.createTest(method.getName());
	}

	@AfterMethod
	public void PrintResults(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL, "Please find the attachments!! "
					+ test.addScreenCaptureFromPath(CaptureScrenshot(driver, "screenshot")));
		}
	}

}
