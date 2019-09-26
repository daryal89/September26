package academyTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.BaseTest;

public class ValidateTitleTest extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@Test
	public void validateAppTitle() throws IOException {

		// Creating Object to the class and invoke the method if it
		LandingPage l = new LandingPage(driver);

		// Compare the text from the browser with actual text
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		System.out.println(l.getTitle().getText());
		log.info("Successfully validated Text message");
	}

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		// driver.get(prop.getProperty("url"));
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to Homepage");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
