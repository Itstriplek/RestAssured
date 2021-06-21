package utils;



import org.assertj.core.api.SoftAssertions;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class CommonRestMethods  {
	
	 Response response;
	 SoftAssertions softAssertions;

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
				return status;
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
	
	public void assertionCheck(String e_id,String a_id,String e_email,String a_email,String e_firstname,String a_firstname,String e_lastname,String a_lastname )
	{
		
	    softAssertions = new SoftAssertions();
		
		softAssertions.assertThat(e_id.equals(a_id));
		softAssertions.assertThat(e_email.equals(a_email));
		softAssertions.assertThat(e_firstname.equals(a_firstname));
		softAssertions.assertThat(e_lastname.equals(a_lastname));
		
		softAssertions.assertAll();
		
		
		
//		assertEquals(e_email,a_email,"Email id do not match");
//		assertEquals(e_firstname,a_firstname,"first name does not match");
//		assertEquals(e_lastname,a_lastname,"first name does not match");
//		
	}

}
