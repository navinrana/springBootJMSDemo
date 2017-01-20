package service;

import java.util.Map;
import model.Order;



public interface OrderRepository {

	public void putOrder(Order order );
	public Order getOrder(String orderId);
	public Map<String,Order> getAllOrder();
}
