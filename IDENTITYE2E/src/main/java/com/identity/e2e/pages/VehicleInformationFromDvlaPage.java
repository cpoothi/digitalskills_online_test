package com.identity.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.identity.e2e.propertyconfig.ReadProperties;


public class VehicleInformationFromDvlaPage extends BasePage {

	private WebDriver driver;
	

	@FindBy(css=".button")
    private WebElement startButton;

	@FindBy(id="Vrm")
    private WebElement VRM;

	@FindBy(id="Correct_False")
    private WebElement NoOptionButton;

	@FindBy(css="li.list-summary-item:nth-child(3) > span:nth-child(2) > strong:nth-child(1)")
    private WebElement Color;

	@FindBy(css="li.list-summary-item:nth-child(2) > span:nth-child(2) > strong:nth-child(1)")
    private WebElement Make;

	public VehicleInformationFromDvlaPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}
	
	// GO TO BASEURL PATH
	public void gotoHomePage() {
		driver.get(ReadProperties.getBaseUrl());
	}

	// Click on START BUTTON
	public void clickButton() {
		clickElement(startButton);
	}
	
	// ENTERING VEHICLE REG NUMBER
	public void enterVRM(String vehicleText) {
		enterText(VRM, vehicleText);
	}
	
	// GET VEHICLE COLOR
	public String getVehicleColor() {
		return getText(Color);
	}

	// GET VEHICLE MAKE
	public String getVehicleMake() {
		return getText(Make);
	}

	// CLICK CONTNIUE BUTTON
	public void clickNotoContinue() {
		clickElement(NoOptionButton);
	}
}
