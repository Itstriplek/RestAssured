package baseTest;



import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import io.restassured.response.Response;
import junit.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import utils.CommonRestMethods;

//@RunWith(SerenityRunner.class)
public class APITest extends TestBase {
	
	
	static CommonRestMethods restCommonMethods = new CommonRestMethods();
	
	public static List<Integer> ids = new ArrayList<Integer>();
	public static List<String> email = new ArrayList<String>();
	public static List<String> firstName = new ArrayList<String>();
	public static List<String> lastName = new ArrayList<String>();
	

	public void getAllCutomers()
	{
		Response response = restCommonMethods.getResponse("/Customers");
		
		
		restCommonMethods.validateStatusCode();
		
		ids = response.jsonPath().getList("data.id");
		email = response.jsonPath().getList("data.email");
		firstName = response.jsonPath().getList("data.first_name");
		lastName = response.jsonPath().getList("data.last_name");
		
//		System.out.println(response.asString());
//		System.out.println("-----------------------");
		
	}
	
	
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
		
			
//			System.out.println(response.asString());
//			System.out.println("-----------------------");
		}
	}
	
	
	public static void incorrectCustomerDetails(List<Integer> id)
	{
		for(int i=0;i<id.size();i++)
		{
			Response response = restCommonMethods.getResponse((id.get(i)+1)+"/CustomerView");
			restCommonMethods.validateStatusCode();
			
//			System.out.println(response.asString());
//			System.out.println("-----------------------");
		}
	}
	
}