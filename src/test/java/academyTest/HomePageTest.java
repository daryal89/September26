package academyTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseTest;

public class HomePageTest extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Browser is opened");

		// driver.get(prop.getProperty("url"));
		// driver.get("http://qaclickacademy.com");
	}

	@Test(dataProvider = "getData")
	public void validateLogin(String username, String password, String text) throws IOException {
		// driver.get(prop.getProperty("url"));
		driver.get("http://qaclickacademy.com");
		log.info("Successfully navigagted to the website");

		// one is inheritance
		// creating object to that class and invoke method of it

		// Creating object of login page
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();

		// creating object of login page
		LoginPage lp = new LoginPage(driver);
		lp.getemailId().sendKeys(username);
		lp.getpassword().sendKeys(password);

		log.info(text);

		lp.submit().click();
		log.info("Successfully entered the values in the boxes and clicked to login button");

	}

	@DataProvider
	// Rows stands for how many different data types should run
	// column stands for how many values per each test
	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		data[0][0] = "nonrestircteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non-Restricted User";

		data[1][0] = "Restircteduser@qw.com";
		data[1][1] = "654321";
		data[1][2] = "Restricted User";

		data[2][0] = "universaluser@qw.com";
		data[2][1] = "987654";
		data[2][2] = "Universal User";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
