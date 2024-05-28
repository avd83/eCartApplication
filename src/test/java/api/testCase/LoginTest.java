package api.testCase;

import static io.restassured.RestAssured.given;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endPoints.AddProductEndPoints;
import api.endPoints.LoginEndPoints;
import api.endPoints.OrderEndPoints;
import api.endPoints.Routes;
import api.payload.LoginPayload;
import api.payload.LoginResponse;
import api.payload.OrderRequest;
import api.payload.OrderResponse;
import api.payload.Orders;
import api.payload.ProductPayload;
import api.payload.ProductResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginTest 
{	
	//Faker faker = new Faker();
	
		LoginPayload loginPayload = new LoginPayload();
		LoginResponse loginResponse = new LoginResponse();
		ProductPayload productPayload = new ProductPayload();
		ProductResponse productResponse = new ProductResponse();
		OrderRequest orderPayload = new OrderRequest();
		OrderResponse order = new OrderResponse();
		
		public static String token;
		public static String productId;
		public static String userId;
		public static Orders orders;
		public static List<String> orderNo;
		
		@BeforeClass
		public void setUpData()
		{		
			//loginPayload.setUserEmail(faker.internet().safeEmailAddress());
			//loginPayload.setUserPassword(faker.internet().password());
			loginPayload.setUserEmail("avd@gmail.com");
			loginPayload.setUserPassword("Abc@1234");
			//orderPayload.setCountry("india");
			//orderPayload.setProductOrderedId(productId);
			
			productPayload.setProductName("Wristwatch");
			productPayload.setProductAddedBy("abhay");
			productPayload.setProductCategory("fashon");
			productPayload.setProductSubCategory("watch");
			productPayload.setProductPrice("2500");
			productPayload.setProductDescription("addidas");
			productPayload.setProductFor("Men");
			productPayload.setImage("png.txt");
		}	
		@Test(priority=1)
		public void loginTest()
		{
			LoginResponse response = LoginEndPoints.login(loginPayload)		
			.then().log().all().assertThat().statusCode(200).extract().response().getBody().as(LoginResponse.class);
			System.out.println(response);
			userId = response.getUserId();
			System.out.println(userId);
		    token = response.getToken();  
		    System.out.println(token);
		}	
		@Test(priority=2)
		public void addProductTest()
		{		
			ProductResponse response = AddProductEndPoints.addProduct()	
			.then().log().all().assertThat().statusCode(201).extract().response().getBody().as(ProductResponse.class);
			productId = response.productId;
				
			System.out.println(response);				
		}	
		@Test(priority=3)
		public void createOrderTest()
		{			
			OrderResponse response = (OrderResponse) OrderEndPoints.createOrder(order)	
			.then().log().all().assertThat().statusCode(201).extract().response().as(OrderResponse.class);
			
			orderNo = response.getOrders();
			System.out.println(response);		
			
		}	
		@Test(priority=4)
		public void viewOrderTest()
		{
			Response response =  OrderEndPoints.viewOrder(order)	
			.then().log().all().assertThat().statusCode(201).extract().response();
			
			System.out.println(response);				
		}	
		/*
		@Test(priority=5)
		public void deleteOrderTest()
		{
			Response response =  OrderEndPoints.deleteOrder()	
			.then().log().all().assertThat().statusCode(200).extract().response();
		
			System.out.println(response);
			
		}			
		@Test(priority=6)
		public void deleteProductTest()
		{
			ProductResponse response = (ProductResponse) AddProductEndPoints.deleteProduct()	
			.then().log().all().assertThat().statusCode(200).extract().response();
		
				System.out.println(response);				
		}	
		*/
}
