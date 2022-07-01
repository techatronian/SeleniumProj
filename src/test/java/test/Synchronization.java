package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		//Implicit wait
		/*
		// launch URL
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().window().maximize(); // maximize the current browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//button")).click();
				
		String getHelloworld = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		
		System.out.println(getHelloworld);
		
		driver.quit();
		*/
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize(); // maximize the current browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//button")).click();
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']/h4"))));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='finish']/h4")), "Hello World!"));
		wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/dynamic_loading/2"));
		
		String getHelloworld = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		
		System.out.println(getHelloworld);
		
		driver.quit();
		

	}

}
