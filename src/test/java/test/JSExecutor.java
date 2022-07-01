package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutor {

	public static void main(String[] args) throws InterruptedException {
		// Initialize webdriver manager
				WebDriverManager.chromedriver().setup();
				// create instance for browser(instance store the sessionID)
				WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

				// launch URL
				driver.get("https://the-internet.herokuapp.com");
				driver.manage().window().maximize(); 
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

				JavascriptExecutor js  = (JavascriptExecutor) driver;
				String title = js.executeScript("return document.URL;").toString();
				
				System.out.println(driver.getTitle());
				
				System.out.println(title);
				
				Thread.sleep(3000);
				
				//js.executeScript("window.scrollTo(0,500)");
				WebElement statusCode = driver.findElement(By.xpath("//a[text()='Status Codes']"));
				js.executeScript("arguments[0].scrollIntoView(true);", statusCode);
				
				Thread.sleep(2000);
				
				driver.quit();
				

	}

}
