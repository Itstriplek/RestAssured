package stepDefinition;


import baseTest.APITest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.TestBase;

public class Steps {
	
	
	
	APITest apitest = new APITest();
	TestBase testbase = new TestBase();
	
	@Given("^I have a API endpoint to fetch all customer details and get the response$")
    public void i_have_a_api_endpoint_to_fetch_all_customer_details_and_get_the_response() {
		apitest.setup();
    }

    @When("^I fetch the customer ID received and append it to the endpoint$")
    public void i_fetch_the_customer_id_received_and_append_it_to_the_endpoint() {
    	apitest.getAllCutomers();
    	
    }
    @Then("^I get the valid customer response$")
   public void i_get_the_valid_customer_response()  {

    	
    	apitest.specificCustomerDetails(apitest.ids,apitest.email,apitest.firstName,apitest.lastName);


    }
   @And("^I send incorrect customer ID I get error response$")
   public void i_send_incorrect_customer_id_i_get_error_response() {
	   apitest.incorrectCustomerDetails(apitest.ids);
	   
   }

}
