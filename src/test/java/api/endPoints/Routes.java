package api.endPoints;

public class Routes {
	
	/*
	 *post login : https://rahulshettyacademy.com/api/ecom/auth/login
	 post : https://rahulshettyacademy.com/api/ecom/product/add-product
	 post : https://rahulshettyacademy.com/api/ecom/order/create-order
	 get : https://rahulshettyacademy.com/api/ecom/order/get-orders-details?id={{order_id}}
	 delete : https://rahulshettyacademy.com/api/ecom/order/delete-order/{{order_id}}
	 delete : https://rahulshettyacademy.com/api/ecom/product/delete-product/{{product_id}}
	  */
	public static String baseUrl = "https://rahulshettyacademy.com/";
	
	public static String postloginUrl =baseUrl+"api/ecom/auth/login";
	public static String postAddProductUrl = baseUrl+"api/ecom/product/add-product";
	public static String deleteProductUrl =baseUrl+"api/ecom/product/delete-product/{productId}";
	
	public static String postCreateProductUrl =baseUrl+"api/ecom/order/create-order";
	public static String getOrderDetailsUrl =baseUrl+"api/ecom/order/get-orders-details?id={orders}";	
	public static String deleteOrderUrl =baseUrl+"api/ecom/order/delete-order/{orders}";
	
	
	
}
