package com.nsw.stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsw.coreframework.CoreActions;
import com.nsw.dataProvider.ConfigFileReader;
import com.nsw.helper.LoggerHelper;
import com.nsw.implementation.nswImplementation;
import com.nsw.pageObjects.NSWObject;



@RunWith(Cucumber.class)
public class NSWInfo extends nswImplementation {
	public NSWInfo() {
		CoreActions.init(10);}
		

	@Before
	public void setUp() {
		setUp1();
	  
	}

	@After
	public void tearDown(){
		CoreActions.quit();
		 
	}

	@Given("^I navigate to NSW website$")
	public void i_navigate_to_nsw_website() throws Throwable {
		nswSite();
	}

	@When("^I apply for number plate$")
	public void i_apply_for_number_plate() throws Throwable {
		desiredSearch();
	}

	// --------CLICK the FIRST LINK-------------
	@And("^I land at Apply for a number plate page correctly$")
	public void i_land_at_apply_for_a_number_plate_page_correctly() throws Throwable {
		
		rightPage();
	}

	// ------------Click Location-----------
	@When("^I enter the (.+)$")
	public void i_enter_the(String desiredsuburb) throws Throwable {
		suburbSearch(desiredsuburb);
	}

	@Then("^I find correct (.+)$")
	public void i_find_correct(String servicecentrename) throws Throwable {
		
		serviceCentreName(servicecentrename);
		
	}

}