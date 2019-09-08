package com.nsw.pageObjects;

import org.openqa.selenium.By;
public class NSWObject {

	
public static By SearchPanel = By.cssSelector(".form__text.form--large");
public static By Option = By.className("autocomplete__option");

public static By NumberPlate = By.xpath("//a[contains(text(), 'Apply for a number plate')]");
public static By Location = By.xpath("//*[@href='/service-centre']");

public static By SuburbSpec = By.id("locatorTextSearch");

public static By Search =By.className("form__actions");
//public static By Search1 =By.cssSelector(".button.button--primary.button--xxlarge");
public static By ServiceCenterName =By.xpath("//a[contains(text(), 'Haymarket Service Centre')]");
//public static By ServiceCenter2 =By.xpath("//a[contains(text(), 'Rockdale Service Centre')]");
}
