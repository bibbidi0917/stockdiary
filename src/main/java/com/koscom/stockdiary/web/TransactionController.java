package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.Stock;
import com.koscom.stockdiary.domain.Transaction;
import com.koscom.stockdiary.service.StockService;
import com.koscom.stockdiary.service.TransService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search/transaction")
public class TransactionController {
    private final TransService transService;
    private final StockService stockService;

    @GetMapping("")
    public String pageSearchTransaction(Model model){
        List<String> tagList = stockService.findStockAllByUser();
        model.addAttribute("tagList", tagList);
        return "searchTransaction";
    }
}
