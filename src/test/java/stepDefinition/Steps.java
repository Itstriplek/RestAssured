package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import baseTest.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.APITest;

public class Steps {
	public static List<Integer> id = new ArrayList<Integer>();
	List<String> email = new ArrayList<String>();
	List<String> firstname = new ArrayList<String>();
	List<String> lastname = new ArrayList<String>();
	
	APITest apitest = new APITest();
	TestBase testbase = new TestBase();
	
	@Given("^I have a API endpoint to fetch all customer details and get the response$")
    public void i_have_a_api_endpoint_to_fetch_all_customer_details_and_get_the_response() throws Throwable {
        testbase.init();
    }

    @When("^I fetch the customer ID received and append it to the endpoint$")
    public void i_fetch_the_customer_id_received_and_append_it_to_the_endpoint() throws Throwable {
    	apitest.getAllCutomers();
    	
    }
    @Then("^I get the valid customer response$")
   public void i_get_the_valid_customer_response() throws Throwable {
   	apitest.specificCustomerDetails(id,email,firstname,lastname);

    }
   @And("^I send incorrect customer ID I get error response$")
   public void i_send_incorrect_customer_id_i_get_error_response() throws Throwable {
        apitest.incorrectCustomerDetails(id);
   }

}
