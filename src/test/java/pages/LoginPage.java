package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//----objects----
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement EmailAddress_field;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement Password_field;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement Login_button;
	/*
	By EmailAddress_field = By.xpath("//input[@data-qa='login-email']");
	By Password_field = By.xpath("//input[@data-qa='login-password']");
	By Login_button = By.xpath("//button[@data-qa='login-button']");
*/
	//-------Methods
	//components
	public void enterEmailAddress(String emailAddress) {
		EmailAddress_field.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		Password_field.sendKeys(password);
	}
	
	public void click_Login() {
		Login_button.click();
	}
	
	//flow
	public void LoginInToYourAccount(String email, String password) {
		enterEmailAddress(email);
		enterPassword(password);
		click_Login();
	}
	
}
