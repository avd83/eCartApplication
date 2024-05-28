package api.endPoints;

import static io.restassured.RestAssured.given;

import api.payload.LoginPayload;
import api.testCase.LoginTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class LoginEndPoints extends LoginTest {
	
	public static Response login(LoginPayload payload)
	{
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(payload)
		.when().log().all().post(Routes.postloginUrl);
				
		return response;
		
	}
	
}
