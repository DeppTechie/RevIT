package com.nsw.implementation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nsw.helper.LoggerHelper;
import com.nsw.coreframework.CoreActions;
import com.nsw.pageObjects.NSWObject;

public class nswImplementation extends NSWObject {

	public static final Logger LOG = Logger.getLogger(nswImplementation.class);

	public void setUp1() {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/NSW/resources/chromedriver");
		CoreActions.getWebDriver().manage().window().maximize();
		CoreActions.getWebDriver().manage().deleteAllCookies();
	}

	public void nswSite() {
		CoreActions.getWebDriver().get(CoreActions.getConfigReader().getValue("url"));
		
		String expectedWindow = "Home | Service NSW";
		String actualWindow = CoreActions.getWebDriver().getTitle();
		{
			try {

				Assert.assertEquals(expectedWindow, actualWindow);
				LOG.debug("WEBSITE CORRECTNESS VALIDATED -- USER IS IN CORRECT WEBSITE");

			} catch (AssertionError e) {
				LOG.info("WINDOW CORRECTNESS VALIDATED -- USER IS NOT IN CORRECT WEBSITE");

			}
		}
		
		
		System.out.println("---NSW Services Website Is Launched Sucessfully---");
		CoreActions.getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(CoreActions.getWebDriver().getTitle());
	}

	public void desiredSearch() {
		CoreActions.findElem(SearchPanel).click();
		CoreActions.findElem(SearchPanel).sendKeys("apply for a number plate");
		CoreActions.findElem(SearchPanel).sendKeys(Keys.TAB);
		CoreActions.findElem(SearchPanel).sendKeys(Keys.ENTER);
	}

	public void rightPage() {

		WebElement w = CoreActions.findElem(NumberPlate);
		WebElement element = CoreActions.getWait().until(ExpectedConditions.elementToBeClickable(w));
		element.click();

		String expectedTitle = "Apply for a number plate | Service NSW";
		String actualTitle = CoreActions.getWebDriver().getTitle();

		{
			try {

				Assert.assertEquals(actualTitle, expectedTitle);
				LOG.debug("ASSERTION VALIDATED --USER IS ON THE RIGHT PAGE");

			} catch (AssertionError e) {
				LOG.info("ASSERTION VALIDATED --USER IS ON INCORRECT PAGE");

			}
		}

	}

	public void suburbSearch(String desiredsuburb) {
		CoreActions.findElem(Location).click();
		// ------------ Suburb Search----------------
		CoreActions.findElem(SuburbSpec).click();
		CoreActions.findElem(SuburbSpec).sendKeys(desiredsuburb);
		CoreActions.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CoreActions.findElem(SuburbSpec).sendKeys(Keys.TAB);
		CoreActions.findElem(SuburbSpec).sendKeys(Keys.ENTER);
		CoreActions.getJse().executeScript("window.scrollBy(0,750)");
	}
	
	public void serviceCentreName(String servicecentrename) {
		
		CoreActions.getJse().executeScript("window.scrollBy(0,300)");
		
		System.out.println("THE DESIRED SERVICE CENTRE IS --"+(CoreActions.findElem(By.xpath("//a[contains(text(), '"+servicecentrename+"')]")).getText()));
				
	}
	
}
