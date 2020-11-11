package step_definition;

import baseTest.BaseUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps extends BaseUtils{
	
	HomePage homePage= new HomePage();
	
	
	@Given("^Open home page$")
	public void openHomePage() {
		homePage.openHomePage();
    }
	
	@When("^Navigate to \"([^\"]*)\" category from left navigation$")
	public void navigateToCategory(String categoryName) {
		 homePage.navigateToCategory(categoryName);
		 
	}
	
	
	@Before
	public void beginScenario(Scenario scenario) {
		setUpDriver(scenario);
	}
	
	@After
	public void tearDownn(Scenario scenario) throws Exception {
		tearDown(scenario);
	}

}
