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

public class ValidateNavigationBar extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");

		// driver.get(prop.getProperty("url"));
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to the webpage");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	@Test
	public void validateAppNavigationBar() throws IOException {

		LandingPage l = new LandingPage(driver);
		boolean b = l.getNavigationBar().isDisplayed();

		System.out.println(b);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bar isdisplayed");
	}

}
