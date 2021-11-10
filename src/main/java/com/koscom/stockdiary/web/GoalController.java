package com.koscom.stockdiary.web;

import com.koscom.stockdiary.domain.FinalGoal;
import com.koscom.stockdiary.domain.PerformanceGoal;
import com.koscom.stockdiary.service.GoalService;
import com.koscom.stockdiary.web.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/goal")
public class GoalController {

    private final GoalService goalService;

    @GetMapping("/form")
    public String getForm() {
        return "form";
    }

    @GetMapping("/{seq}/perf")
    public String getPerf(@PathVariable("seq") Long finalSeq, Model model) {
        model.addAttribute("finalSeq", finalSeq);
        return "perf";
    }

    @PostMapping("/final")
    public void createFinalGoal(@ModelAttribute FinalGoal finalGoal) {
        goalService.createFinalGoal(finalGoal);
    }

    @PostMapping("/final/{finalSeq}")
    public void updateFinalGoal(@ModelAttribute FinalGoal finalGoal, @PathVariable("finalSeq") Long finalSeq) {
        goalService.updateFinalGoal(finalSeq, finalGoal);
    }

    @PostMapping("/{finalSeq}/perf")
    public void createPerfGoal(@ModelAttribute PerformanceGoal performanceGoal, @PathVariable("finalSeq") Long finalSeq) {
        goalService.createPerfGoal(performanceGoal, finalSeq);
    }

    @PostMapping("/perf/{perfSeq}")
    public void updatePerfGoal(@ModelAttribute PerformanceGoal performanceGoal, @PathVariable("perfSeq") Long perfSeq) {
        goalService.updatePerfGoal(perfSeq, performanceGoal);
    }

    @GetMapping("/")
    public ResponseEntity<List<FinalGoal>> findGoalList() {
        List<FinalGoal> goalList = goalService.findGoalList();
        return ResponseEntity.status(HttpStatus.OK).body(goalList);
    }

    @GetMapping("/{finalSeq}")
    public ResponseEntity<GoalDTO<FinalGoal>> findGoalDetail(@PathVariable("finalSeq") Long finalSeq) {
        GoalDTO goalDTO = goalService.findGoalDetail(finalSeq);
        return ResponseEntity.status(HttpStatus.OK).body(goalDTO);
    }

    @GetMapping("/today")
    public ResponseEntity<List<PerformanceGoal>> findTodaysPerfGoal() {
        List<PerformanceGoal> perfGoalList = goalService.findTodaysPerfGoal();
        return ResponseEntity.status(HttpStatus.OK).body(perfGoalList);
    }

    @PostMapping("/done/{perfSeq}")
    public void changeIsDoneStatus(@PathVariable("perfSeq") Long perfSeq) {
        goalService.changeIsDoneStatus(perfSeq);
    }
}
