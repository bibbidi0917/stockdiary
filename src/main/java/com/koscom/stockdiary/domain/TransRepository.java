package com.koscom.stockdiary.domain;

import com.koscom.stockdiary.web.dto.ResponseTransList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByStockName(String stockName);
}
