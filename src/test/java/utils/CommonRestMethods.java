package utils;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.SoftAssertions;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class CommonRestMethods  {
	
	 Response response;
	 SoftAssert softAssert;

	public Response getResponse(String endpoint)
	{
		try
		{
			 return response = SerenityRest.given()
					.when()
					.get(endpoint);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	public Response getResponseWithAuthSecurity(String url,String username,String password)
	{
		try
		{
		return response = SerenityRest.given()
				.auth().basic(username, password)
				.when()
				.get(url);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	

	public int validateStatusCode()
	{
		try
		{
			int status = response.getStatusCode();
	
			if(response.getStatusCode()==200 || response.getStatusCode() ==201 || response.getStatusCode() == 202)
			{
				System.out.println("The received status code is  "+ status);
			}
			else
			{
				System.out.println("Failed, the status code received is "+ status);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
		
	}
	
	public void responseTime()
	{
		long time = response.getTime();
		if(time>0 && time<1000) {
			
			System.out.println("The reponse time for this API is :  "+ time+" milli seconds");
		
		}
		else
		{
			System.out.println("API is taking a lot of time and the value is :  "+ time+" milli seconds");
		}
		
	}
	
	public void assertionCheck(String e_id,String a_id,String e_email,String a_email,String e_firstname,String a_firstname,String e_lastname,String a_lastname )
	{
		
		softAssert = new SoftAssert();
		
		softAssert.assertEquals(e_id, a_id, "ID soft assert failed");
		softAssert.assertEquals(e_firstname, a_firstname, "First name soft assert failed");
		softAssert.assertEquals(e_lastname, a_lastname, "Last name soft assert failed");
		softAssert.assertEquals(e_email, a_email, "Email ID soft assert failed");
		
		
		softAssert.assertAll();
		
	}

}
