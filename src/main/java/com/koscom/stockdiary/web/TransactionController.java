package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.Transaction;
import com.koscom.stockdiary.service.TransService;
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

    @GetMapping("")
    public String pageSearchTransaction(){
        return "searchTransaction";
    }

    @GetMapping("/list")
    public String getTransList (@RequestParam(name = "q") String stockName, Model model) {
        List<Transaction> list = transService.search(stockName);
        model.addAttribute("transactionList", list);
        model.addAttribute("aaa", "aaa");
        System.out.println(model.getAttribute("transactionList").toString());
        return "searchTransaction";
    }
}
