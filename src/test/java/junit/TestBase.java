package junit;

import org.assertj.core.api.SoftAssertions;
import org.junit.BeforeClass;


import io.restassured.RestAssured;

public class TestBase {

	 public SoftAssertions softAssertions;
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "http://localhost:4547/Blog.Api";
	}

	
}
