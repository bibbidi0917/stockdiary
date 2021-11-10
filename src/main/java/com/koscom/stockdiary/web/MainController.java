package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.PerformanceGoal;
import com.koscom.stockdiary.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final GoalService goalService;

    @GetMapping("/")
    public String main(Model model) {
        List<PerformanceGoal> perfGoalList = goalService.findTodaysPerfGoal();
        model.addAttribute("perfGoalList", perfGoalList);
        return "index";
    }


    @GetMapping("/search/transaction")
    public String pageSearchTransaction(){
        return "searchTransaction";
    }

}
