package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.News;
import com.koscom.stockdiary.domain.Transaction;
import com.koscom.stockdiary.service.TransService;
import com.koscom.stockdiary.web.dto.ResponseTransList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchRestController {

    private final TransService transService;

    @GetMapping("/s")
    public List<Transaction> getTransList (@RequestParam(name = "q") String stockName) {
        return transService.search(stockName);
    }


}