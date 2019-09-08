package com.nsw.coreframework;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.nsw.helper.LoggerHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsw.dataProvider.ConfigFileReader;

public class CoreActions {
	private static final Logger LOG = Logger.getLogger(CoreActions.class);
	private static WebDriver driver;
	private static JavascriptExecutor jse;// = (JavascriptExecutor)driver;
	private static WebDriverWait wait1;// = new WebDriverWait(driver,10);
	private static ConfigFileReader reader = null;

	public static void init(long timeout) {
		reader = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", reader.getValue("driverPath"));
		setWebdriver();
		jse = (JavascriptExecutor) driver;
		setWait(timeout);
		BasicConfigurator.configure();
	}

	public void click(By by) {
		findElem(by).click();
	}
	
	public static WebElement findElem(By by) {
		return driver.findElement(by);
	}

	public static void setWebdriver() {
		driver = new ChromeDriver();
	}

	public static void setWait(long timeout) {
		wait1 = new WebDriverWait(driver, timeout);
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static JavascriptExecutor getJse() {
		return jse;
	}

	public static WebDriverWait getWait() {
		return wait1;
	}
	public static ConfigFileReader getConfigReader() {
		return reader;
	}
	public static void quit() {
		driver.quit();
	}
}
