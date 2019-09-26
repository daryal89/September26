package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	// constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By loginlink = By.cssSelector("a[href*='sign_in']");

	By title = By.cssSelector(".text-center>h2");

	///By navigationbar = By.cssSelector("nav.navbar-collapse.collapse");
	By navigationbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	
	public WebElement getLogin() {
		return driver.findElement(loginlink);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navigationbar);
	}
}
