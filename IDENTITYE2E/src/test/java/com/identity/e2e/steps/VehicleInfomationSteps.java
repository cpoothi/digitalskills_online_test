package com.identity.e2e.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.identity.e2e.pages.VehicleInformationFromDvlaPage;
import com.identity.e2e.scan.ScanFiles;
import com.identity.e2e.utils.VehicleDetails;
import com.identity.e2e.webdriver.BrowserManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class VehicleInfomationSteps{

	public ScanFiles fileScanner;
	public VehicleInformationFromDvlaPage vehicleInformationFromDvlaPage;
	public static WebDriver driver;
	
	@Autowired
	public VehicleInfomationSteps(ScanFiles fileScanner) {
		this.fileScanner=fileScanner;
		if (driver == null) {
			try {
				driver = BrowserManager.getBrowser();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		vehicleInformationFromDvlaPage= new VehicleInformationFromDvlaPage(driver);
	}

	@Given("^I am on DVLA page$")
	public void i_am_on_DVLA_page() throws Throwable {
		vehicleInformationFromDvlaPage.gotoHomePage();
		
	}
	
	@Then("^I should be able to find each vehicle by its registration plate extracted from data file$")
	public void i_should_be_able_to_find_each_vehicle_by_its_registration_plate_extracted_from_data_file() throws Throwable {
		vehicleInformationFromDvlaPage.clickButton();
		List<VehicleDetails> vehicleDetailsList=fileScanner.readVehiclesFromFile();
		for(int i=0;i<vehicleDetailsList.size();i++) {
			vehicleInformationFromDvlaPage.enterVRM(vehicleDetailsList.get(i).getRigistartionNumber());
			vehicleInformationFromDvlaPage.clickButton();
			assertEquals(vehicleDetailsList.get(i).getColor().toLowerCase(), vehicleInformationFromDvlaPage.getVehicleColor().toLowerCase());
			assertEquals(vehicleDetailsList.get(i).getMake().toLowerCase(), vehicleInformationFromDvlaPage.getVehicleMake().toLowerCase());
			vehicleInformationFromDvlaPage.clickNotoContinue();
			vehicleInformationFromDvlaPage.clickButton();
		}
	}

	@After
	public void embedScreenshot(Scenario scenario) {  
        	System.out.println(("Scenario Completed"));
        driver.close();
        driver=null;
    }
}
