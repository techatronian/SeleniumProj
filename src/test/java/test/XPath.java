package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		// launch URL
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); // maximize the current browser window
		
		String linkText = "Checkboxes";
		
		driver.findElement(By.xpath("//a[text()='" +linkText+ "']")).click();
		
		String pageHeader = driver.findElement(By.xpath("//h3")).getText();
		
		System.out.println(pageHeader);
		
		driver.quit();

	}

}
	