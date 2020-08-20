package com.qa.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class FiveStarsHotelsPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;

	By submit = By.id("f-label-star-rating-5");
	By distance = By.xpath("//a[text()='Distance']");
	By landmark = By.xpath("//a[contains(text(),'City center')]");
	By listOfHotels = By.xpath("//a[@class='property-name-link']");
	By tenMiles = By.xpath("//ul[@class='property-landmarks']");

	public FiveStarsHotelsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHotel5starsPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public void fiveStarHotelList() {

		elementUtil.waitforElementPresent(submit);
		elementUtil.doClick(submit);
		elementUtil.waitforElementPresent(distance);
		elementUtil.doClick(distance);
		elementUtil.waitforElementPresent(landmark);
		elementUtil.doClick(landmark);

		List<WebElement> hotelList = driver.findElements(listOfHotels);
		List<WebElement> miles = driver.findElements(tenMiles);
		for (int i = 0; i < hotelList.size(); i++) {

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)", "");

			String text = miles.get(i).getText();
			String hotelMiles = text.substring(0, 3);
			double radius = Double.parseDouble(hotelMiles);

			if (radius < 10) {
	System.out.println("5 start hotel is " + hotelList.get(i).getText() + " " + radius);
			}
		}

	}
}





