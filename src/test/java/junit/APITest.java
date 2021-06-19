package junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import baseTest.TestBase;
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
		System.out.println(ids);
		specificCustomerDetails(ids); 
		incorrectCustomerDetails(ids);
			}
	@Title("This test will fetch the details of specific customer")
	public static void specificCustomerDetails(List<Integer> id)
	{
		for(int i=0;i<id.size();i++)
		{
		Response response = restCommonMethods.getResponse(id.get(i)+"/CustomerView");
		restCommonMethods.validateStatusCode();
		
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