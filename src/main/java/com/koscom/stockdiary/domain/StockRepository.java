package com.koscom.stockdiary.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
    Stock findByStockName(String stockName);
}