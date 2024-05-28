package api.payload;

import java.util.List;

public class Orders {
	
	public static List<OrderRequest> orders;

	public static List<OrderRequest> getOrders() {
		return orders;
	}

	public static void setOrders(List<OrderRequest> orders) {
		Orders.orders = orders;
	}
	
	
	
	

}
