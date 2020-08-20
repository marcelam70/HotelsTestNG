package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.ThreeStarsHotelsPage;
import com.qa.hotels.util.Constants;

public class ThreeStarHotelTest {
	WebDriver driver;
	BasePage  basePage;
	Properties prop;
	HomePage homePage;
	ThreeStarsHotelsPage threeStarPage;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException{
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver= basePage.initialize_driver();
	driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);
	threeStarPage =  homePage.myDestination();
	threeStarPage = new ThreeStarsHotelsPage(driver);
	
	}
	@Test(priority=1)
	public void verifyTitleTest() {
		String title = threeStarPage.getHotelVerifyPageTitle();
		System.out.println("Hotel three star title is : " + title);
		Assert.assertEquals(title, Constants.THREESTARSHOTEL_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void verifyselectMyDestinationTest() throws InterruptedException {
		threeStarPage.MyHotel();
	}

	@Test(priority=3 , enabled=false)
	public void verifymyHiltonsTest() throws InterruptedException {
		threeStarPage.verifyHilton();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	}
	
	
