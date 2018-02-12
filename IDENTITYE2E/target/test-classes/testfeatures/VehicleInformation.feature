@VehicleInformation
Feature: Vehicle information

	As a user
	I should be able to search my vehicle by its registraion number
	So that I can see what vehicle I am looking for
	 
  Scenario: Verifying vehicle information
    Given I am on DVLA page
    Then I should be able to find each vehicle by its registration plate extracted from data file