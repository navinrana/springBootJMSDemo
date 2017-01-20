package service;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import messaging.MessageSender;
import model.InventoryResponse;
import model.Order;
import status.OrderStatus;
import util.BasicUtil;

@Service
public class OrderServiceImpl implements OrderService {

	static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	MessageSender messageSender;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public void sendOrder(Order order) {
		// TODO Auto-generated method stub
		log.info("=================================");

		order.setOrderId(BasicUtil.getUniqueId());
		order.setStatus(OrderStatus.CONFIRMED);
		orderRepository.putOrder(order);

		log.info("Application: request:{}", order);

		messageSender.sendMessage(order);

		log.info("=================================");
	}

	@Override
	public void updateOrder(InventoryResponse response) {
		// TODO Auto-generated method stub

		Order order=orderRepository.getOrder(response.getOrderId());
		if(response.getReturnCode()==200){
			order.setStatus(OrderStatus.CONFIRMED);
		}else if(response.getReturnCode()==300){
			order.setStatus(OrderStatus.FAILED);
		}else{
			order.setStatus(OrderStatus.PENDING);
		}
		orderRepository.putOrder(order);
	}

	@Override
	public Map<String, Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.getAllOrder();
	}

}
