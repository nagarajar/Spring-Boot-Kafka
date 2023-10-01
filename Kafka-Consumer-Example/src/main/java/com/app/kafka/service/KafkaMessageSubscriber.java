package com.app.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaMessageSubscriber {

	//@KafkaListener(topics = "my-app-topic-03", groupId = "group-01")
	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
	public void consume1MessageFromTopic(String message) {
		log.info("Consumer1 consume the message: {}", message);
	}
	
	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
	public void consume2MessageFromTopic(String message) {
		log.info("Consumer2 consume the message: {}", message);
	}	
	
	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
	public void consume3MessageFromTopic(String message) {
		log.info("Consumer3 consume the message: {}", message);
	}
	
	@KafkaListener(topics = "my-app-topic-04", groupId = "group-02")
	public void consume4MessageFromTopic(String message) {
		log.info("Consumer4 consume the message: {}", message);
	}
	
	
}
