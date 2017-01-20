package service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import model.Order;

@Service("orderRepository")
public class OrderRepositoryImpl implements OrderRepository{

	private final Map<String, Order> orders=new ConcurrentHashMap<String,Order>();
	@Override
	public void putOrder(Order order) {
		// TODO Auto-generated method stub
		orders.put(order.getOrderId(), order);
		
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return orders.get(orderId);
	}

	@Override
	public Map<String, Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orders;
	}

}
