package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationForm {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		
		//design the browser --- all browser setting functions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");

		// create instance for browser(instance store the sessionID)
		driver = new ChromeDriver(options); // Initiate the chromedriver.exe and create a chrome browser

		
		// launch URL
		driver.get("https://demoqa.com/automation-practice-form");
		//driver.manage().window().maximize(); // maximize the current browser window
		//implicit wait - sync
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		Edit_(driver.findElement(By.id("firstName")), "John");
		Edit_(driver.findElement(By.id("lastName")),"Raj");
		
		Edit_(	driver.findElement(By.id("userEmail")), "johnraj@gmail.com");
		CheckBox_Radio_("Male");
		Edit_(driver.findElement(By.id("userNumber")), "9999999990");
		
		Click_(driver.findElement(By.id("dateOfBirthInput")));
		Select_(driver.findElement(By.className("react-datepicker__year-select")), "1990");
		Select_(driver.findElement(By.className("react-datepicker__month-select")), "January");
		Click_(driver.findElement(By.xpath("//div[text()='15']")));
		
		//Actions classes -- autocompete field
		WebElement SubjectElem = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']"));
		Actions action = new Actions(driver);
		action.click(SubjectElem).sendKeys("arts").pause(1000).sendKeys(Keys.RETURN).build().perform();

		
		CheckBox_Radio_("Sports");
		CheckBox_Radio_("Music");
		
		//remove the ads
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('fixedban').remove();");
		
		
		//path of the file
		String filePath = "E:\\testFile\\testImg.bmp";		
		StringSelection fileText = new StringSelection(filePath);
		
		//copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileText, null);
		
		WebElement uploadPic =  driver.findElement(By.id("uploadPicture"));
		js.executeScript("arguments[0].scrollIntoView(true);", uploadPic);
		js.executeScript("arguments[0].click();",uploadPic);
		
		Thread.sleep(2000);
		//robot class
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
		
		Thread.sleep(2000);
		
		Edit_(driver.findElement(By.id("currentAddress")), "1234 stMaryroad \r\n california \r\n 987654");
		
			
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("state")));
		Click_(driver.findElement(By.id("state")));
		Click_(driver.findElement(By.xpath("//div[@id='state']//div[text()='NCR']")));
		Click_(driver.findElement(By.id("city")));
		Click_(driver.findElement(By.xpath("//div[@id='city']//div[text()='Delhi']")));
		
		Thread.sleep(3000);
		
		js.executeScript("document.getElementById('submit').click();");
		
		Thread.sleep(5000);
		
		//Print table values
		List<WebElement> columnData = driver.findElements(By.xpath("//table/thead/tr/th"));
		int colCount = columnData.size();
		
		List<WebElement> RowData = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowCount = RowData.size();
		System.out.println("The row count is "+rowCount+ " and the column count is "+colCount);
		
		System.out.println(GetColumnPosition(colCount,"Values"));
		System.out.println(GetColumnPosition(colCount,"Label"));
		
		for(int row=1;row<=rowCount;row++) {
			System.out.print(driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+ GetColumnPosition(colCount,"Label") +"]")).getText());
			System.out.print(" : ");
			System.out.print(driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+ GetColumnPosition(colCount,"Values") +"]")).getText());
			System.out.println("");
		}
		
		
		driver.quit();

	}
	
	public static int GetColumnPosition(int colCount,String colName) {
		int ValueColNum = 1;
		for(int col = 1;col<=colCount;col++) {
			if(driver.findElement(By.xpath("//table/thead/tr/th["+col+"]")).getText().equals(colName)){
				ValueColNum = col;
				break;
			}
		}
		return ValueColNum;
	}
	
	public static void CheckBox_Radio_(String inpVal) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement elem = driver.findElement(By.xpath("//label[text()='" +inpVal+ "']"));
			wait.until(ExpectedConditions.visibilityOf(elem));
			elem.click();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Edit_(WebElement elem, String value) {
		try {			
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(elem));
			elem.sendKeys(value);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Click_(WebElement elem) {
		try {		
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(elem));
			elem.click();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Select_(WebElement elem, String items) {
		try {	
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(elem));
			Select dd = new Select(elem);
			dd.selectByVisibleText(items);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
