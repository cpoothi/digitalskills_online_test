$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("testfeatures/VehicleInformation.feature");
formatter.feature({
  "line": 2,
  "name": "Vehicle information",
  "description": "\nAs a user\nI should be able to search my vehicle by its registraion number\nSo that I can see what vehicle I am looking for",
  "id": "vehicle-information",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@VehicleInformation"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Verifying vehicle information",
  "description": "",
  "id": "vehicle-information;verifying-vehicle-information",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I am on DVLA page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I should be able to find each vehicle by its registration plate extracted from data file",
  "keyword": "Then "
});
formatter.match({
  "location": "VehicleInfomationSteps.i_am_on_DVLA_page()"
});
formatter.result({
  "duration": 10420733305,
  "status": "passed"
});
formatter.match({
  "location": "VehicleInfomationSteps.i_should_be_able_to_find_each_vehicle_by_its_registration_plate_extracted_from_data_file()"
});
formatter.result({
  "duration": 3411813317,
  "status": "passed"
});
formatter.after({
  "duration": 181752534,
  "status": "passed"
});
});