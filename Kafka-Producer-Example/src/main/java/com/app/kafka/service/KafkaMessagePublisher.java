package com.app.kafka.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.app.kafka.dto.Customer;

@Service
public class KafkaMessagePublisher {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessageToTopic(String message){
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("my-app-topic-01", message);
		
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("Send message = ["+message+"] with offset = ["+result.getRecordMetadata().offset()+"]");
			}else {
				System.out.println("Unable to send message = ["+message+"] due to : "+ex.getMessage());
			}
		});
	}
	
	public void sendCustomerObjToTopic(Customer customer){
		try {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("my-app-topic-02", customer);
		
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("Send message = ["+customer.toString()+"] with offset = ["+result.getRecordMetadata().offset()+"]");
			}else {
				System.out.println("Unable to send message = ["+customer.toString()+"] due to : "+ex.getMessage());
			}
		});
		}catch(Exception ex) {
			System.out.println("ERROR : "+ ex.getMessage());
		}
	}
	
	public void sendCustomerObjMapToTopic(Map<String, List<Customer>> customerMap){
		try {
			CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("my-app-topic-04", customerMap);
			
			future.whenComplete((result, ex) -> {
				if(ex == null) {
					System.out.println("Send message = ["+customerMap.toString()+"] with offset = ["+result.getRecordMetadata().offset()+"]");
				}else {
					System.out.println("Unable to send message = ["+customerMap.toString()+"] due to : "+ex.getMessage());
				}
			});
		}catch(Exception ex) {
			System.out.println("ERROR : "+ ex.getMessage());
		}
	}
}
