package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitialization {

	public static void main(String[] args) throws InterruptedException {

		// create a property value for the chromedriver path
		//System.setProperty("webdriver.chrome.driver", "D:\\Training_Eclipse_Workspace\\chromedriver.exe");

		//Initialize webdriver manager
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		// launch URL
		 driver.get("https://the-internet.herokuapp.com/login");
		 driver.manage().window().maximize(); //maximize the current browser window

		/*driver.navigate().to("https://www.google.com");
		// print the webpage title
		System.out.println(driver.getTitle());

		driver.navigate().to("https://the-internet.herokuapp.com/");
		// print the webpage title
		System.out.println(driver.getTitle());

		driver.navigate().back();
		// print the webpage title
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		// print the webpage title
		
		*/

		 System.out.println(driver.getTitle());
		/* 
		 WebElement username_field =  driver.findElement(By.id("username"));
		 username_field.clear();
		 username_field.sendKeys("tomsmith");
		 */
		  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!")
		;
		 
		 driver.findElement(By.xpath("//button")).click();
		 
		 Thread.sleep(3000);  //static wait
		// terminate the chromebrowser and chromedriver
		driver.quit();

	}

}
