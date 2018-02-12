package com.identity.e2e.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.identity.e2e.propertyconfig.ReadProperties;

public class BrowserManager {

	public static WebDriver getBrowser() {
		String browser = ReadProperties.getValueFromProperties("browser");
		WebDriver driver = null;
		// String in switch case works in JDK 1.7 and later. Please make sure you use correct version while executing this 
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chander\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/Chander/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

}
