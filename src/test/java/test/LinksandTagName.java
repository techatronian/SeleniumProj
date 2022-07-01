package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksandTagName {

	public static void main(String[] args) throws InterruptedException {
		// create a property value for the chromedriver path
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Training_Eclipse_Workspace\\chromedriver.exe");

		// Initialize webdriver manager
		WebDriverManager.chromedriver().setup();
		// create instance for browser(instance store the sessionID)
		WebDriver driver = new ChromeDriver(); // Initiate the chromedriver.exe and create a chrome browser

		// launch URL
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); // maximize the current browser window

		// driver.findElement(By.partialLinkText("Selenium")).click();
		Thread.sleep(3000);

		String HeaderText = driver.findElement(By.tagName("h1")).getText();
		System.out.println(HeaderText);

		
		//find elements
		List<WebElement> getLinks =  driver.findElements(By.tagName("a"));
		System.out.println(getLinks.size());
		
		for(WebElement uniqueLink :getLinks) {
			String Text = uniqueLink.getText();
			System.out.println(Text);
		}
		
		System.out.println(driver.getTitle());

		driver.quit();

	}

}
