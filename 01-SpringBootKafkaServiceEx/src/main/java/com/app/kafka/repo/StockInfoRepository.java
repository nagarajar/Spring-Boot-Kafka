package com.app.kafka.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kafka.entity.StockInfo;

public interface StockInfoRepository extends JpaRepository<StockInfo, Serializable> {

}
