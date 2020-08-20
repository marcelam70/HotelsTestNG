package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.FiveStarsHotelsPage;
import com.qa.hotels.pages.FourStarsHotelesPage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.ThreeStarsHotelsPage;

public class FiveStarHotelTest {
	WebDriver driver;
	BasePage  basePage;
	Properties prop;
	HomePage homePage;
	ThreeStarsHotelsPage threeStarPage;
	FourStarsHotelesPage fourStarsHotelsPage;
	FiveStarsHotelsPage fiveStarHotelPage;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException{
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver= basePage.initialize_driver();
	driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);
	threeStarPage =  homePage.myDestination();
	fourStarsHotelsPage = threeStarPage.switchPage();
	
	fiveStarHotelPage = fourStarsHotelsPage.switchPage();
	
	//fiveStarHotelPage = new FiveStarsHotelsPage (driver);
	
	
}
	@Test
	public void verifycityCenter5Test() throws InterruptedException {
		fiveStarHotelPage.fiveStarHotelList();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
