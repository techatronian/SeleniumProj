package myTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test
  public void Validate_Loginwith_ValidCredentials() {
	  
	  SoftAssert softAssert = new SoftAssert();
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	  
	  driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("test1111@gmail.com");
	  driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("password");
	  driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();	  
	 
	  String ActualVal = "";
	  String ExpectedVal = "test";
	  try {
		  WebElement userName = driver.findElement(By.xpath("//a[contains(normalize-space(),'Logged in as')]/b"));
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(userName));
		  ActualVal = userName.getText();		 
	  }catch (Exception e) {
		e.printStackTrace();
	}
	  Assert.assertEquals(ActualVal, ExpectedVal); //softAssert
	  //Assert.assertEquals(ActualVal, ExpectedVal);   //HardAssert
	  int totalproductCount = driver.findElements(By.xpath("//div[@class='features_items']/div[contains(@class,'col')]")).size();
	  softAssert.assertEquals(totalproductCount, 34);
	  //Assert.assertEquals(totalproductCount, 34);  //HardAssert	  
	  System.out.println("Testcase completeled...");
	  softAssert.assertAll();
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {                                                                                              
	  driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
  }

  @AfterMethod
  public void afterMethod() {
	  try {
	  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	  }catch (Exception e) {
		e.printStackTrace();
	}
	  
  }

  @BeforeClass
  public void beforeClass() {
	  driver.get("https://www.automationexercise.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @AfterClass
  public void afterClass() {
	 //clear cache
	  //clear cookies
  }
  
  @BeforeSuite
  public void DriverInitialization() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  
  @AfterSuite
  public void DriverTermination() {
	  driver.quit();
  }
  
  

}
