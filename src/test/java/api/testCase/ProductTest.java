package api.testCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endPoints.AddProductEndPoints;
import api.payload.ProductPayload;
import io.restassured.response.Response;

public class ProductTest  {
	
	AddProductEndPoints a = new AddProductEndPoints();
	ProductPayload productPayload = new ProductPayload();
	
	
	@BeforeClass
	public void setUpData()
	{		
		productPayload.setProductName("Wristwatch");
		productPayload.setProductAddedBy("abhay");
		productPayload.setProductCategory("fashon");
		productPayload.setProductSubCategory("watch");
		productPayload.setProductPrice("2500");
		productPayload.setProductDescription("addidas");
		productPayload.setProductFor("Men");
		productPayload.setImage("png");
	}
	
	@Test(priority=1)
	public void productTest()
	{		
		Response response = AddProductEndPoints.addProduct();		
		response.then().log().all().assertThat().statusCode(200).extract().response().getBody().toString();
	
			System.out.println(response);
				
		
	}
	
	

}
