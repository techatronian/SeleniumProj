package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;
	public WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ------Objects-----------

	/*By SignUp_login_link = By.xpath("//a[normalize-space()='Signup / Login']");
	By UserName_label = By.xpath("//a[contains(normalize-space(),'Logged in as')]/b");
	By Product_link = By.xpath("//a[text()=' Products']");
*/
	
	//PageFactory
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement SignUp_login_link;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Logged in as')]/b" )
	private WebElement UserName_label;
	
	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement Product_link;
	
	@FindBy(xpath = "//div[contains(@class,'shop-menu')]//li//a")
	private List<WebElement> TopMenuLinks;
	
	// ------- --- Methods-----------
	// components

	public void NavigateTo_SignUp_Login() {
		SignUp_login_link.click();
	}

	public String getUserName() {
		String struserName="";
		
		try {
			 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.visibilityOf(UserName_label));
			 struserName = UserName_label.getText();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return struserName;
	}
	
	public void NavigateTo_Products() {
		Product_link.click();
	}
	
	public List<String> getTopMenuLinks(){
		
		String[] act = new String[TopMenuLinks.size()];
		
		for(int i = 0;i<TopMenuLinks.size();i++) {
			act[i] = TopMenuLinks.get(i).getText().replace("  ? ", "").replace("  ", "");
		}
		
		
		List<String> Actual = Arrays.asList(act);
		
		return Actual;
		
	}

}
