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
        transRepository.save(Transaction.builder().type("매도").date("2021.11.11").sum("414,123").stockName("삼성전자").count(6).build());
        transRepository.save(Transaction.builder().type("매수").date("2021.10.30").sum("64,276").stockName("삼성전자").count(1).build());
        transRepository.save(Transaction.builder().type("매도").date("2021.07.11").sum("8,564,003").stockName("삼성전자").count(122).build());
        transRepository.save(Transaction.builder().type("매수").date("2021.07.23").sum("464,101").stockName("삼성전자").count(6).build());
        transRepository.save(Transaction.builder().type("매수").date("2021.07.17").sum("464,123").stockName("삼성전자").count(6).build());
        transRepository.save(Transaction.builder().type("매수").date("2021.07.11").sum("464,123").stockName("카카오").count(22).build());
        transRepository.save(Transaction.builder().type("매수").date("2021.07.01").sum("8,176,156").stockName("셀트리온").count(40).build());
        transRepository.save(Transaction.builder().type("매도").date("2021.04.11").sum("704,870").stockName("셀트리온").count(3).build());
        transRepository.save(Transaction.builder().type("매도").date("2021.02.12").sum("108,542").stockName("카카오").count(1).build());
        transRepository.save(Transaction.builder().type("매도").date("2020.07.21").sum("304,157").stockName("네이버").count(1).build());
    }
}
