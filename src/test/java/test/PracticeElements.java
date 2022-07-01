package test;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeElements {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		// launch URL
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize(); // maximize the current browser window
		/*
		//Select Radiobutton
		SelectRadiobutton("bmw");		
		SelectRadiobutton("benz");	
		SelectRadiobutton("honda");	
		
		//Select Checkbox
		SelectCheckbox("bmw");
		SelectCheckbox("benz");
		SelectCheckbox("honda");
		
		//Uncheck boxes
		SelectCheckbox("bmw");
		SelectCheckbox("benz");
		SelectCheckbox("honda");

		//select dropdown
		WebElement dropdown = driver.findElement(By.id("carselect"));
		Select cars_dd = new Select(dropdown);
		cars_dd.selectByValue("benz");
		Thread.sleep(1000);
		cars_dd.selectByVisibleText("Honda");
		Thread.sleep(1000);
		cars_dd.selectByIndex(0);
		
		//multisewlect
		WebElement multiselect = driver.findElement(By.id("multiple-select-example"));
		Select fruits_multi = new Select(multiselect);
		fruits_multi.selectByValue("orange");
		Thread.sleep(1000);
		fruits_multi.selectByVisibleText("Peach");
		Thread.sleep(1000);
		fruits_multi.selectByIndex(0);
		
		//deselct
		fruits_multi.deselectAll();
		

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window title "+ driver.getTitle() + " and the window handle is "+parentWindowHandle);
		
		driver.findElement(By.id("openwindow")).click();
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(1000);
		
		Set<String> getAllWindows = driver.getWindowHandles();
		for(String getWindow:getAllWindows) {
			driver.switchTo().window(getWindow);
			System.out.println("The windows in loop is "+driver.getTitle() + " and the window handle is "+getWindow);
		}
		
		System.out.println("The child window title "+ driver.getTitle());
		
		driver.switchTo().window(parentWindowHandle);
		
		System.out.println("The current focused window is "+ driver.getTitle());
*/
		//simple alert
		 driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		 Alert alertWin = driver.switchTo().alert();
		 alertWin.accept();
		 
		 driver.findElement(By.name("enter-name")).sendKeys("Test automation expert");
		 driver.findElement(By.id("confirmbtn")).click();
		 Thread.sleep(2000);
		 Alert alertConfirmWin = driver.switchTo().alert();
		 System.out.println(alertConfirmWin.getText());
		 alertConfirmWin.dismiss();
		 
		
		Thread.sleep(2000);
		driver.quit();

	}
	
	public static void SelectRadiobutton(String text) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='" + text + "' and @type='radio']")).click();
	}
	
	public static void SelectCheckbox(String text) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='" + text + "' and @type='checkbox']")).click();
	}

}
