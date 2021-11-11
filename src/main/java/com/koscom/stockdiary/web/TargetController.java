package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.FinalGoal;
import com.koscom.stockdiary.service.GoalService;
import com.koscom.stockdiary.web.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class TargetController {
    private final GoalService goalService;

    @GetMapping("/target/nowTarget")
    public String pageNowTarget(Model model){
        List<FinalGoal> finalGoals = goalService.findGoalList();
        List<GoalDTO> finalGoalList = new ArrayList<>();

        for(int i=0; i<finalGoals.size(); i++){
            GoalDTO goal = goalService.findGoalDetail(finalGoals.get(i).getSeq());
            finalGoalList.add(goal);
        }
        model.addAttribute("finalGoalList",finalGoalList);
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

    @GetMapping("/target/finalTargetDetail/{seq}")
    public String pageFinalTargetDetail(@PathVariable Long seq, Model model){
        GoalDTO goal = goalService.findGoalDetail(seq);
        model.addAttribute("goal",goal);
        return "finalTargetDetail";
    }

    @GetMapping("/target/performanceTargetcreate")
    public String pageperformanceTargetCreate(){
        return "performanceTargetPopup";
    }
}
