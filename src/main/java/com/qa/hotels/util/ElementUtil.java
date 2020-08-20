package com.qa.hotels.util;



import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.hotels.base.BasePage;


public class ElementUtil  extends BasePage{
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	Properties prop;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		//wait = new WebDriverWait(driver, Constants.DEFAULT_TIMEOUT);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	public String doGetPageTitle() {
		
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;
	}
public void doSendKeys(By locator, String value) {
		
		try {
			WebElement element = getElement(driver, locator);
			element.clear();
			element.sendKeys(value);
			
		} catch (Exception e) {
			System.out.println("some exception got occured while entering values in a field");
		}
	}
	
	/**
	 * This method is used to handle alert
	 * @param driver
	 * @return
	 */
	public static String getAlertText(WebDriver driver){
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		return text;
}
	public WebElement waitForPresenceOfElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		WebElement element = driver.findElement(locator);
		return element;
	}
	/**
	 * 
	 * @param driver
	 * @param path
	 * @throws IOException
	 */
	public static void takeScreenshot(WebDriver driver, String path) throws IOException{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
		
		
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropdownByVisibleText(WebDriver driver,By locator,String value){
		WebElement element=getElement(driver, locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	/**
	 * This method use to send characters a textbox
	 * @param driver
	 * @param locator
	 * @param keys
	 */
	public void sendKeys(WebDriver driver, By locator, CharSequence... keys){ }
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static String getPageTitle(WebDriver driver){
		return driver.getTitle();
	}
	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public static void launchURL(WebDriver driver,String url){
		driver.get(url);
	}
	public static WebDriver launchBrowser(WebDriver driver,String browserName){
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/marcelavinueza/Documents/Drivers/chromedriver");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/marcelavinueza/Documents/Drivers/geckodriver");
			driver = new FirefoxDriver();	
		}else{
			System.out.println("Browser is not available:" + browserName);
			
		}
		return driver;
	}
	/**
	 * 
	 * @param driver
	 * @param locator
	 */
public void doClick(By locator) {
		
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element");
		}
	}
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement getElement(WebDriver driver,By locator){
		WebElement element = driver.findElement(locator);
		return element;
	}
	/**
	 * 
	 * @param driver
	 */
	public static void closeBrowser(WebDriver driver){
		driver.close();
	}
	public static void quitBrowser(WebDriver driver){
		driver.quit();
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement  getText(WebDriver driver) {
		WebElement element = driver.findElement((By) driver);
		return null;
		
		
	}
	/**
	 * 
	 * @param homePageTitle
	 * @return
	 */
	public String getPageTitle(String homePageTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param title
	 * @return
	 */
	public String waitForGetPageTitle(String title){
		   try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.titleContains(title));
			 } catch (Exception e) {
 System.out.println("some exception occurred while getting title ");			
			}  
return driver.getTitle();
		 }
	public void mouseOverclick(By destination, WebElement city) {
	
		
	}
	public void moveToElement(By distance) {
		
		
	}
	public void waitforElementPresent(By hilton) {
		
		
	}
	public void waitforElementVisible(By checkBox3) {
		
		
	}
	public void moveToElement(By distance, By cityCenter) {
		
		
	}
	
}

