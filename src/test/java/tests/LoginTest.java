package tests;

import static org.testng.Assert.expectThrows;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.TestBase;

public class LoginTest extends TestBase{

	@Test
	public void Validate_LoginTest() {
		
		//Navigate from Home to Login Page
		HomePage objHome = new HomePage(driver);
		objHome.NavigateTo_SignUp_Login();
		test.log(Status.INFO, "Navigate to SignIn page");
		
		//Login Application in Login Page
		LoginPage objLogin = new LoginPage(driver);
		objLogin.LoginInToYourAccount("test1111@gmail.com", "password");
		test.log(Status.INFO, "Enter Email&Password and click on login");
		
		//Validate User in HomePage
		Assert.assertEquals(objHome.getUserName(), "test");
		test.log(Status.PASS, "The USername is successfully matched.."+objHome.getUserName());
		
		//Navigate from Hpme to Product Page
		objHome.NavigateTo_Products();
		test.log(Status.INFO, "Navigate to Producrt page");
		
		//Validate product count
		ProductPage objProduct = new ProductPage(driver);
		Assert.assertEquals(objProduct.getProductCount(), 34);	
		test.log(Status.PASS, "The products are successfullt matched..and the total product count is"+ objProduct.getProductCount());
		
	}
	
	@Test
	public void Validate_TopMenuLinks() {
		HomePage objHome = new HomePage(driver);		
		List<String> Expected = Arrays.asList("Home"," ? Products"," Cart"," Signup / Login"," Test Cases"," API Testing"," Video Tutorials"," Contact us");
		
		System.out.println(Expected);
		System.out.println(objHome.getTopMenuLinks());
		Assert.assertTrue(Expected.size() == objHome.getTopMenuLinks().size(),"The actual size is "+objHome.getTopMenuLinks().size() + " and the expected size is "+Expected.size());
		Assert.assertTrue(Expected.containsAll(objHome.getTopMenuLinks()));
	}
	

	 
}
