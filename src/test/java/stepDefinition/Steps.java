package stepDefinition;


import baseTest.APITest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {
	
	
	
	APITest apitest = new APITest();
	
	@Given("^I have a GET API URI to fetch customer details$")
    public void I_have_a_GET_API_URI_to_fetch_customer_details() {
		apitest.setup();
    }
	
	@And("^I have fetched the list of valid customer IDs$")
    public void I_have_fetched_the_list_of_valid_customer_IDs() {
		apitest.idCapture();
    }

    @When("^I append the end point specific to fetching all the customer details$")
    public void I_append_the_end_point_specific_to_fetching_all_the_customer_details() {
    	apitest.getAllCutomers();
    	
    }
    
    @When("^I have collected both the complete and individual customer details$")
    public void I_have_collected_both_the_complete_and_individual_customer_details()  {
    	
    	apitest.getAllCutomers();
    	apitest.specificCustomerDetails(apitest.ids);
    	
    	
    }
   
    @Then("^I append the specific customer ID as the end point$")
   public void I_append_the_specific_customer_ID_as_the_end_point()  {

    	apitest.specificCustomerDetails(apitest.ids);

    }
    
    
    
    @Then("^I assert the values to check if the match or not$")
   public void I_assert_the_values_to_check_if_the_match_or_not()  {

    	
    	apitest.checkResponseMatch(apitest.ids,apitest.email,apitest.firstName,apitest.lastName);

    }
    
   @And("^I append the specific customer ID which is not valid as the end point")
   public void I_append_the_specific_customer_ID_which_is_not_valid_as_the_end_point() {
	   apitest.incorrectCustomerDetails(apitest.ids);
	   
   }
   
   @And("^I check the response time$")
   public void I_check_the_response_time() {
	   apitest.checkResponseTime();
	   
   }
   
   @And("^I check for the response status code$")
   public void I_check_for_the_response_status_code() {
	   apitest.checkStatusCode(apitest.status);
	   
   }
   

}
