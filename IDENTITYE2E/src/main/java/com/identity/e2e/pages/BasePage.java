package com.identity.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver){
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}
	
	protected void enterText(WebElement element,String text){
		element.clear();
		element.sendKeys(text);
	}
	
	protected void clickElement(WebElement element){
		element.click();
	}

	protected String getText(WebElement element){
		return element.getText();
	}
	

}
