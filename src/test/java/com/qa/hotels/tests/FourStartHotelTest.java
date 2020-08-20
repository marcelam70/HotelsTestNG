package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.FourStarsHotelesPage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.ThreeStarsHotelsPage;
import com.qa.hotels.util.ElementUtil;

public class FourStartHotelTest {
	WebDriver driver;
     BasePage basePage;
     Properties prop;
     HomePage homePage;
     ElementUtil elemenUtil;
     ThreeStarsHotelsPage threeStarsHotelsPage;
     FourStarsHotelesPage fourStarsHotelsPage;
     
     @BeforeTest
     public void setUp() throws InterruptedException {
    	    basePage = new BasePage();
    		prop = basePage.initialize_properties();
    		driver= basePage.initialize_driver();
    		driver.get(prop.getProperty("url"));
    		homePage = new HomePage(driver);
    		threeStarsHotelsPage =  homePage.myDestination();
    		threeStarsHotelsPage  = new ThreeStarsHotelsPage(driver);
    		fourStarsHotelsPage = threeStarsHotelsPage.switchPage();
    		
    		
    		
   
    		
     }
     @Test(enabled=true)
     public void verifyfourStarCityCenterTest() throws InterruptedException {
    	 fourStarsHotelsPage.select4StarHotel();
    	
     }
     @AfterTest
     public void tearDown() {
    	 driver.quit();
     }
}
