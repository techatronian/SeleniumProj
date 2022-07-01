package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		// Initialize webdriver manager
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		// launch URL
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Enabled']"))).
			   pause(2000).
			   moveToElement(driver.findElement(By.xpath("//a[text()='Downloads']"))).
			   pause(2000).
			   moveToElement(driver.findElement(By.xpath("//a[text()='CSV']"))).
			   click(driver.findElement(By.xpath("//a[text()='CSV']"))).
			   build().perform();
		
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
