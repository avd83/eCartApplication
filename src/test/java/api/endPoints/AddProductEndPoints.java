package api.endPoints;

import static io.restassured.RestAssured.given;
import java.io.File;
import api.testCase.LoginTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProductEndPoints extends LoginTest {
	
	LoginTest lt = new LoginTest();
	public static String accessToken;
	public static String deleteProductId;
	
	
	public String lr;
	public static Response addProduct()
	{
		
		accessToken = LoginTest.token;
		Response response = (Response) given().log().all()
				.headers("Authorization",accessToken).param("productName","Laptop").param("productAddedBy",userId)
				.param("productCategory", "fashion").param("productSubCategory","gadet").param("productPrice", "45768")
				.param("productDescription", "HP").param("productFor","Men")
				.multiPart("productImage",new File("F:\\15dec22_laptop\\REST Assured API\\laptop.png"))
		//.body(payload).
		.when().log().all().post(Routes.postAddProductUrl);
			
		System.out.println(response);
		
		return response;		
	}
/*
	public static Response deleteProduct()
	{
		String deleteProductId = LoginTest.productId;
		Response response = given().headers("Authorization",accessToken).pathParam("productId",deleteProductId).contentType(ContentType.JSON)
		.when().delete(Routes.deleteProductUrl);
			
		System.out.println(response);
		
		return response;		
	}

	*/
	
}
