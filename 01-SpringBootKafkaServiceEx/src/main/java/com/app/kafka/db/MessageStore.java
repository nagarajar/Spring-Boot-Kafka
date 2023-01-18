package com.app.kafka.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.kafka.entity.StockInfo;
import com.app.kafka.repo.StockInfoRepository;
import com.app.kafka.util.JsonUtil;

@Component
public class MessageStore {
	
	@Autowired
	private StockInfoRepository repo;

	public void add(String message) {
		//JSON TO Object
		StockInfo si = JsonUtil.convertToObj(message);
		repo.save(si);
	}
	
	public List<StockInfo> getAll() {
		return repo.findAll();
	}
}
