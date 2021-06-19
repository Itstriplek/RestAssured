package junit;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import baseTest.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import utils.CommonRestMethods;

@RunWith(SerenityRunner.class)
public class APITest extends TestBase {
	@Steps
	static
	CommonRestMethods restCommonMethods = new CommonRestMethods();
	
	
	@Title("This test will fetch the list of all customers")
	@Test
	public void getAllCutomers()
	{
		Response response = restCommonMethods.getResponse("/Customers");
		
		
		restCommonMethods.validateStatusCode();
		
		List<Integer> ids = response.jsonPath().getList("data.id");
		List<String> email = response.jsonPath().getList("data.email");
		List<String> firstName = response.jsonPath().getList("data.first_name");
		List<String> lastName = response.jsonPath().getList("data.last_name");
		
		System.out.println(response.asString());
		System.out.println("-----------------------");
		
		specificCustomerDetails(ids,email,firstName,lastName); 
		incorrectCustomerDetails(ids);
	}
	
	@Title("This test will fetch the details of specific customer")
	public static void specificCustomerDetails(List<Integer> id,List<String> email,List<String> firstname,List<String> lastname)
	{
		
		for(int i=0;i<id.size();i++)
		{
		
			Response response = restCommonMethods.getResponse(id.get(i)+"/CustomerView");
			restCommonMethods.validateStatusCode();
	
			
			String customerID = (response.jsonPath().getString("data.customerID"));
			String Email = response.jsonPath().getString("data.email");
			String firstName = response.jsonPath().getString("data.first_name");
			String lastName = response.jsonPath().getString("data.last_name");
		
			restCommonMethods.assertionCheck((id.get(i)).toString(),customerID,email.get(i),Email,firstname.get(i),firstName,lastname.get(i),lastName);
		
			
			System.out.println(response.asString());
			System.out.println("-----------------------");
		}
	}
	
	
	public static void incorrectCustomerDetails(List<Integer> id)
	{
		for(int i=0;i<id.size();i++)
		{
			Response response = restCommonMethods.getResponse((id.get(i)+1)+"/CustomerView");
			restCommonMethods.validateStatusCode();
			
			System.out.println(response.asString());
			System.out.println("-----------------------");
		}
	}
	
}