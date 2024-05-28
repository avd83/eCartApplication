package api.payload;

public class OrderRequest {
	
	public static String country;
	public static String productOrderedId;
	
	public static String getCountry() {
		return country;
	}
	public  void setCountry(String country) {
		OrderRequest.country = country;
	}
	public static String getProductOrderedId() {
		return productOrderedId;
	}
	public void setProductOrderedId(String productOrderedId) {
		OrderRequest.productOrderedId = productOrderedId;
	}

}
