package utils;


import org.testng.Assert;
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
	
	

	public void validateStatusCode(int statusResult)
	{
			
		int actStatus = response.getStatusCode();
		Assert.assertEquals(statusResult, actStatus, "ID soft assert failed");
			
	}
	
	public void responseTime()
	{
		long time = response.getTime();
		Assert.assertTrue(time<2000, "Response time of API is good ");
		
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
