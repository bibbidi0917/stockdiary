package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.PerformanceGoal;
import com.koscom.stockdiary.domain.Stock;
import com.koscom.stockdiary.service.GoalService;
import com.koscom.stockdiary.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final GoalService goalService;
    private final StockService stockService;

    @GetMapping("/")
    public String main(Model model) {
        List<PerformanceGoal> perfGoalList = goalService.findTodaysPerfGoal();
        List<String> tagList = stockService.findStockAllByUserString();
        model.addAttribute("perfGoalList", perfGoalList);
        model.addAttribute("tagList",tagList);
        return "index";
    }
}
