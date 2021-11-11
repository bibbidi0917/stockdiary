package com.koscom.stockdiary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StockRepository extends JpaRepository<Stock, String> {
    Stock findByStockName(String stockName);
    @Query(nativeQuery=true,
            value = "SELECT * FROM stock s ")
    List<Stock> findAll(List<String> name);
}
