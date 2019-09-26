package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.id("user_email");
	
	By password =By.id("user_password");
	
	By login =By.xpath("//input[@type='submit']");
	
	By loginlink = By.cssSelector("a[href*='sign_in']");
	
	public WebElement getemailId() {
		return driver.findElement(email);
	}
	
	public WebElement getpassword() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(login);
	}
	
	
	

}
