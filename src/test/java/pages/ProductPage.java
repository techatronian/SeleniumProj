package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='features_items']/div[contains(@class,'col')]")
	private List<WebElement> ListofProducts_label;
	
	//By ListofProducts_label = By.xpath("//div[@class='features_items']/div[contains(@class,'col')]");
	
	
	public int getProductCount() {
		//List<WebElement> products = driver.findElements(ListofProducts_label);
		return ListofProducts_label.size();
	}

}
