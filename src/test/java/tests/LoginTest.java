package tests;

import static org.testng.Assert.expectThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.TestBase;
import utils.Testdata;

public class LoginTest extends TestBase{

	private static XSSFSheet excelSheet;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	
	@Test(dataProvider = "ExcelData")
	public void Validate_LoginTest(String username, String password) {
		
		//Navigate from Home to Login Page
		HomePage objHome = new HomePage(driver);
		objHome.NavigateTo_SignUp_Login();
		test.log(Status.INFO, "Navigate to SignIn page");
		
		//Login Application in Login Page
		LoginPage objLogin = new LoginPage(driver);
		objLogin.LoginInToYourAccount(username,password);
		test.log(Status.INFO, "Enter Email&Password and click on login");
		
		//Validate User in HomePage
		Assert.assertEquals(objHome.getUserName(), Testdata.getData("expectedUserName"));
		test.log(Status.PASS, "The USername is successfully matched.."+objHome.getUserName());
		
		//Navigate from Hpme to Product Page
		objHome.NavigateTo_Products();
		test.log(Status.INFO, "Navigate to Producrt page");
		
		//Validate product count
		ProductPage objProduct = new ProductPage(driver);
		Assert.assertEquals(objProduct.getProductCount(), 34);	
		test.log(Status.PASS, "The products are successfullt matched..and the total product count is"+ objProduct.getProductCount());
		
	}
	
	@Test(enabled = false)
	public void RegisterUser(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		test.log(Status.PASS, "User registration is successfull");
	}
	
	@Test(enabled = false)
	public void Validate_TopMenuLinks() {
		HomePage objHome = new HomePage(driver);		
		List<String> Expected = Arrays.asList("Home"," ? Products"," Cart"," Signup / Login"," Test Cases"," API Testing"," Video Tutorials"," Contact us");
		
		System.out.println(Expected);
		System.out.println(objHome.getTopMenuLinks());
		Assert.assertTrue(Expected.size() == objHome.getTopMenuLinks().size(),"The actual size is "+objHome.getTopMenuLinks().size() + " and the expected size is "+Expected.size());
		Assert.assertTrue(Expected.containsAll(objHome.getTopMenuLinks()));
	}
	
	
	@DataProvider(name = "objectData")
	public Object[][] dataproviderMethod(){
		
		return new Object[][] {{"test1111@gmail.com","password"},{"test2@gmail.com","password2"}};
		
	}
	
	@DataProvider(name="ExcelData")
	public Object[][] excelDataprovider() throws IOException{
		
		return getExcelData("D:\\Training_Eclipse_Workspace\\SeleniumJavaProject\\src\\test\\resources\\TestData.xlsx","Sheet1");
	}
	
	
	
	public static Object[][] getExcelData(String fileName, String sheetname) throws IOException {
		
		String[][] dataArray = null;
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			excelWorkbook = new XSSFWorkbook(fis);
			excelSheet = excelWorkbook.getSheet(sheetname);
			
			int Startrow = 0;
			int Startcol = 0;
			
			int totalRows = 1;
			int totalCols = 1;
			
			dataArray = new String[totalRows+1][totalCols+1];
			int k = 0,l=0;
			for(int i=Startrow;i<=totalRows;i++) {
				for(int j=Startcol;j<=totalCols;j++) {
					dataArray[i][j] = getCellData(i,j);
					System.out.println(dataArray[i][j]);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataArray;
		
	}
	
	public static String getCellData(int row, int col) {
		try {
		cell = excelSheet.getRow(row).getCell(col);
		String data = cell.getStringCellValue();		
		return data;}
		catch (Exception e) {
			return "";
		}
		
	}

	 
}
