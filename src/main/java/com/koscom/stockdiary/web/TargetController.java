package com.koscom.stockdiary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TargetController {
    @GetMapping("/target/nowTarget")
    public String pageNowTarget(){
        return "nowTarget";
    }

    @GetMapping("/target/finalTargetCreate")
    public String pageFinalTargetCreate(){
        return "finalTargetPopup";
    }

    @GetMapping("/target/historyTarget")
    public String pageHistoryTarget(){
        return "historyTarget";
    }
}
