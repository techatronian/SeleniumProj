package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise {
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		// launch URL
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize(); // maximize the current browser window
		
		String Username = driver.findElement(By.xpath("(//section[@id='login']//b)[1]")).getText();
		String Password = driver.findElement(By.xpath("(//section[@id='login']//b)[2]")).getText();
		
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(3000);
		
		String actResult = driver.findElement(By.tagName("h1")).getText();
		String expResult = "Logged In Successfully";
		
		System.out.println(actResult);
		System.out.println(expResult);
		
		if(actResult.equals(expResult)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		driver.findElement(By.linkText("Log out")).click();
		
		driver.quit();
		
		
		;
	}

}
