package com.koscom.stockdiary.service;

import com.koscom.stockdiary.domain.ApiRepository;
import com.koscom.stockdiary.domain.PerformanceGoalRepository;
import com.koscom.stockdiary.domain.Stock;
import com.koscom.stockdiary.domain.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final ApiRepository apiRepository;
    private final StockRepository stockRepository;
    private final PerformanceGoalRepository performanceGoalRepository;

    public String getPrice(final String marketcode, final String stockName) {
        String issuecode = findIssueCode(stockName);
        return apiRepository.findByQuery(marketcode, issuecode);
    }

    public String findIssueCode(String stockName) {
        Stock stock = stockRepository.findByStockName(stockName);
        return stock.getStockcode();
    }

    @Transactional(readOnly = true)
    public List<String> findStockAllByUser() {
        List<String> nameList = performanceGoalRepository.findAllTag();
        //List<Stock> stockList = stockRepository.findAll(nameList);
        return nameList;
    }

    @Transactional(readOnly = true)
    public List<String> findStockAllByUserString() {
        List<String> nameList = performanceGoalRepository.findAllTag();
        return nameList;
    }

    @PostConstruct
    public void init() {
        stockRepository.save(Stock.builder().stockName("삼성전자").stockcode("005930").build());
        stockRepository.save(Stock.builder().stockName("셀트리온").stockcode("068270").build());
        stockRepository.save(Stock.builder().stockName("네이버").stockcode("035420").build());
        stockRepository.save(Stock.builder().stockName("카카오").stockcode("035720").build());
        stockRepository.save(Stock.builder().stockName("현대차").stockcode("005380").build());
        stockRepository.save(Stock.builder().stockName("SK하이닉스").stockcode("000660").build());
        stockRepository.save(Stock.builder().stockName("엔씨소프트").stockcode("036570").build());
    }
}