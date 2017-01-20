package service;

import java.util.Map;

import model.InventoryResponse;
import model.Order;

public interface OrderService {
	public void sendOrder(Order order);
	public void updateOrder(InventoryResponse response);
	public Map<String, Order> getAllOrder();
}
