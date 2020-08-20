package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.util.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage  basePage;
	Properties prop;
	HomePage homePage;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver= basePage.initialize_driver();
	driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);
	

	
}
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title = homePage.getPageTitle();
		System.out.println("Home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
}
    @Test(priority=2)
    public void verifyMySelection() throws InterruptedException{
  	 homePage.selectMyLocation();
    	 	
    	
    }

    @AfterTest
    public void tearDown(){
    	driver.quit();
    }
}  