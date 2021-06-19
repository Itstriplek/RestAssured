package utils;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CommonRestMethods {
	
	 Response response;
	
	@Step("Getting API response")
	public Response getResponse(String url)
	{
		try
		{
			 return response = SerenityRest.given()
					.when()
					.get(url);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	public Response getResponseWithAuthSecurity(String url,String username,String password)
	{
		return response = SerenityRest.given()
				.auth().basic(username, password)
				.when()
				.get(url);
				
	}
	@Step("Getting API status code")
	public int validateStatusCode()
	{
		try
		{
			int status = response.getStatusCode();
			if(response.getStatusCode()==200 || response.getStatusCode() ==201 || response.getStatusCode() == 202)
			{
				return status;
			}
			else
			{
				System.out.println("Failed");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
		
	}

}
