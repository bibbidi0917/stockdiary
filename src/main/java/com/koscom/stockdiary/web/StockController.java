package com.koscom.stockdiary.web;

import com.koscom.stockdiary.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/koscom")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/price")
    public String getPriceByQuery(@RequestParam(name = "mc") String marketcode, @RequestParam(name = "ic") String stockName) {
        return stockService.getPrice(marketcode, stockName);
    }


}
