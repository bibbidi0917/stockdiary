package com.koscom.stockdiary.service;

import com.koscom.stockdiary.domain.TransRepository;
import com.koscom.stockdiary.domain.Transaction;
import com.koscom.stockdiary.web.dto.ResponseTransList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransService {
    private final TransRepository transRepository;

    public List<Transaction> search(String stockName) {
        return transRepository.findByStockName(stockName);
    }

    /*
    *     String type;
    String date;
    String sum;
    int count;
    String price;
    String curSum;
    String stockName;
    * */

    @PostConstruct
    public void init() {
        transRepository.save(Transaction.builder().type("매도").date("2020.07.11").sum("464,123").price("5,456").stockName("삼성전자").build());
        transRepository.save(Transaction.builder().type("매수").date("2020.07.11").sum("464,123").price("5,456").curSum("445,464").stockName("삼성전자").build());
    }
}
