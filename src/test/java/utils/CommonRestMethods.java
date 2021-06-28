package utils;




import org.hamcrest.Matchers;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
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
	
	

	public void validateStatusCode(String statusResult)
	{
		softAssert = new SoftAssert();
		try
		{
			int status = response.getStatusCode();
			
			if(statusResult.equalsIgnoreCase("success")  )
			{
			     softAssert.assertEquals(status, 200, "Correct status code returned");
			}
			else
			{
				softAssert.assertEquals(status, 404, "Correct status code returned");
			}
			
						
			softAssert.assertAll();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	
//	public void responseTime()
//	{
//		ValidatableResponse responseTime = response.then();
//	
//		responseTime.time(Matchers.lessThan(2000L));
//		
//	}
	
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
