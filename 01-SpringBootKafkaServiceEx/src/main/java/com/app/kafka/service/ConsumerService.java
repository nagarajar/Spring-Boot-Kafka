package com.app.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.app.kafka.db.MessageStore;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerService {
	
	@Autowired
	private MessageStore store;
	
	@KafkaListener(topics = "${my.topic.name}",groupId = "abcd")
	public void readMessage(String message) {
		log.info("MESSAGE IS AT CONSUMER SERVICE : {}",message);
		store.add(message);
	}
}
