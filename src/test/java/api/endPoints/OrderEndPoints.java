package api.endPoints;

import static io.restassured.RestAssured.given;

import java.util.List;

import api.payload.OrderResponse;
import api.payload.Orders;
import api.testCase.LoginTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

public class OrderEndPoints extends LoginTest {
	
	//OrderRequest orderDetail = new OrderRequest();
	
	public static String accessToken;
	//public static String orders;
	public static Orders orders;
	public static List<String> viewOrderId ;
	public  static List<String> deleteOrderId;
	
	
	public static Response createOrder(OrderResponse payload)
	{	
		/*
		OrderRequest orderDetail = new OrderRequest();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productId);
		
		System.out.println(orderDetail);
		
		List<OrderRequest> orderDetailsList = new ArrayList<OrderRequest>();
		orderDetailsList.add(orderDetail);
		
		System.out.println(orderDetailsList);
		
		orders = new Orders ();
		Orders.setOrders(orderDetailsList);
		
		System.out.println(orders);
		*/		
		accessToken =  LoginTest.token;		
		Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).headers("Authorization",token)
		.body("{\r\n"
				+ "  \"orders\": [\r\n"
				+ "    {\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"productOrderedId\": \""+productId+"\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}")
		.when().log().all().post(Routes.postCreateProductUrl);
		return response;
	}	
	
	public static Response viewOrder(OrderResponse payload)
	{
		viewOrderId = LoginTest.orderNo;
		Response response = given().log().all().headers("Authorization",accessToken).queryParams("id",viewOrderId)
		.when().log().all().get(Routes.getOrderDetailsUrl);
			
		System.out.println(response);
		
		return response;		
	}
	/*
	public static Response deleteOrder()
	{
		accessToken =  LoginTest.token;	
		deleteOrderId = LoginTest.orderNo;
		Response response = given().log().all().headers("Authorization",accessToken).pathParam("orders",deleteOrderId).contentType(ContentType.JSON)
		.when().log().all().delete(Routes.deleteOrderUrl);
		
		System.out.println(response);
		
		return response;		
	}

*/
}
