package com.qa.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.Constants;
import com.qa.hotels.util.ElementUtil;

public class HomePage extends BasePage{

	WebDriver driver;
    ElementUtil elementUtil;
    
    
    By cityName= By.id("qf-0q-destination");
    By checkIn = By.id("qf-0q-localised-check-in");
	By checkOut = By.xpath("//input[@id='qf-0q-localised-check-out']");
	
	By room = By.id("qf-0q-rooms");
	
	By adults = By.xpath("//select[@id='qf-0q-room-0-adults']");
	
	By children = By.xpath("//select[@id='qf-0q-room-0-children']");
	
	By ageChildren1 = By.id("qf-0q-room-0-child-0-age");
	
	By ageChildren2 = By.xpath("//select[@id='qf-0q-room-0-child-1-age']");
	
	By search = By.className("cta-strong");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	public String getPageTitle(){

	return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	
	}
	
	public  void selectMyLocation() throws InterruptedException{
		
		
		elementUtil.doSendKeys(cityName, "Boston, Massachusetts, United States of America");

		elementUtil.doSendKeys(checkIn,"09/10/20");
		//Thread.sleep(2000);
		elementUtil.doSendKeys(checkOut, "09/14/20");
	   // Thread.sleep(2000);
	    elementUtil.selectDropdownByVisibleText(driver, room, "1");
		//Thread.sleep(2000);
		elementUtil.selectDropdownByVisibleText(driver,adults,"2");
		//Thread.sleep(2000);
		elementUtil.selectDropdownByVisibleText(driver, children, "2");
		//Thread.sleep(2000);
		elementUtil.selectDropdownByVisibleText(driver, ageChildren1, "4");
		//Thread.sleep(2000);
		elementUtil.selectDropdownByVisibleText(driver, ageChildren2, "9");
		Thread.sleep(2000);
		WebElement element =driver.findElement(search);
		element.click();
					
	}
	public ThreeStarsHotelsPage myDestination() throws InterruptedException {
		selectMyLocation();
		return new ThreeStarsHotelsPage(driver);
	
		
		
	}
	
	
	
}
