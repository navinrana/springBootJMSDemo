package messaging;

import javax.jms.JMSException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

import model.InventoryResponse;
import service.OrderService;

@Component
public class MessageReceiver {

	static final Logger log=LoggerFactory.getLogger(MessageReceiver.class);
	private static final String ORDER_REPONSE_QUEUE="order-reponse-queue";
	
	@Autowired
	OrderService orderService;
	
	@JmsListener(destination=ORDER_REPONSE_QUEUE)
	public void reveiveMessage(final Message<InventoryResponse> message) throws JMSException{
		log.info("============================================");
		MessageHeaders headers=message.getHeaders();
		log.info("Application: Headers received:{}",headers);
		
		InventoryResponse response=message.getPayload();
		
		log.info("Application:responses: {}",response);
		
		orderService.updateOrder(response);
		log.debug("");
		
		
	}
}
