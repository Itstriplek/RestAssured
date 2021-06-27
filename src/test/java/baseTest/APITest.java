package baseTest;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.TestBase;
import utils.CommonRestMethods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SerenityRunner.class)
public class APITest extends TestBase {
	
	
	static CommonRestMethods restCommonMethods = new CommonRestMethods();
	
	public  List<Integer> ids = new ArrayList<Integer>();
	public  List<String> email = new ArrayList<String>();
	public  List<String> firstName = new ArrayList<String>();
	public  List<String> lastName = new ArrayList<String>();


	public void setup()
	{
		RestAssured.baseURI = "http://localhost:4547/Blog.Api";
	}
	
	
	public void getAllCutomers()
	{
		Response response = restCommonMethods.getResponse("/Customers");
		
		 		
		ids = response.jsonPath().getList("data.id");
		email = response.jsonPath().getList("data.email");
		firstName = response.jsonPath().getList("data.first_name");
		lastName = response.jsonPath().getList("data.last_name");
		
		System.out.println("API response is as follows : ");
		System.out.println(response.asString());
	}
	
	
	public void checkStatusCode()
	{
		restCommonMethods.validateStatusCode();
	}
	
	
	public void idCapture()
	{
		Response response = restCommonMethods.getResponse("/Customers");
		ids = response.jsonPath().getList("data.id");
		
	}
	
	public  void specificCustomerDetails(List<Integer> id)
	{
		
		
		 
			for(int i=0;i<id.size();i++)
			{
	
				Response response = restCommonMethods.getResponse(id.get(i)+"/CustomerView");
				
				System.out.println("API response is as follows : ");
				System.out.println(response.asString());
	
			}

		
	}
	
	public void checkResponseMatch(List<Integer> id,List<String> email,List<String> firstname,List<String> lastname)
	{
		
		
		
		for(int i=0;i<id.size();i++)
		{
		
			Response response = restCommonMethods.getResponse(id.get(i)+"/CustomerView");
			
	
			
			String customerID = (response.jsonPath().getString("data.customerID"));
			String Email = response.jsonPath().getString("data.email");
			String firstName = response.jsonPath().getString("data.first_name");
			String lastName = response.jsonPath().getString("data.last_name");
		
			
			restCommonMethods.assertionCheck((id.get(i)).toString(),customerID,email.get(i),Email,firstname.get(i),firstName,lastname.get(i),lastName);
		
		}
	}
	
	
	public void checkResponseTime()
	{
		restCommonMethods.responseTime();
		
	}
	
	public void incorrectCustomerDetails(List<Integer> id)
	{
		for(int i=0;i<id.size();i++)
		{
			Response response = restCommonMethods.getResponse((id.get(i)+1)+"/CustomerView");
			
			System.out.println("API response is as follows : ");
			System.out.println(response.asString());

		}
	}
	
//	public void responseOutput(Response response)
//	{
//		System.out.println("API response is as follows : ");
//		System.out.println(response.asString());
//		
//	}
}