package com.qa.hotels.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author marcelavinueza
 *
 */
public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	/**
	 * 
	 * @return
	 */
	public WebDriver initialize_driver(){
		String browser = "chrome";
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.hotels.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}
	/**
	 * 
	 * @return
	 */
	public Properties initialize_properties(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("/Users/marcelavinueza/Documents/workspace/Hotelscom_Marcela/"
					+ "/src/main/java/com/qa/hotels/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
