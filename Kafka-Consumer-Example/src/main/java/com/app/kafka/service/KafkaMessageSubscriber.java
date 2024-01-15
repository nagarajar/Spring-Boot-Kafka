package com.app.kafka.service;

import java.util.List;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.kafka.dto.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaMessageSubscriber {

	//@KafkaListener(topics = "my-app-topic-03", groupId = "group-01")
//	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
	//@KafkaListener(topics = "my-app-topic-02", groupId = "group-02")
	public void consume1MessageFromTopic(String message) {
		log.info("Consumer1 consume the message: {}", message);
	}
	
//	
//	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
//	public void consume2MessageFromTopic(String message) {
//		log.info("Consumer2 consume the message: {}", message);
//	}	
//	
//	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
//	public void consume3MessageFromTopic(String message) {
//		log.info("Consumer3 consume the message: {}", message);
//	}
//	
//	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
//	public void consume4MessageFromTopic(String message) {
//		log.info("Consumer4 consume the message: {}", message);
//	}
	
	//@KafkaListener(topics = "my-app-topic-02", groupId = "group-03")
	public void consumeCustomerObjFromTopic(Customer customer) {
		log.info("Consumer consume the message: {}", customer.toString());
		log.info("Consumer consume the message: {}", customer);
	}	
	
	@KafkaListener(topics = "my-app-topic-04", groupId = "group-04")
	public void consumeCustomerObjMapFromTopic(Map<String, List<Customer>> customerMap) {
		log.info("Consumer Map consume the message: {}", customerMap.toString());
		log.info("Consumer Map consume the message: {}", customerMap);
	}	
}
