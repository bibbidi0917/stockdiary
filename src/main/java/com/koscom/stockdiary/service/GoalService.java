package com.koscom.stockdiary.service;

import com.koscom.stockdiary.domain.FinalGoal;
import com.koscom.stockdiary.domain.FinalGoalRepository;
import com.koscom.stockdiary.domain.PerformanceGoal;
import com.koscom.stockdiary.domain.PerformanceGoalRepository;
import com.koscom.stockdiary.web.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GoalService {

    private final FinalGoalRepository finalGoalRepository;
    private final PerformanceGoalRepository performanceGoalRepository;

    @PostConstruct
    @Transactional
    public void init() {
        FinalGoal finalGoal1 = FinalGoal.builder().title("최종목표1").startDate(LocalDate.now()).endDate(LocalDate.now().plusMonths(1)).build();
        finalGoalRepository.save(finalGoal1);

        PerformanceGoal goal1 = PerformanceGoal.builder().title("수행목표1").startDate(LocalDate.now()).endDate(LocalDate.now().plusMonths(1)).build();
        performanceGoalRepository.save(goal1);
        finalGoal1.add(goal1);
        finalGoalRepository.save(finalGoal1);

        FinalGoal finalGoal2 = FinalGoal.builder().title("최종목표2").startDate(LocalDate.now()).endDate(LocalDate.now().plusMonths(1)).build();
        finalGoalRepository.save(finalGoal2);

        PerformanceGoal goal2 = PerformanceGoal.builder().title("수행목표2").startDate(LocalDate.now().minusDays(3)).endDate(LocalDate.now().plusMonths(1)).build();
        performanceGoalRepository.save(goal2);
        goal2.setIsDone(true);
        finalGoal2.add(goal2);
        finalGoalRepository.save(finalGoal2);

        PerformanceGoal goal3 = PerformanceGoal.builder().title("수행목표3").startDate(LocalDate.now().minusDays(3)).endDate(LocalDate.now().minusDays(1)).build();
        performanceGoalRepository.save(goal3);
        finalGoal2.add(goal3);
        finalGoalRepository.save(finalGoal2);

        PerformanceGoal goal4 = PerformanceGoal.builder().title("수행목표4").startDate(LocalDate.now()).endDate(LocalDate.now()).build();
        goal4.setIsDone(true);
        performanceGoalRepository.save(goal4);
        finalGoal2.add(goal4);
        finalGoalRepository.save(finalGoal2);

    }


    @Transactional
    public void createFinalGoal(FinalGoal finalGoal) {
        if(finalGoal.getStartDate() == null) finalGoal.setStartDate(LocalDate.now());
        finalGoalRepository.save(finalGoal);
    }

    @Transactional
    public void updateFinalGoal(Long seq, FinalGoal finalGoal) {
        FinalGoal goal = finalGoalRepository.findById(seq).orElse(null);
        goal.update(finalGoal.getTitle(), finalGoal.getStartDate(), finalGoal.getEndDate());
    }

    @Transactional
    public void createPerfGoal(PerformanceGoal performanceGoal, Long finalSeq) {
        if(performanceGoal.getStartDate() == null) performanceGoal.setStartDate(LocalDate.now());
        performanceGoalRepository.save(performanceGoal);
        FinalGoal finalGoal = finalGoalRepository.findById(finalSeq).orElse(null);
        finalGoal.add(performanceGoal);
    }

    @Transactional
    public void updatePerfGoal(Long seq, PerformanceGoal performanceGoal) {
        PerformanceGoal goal = performanceGoalRepository.findById(seq).orElse(null);
        goal.update(performanceGoal.getTitle(), performanceGoal.getStartDate(), performanceGoal.getEndDate());
    }

    //진행중목표 리스트
    @Transactional(readOnly = true)
    public List<FinalGoal> findGoalList() {
        List<FinalGoal> goalList = finalGoalRepository.findAll();

        return goalList;
    }

    //목표세부조회
    @Transactional(readOnly = true)
    public GoalDTO<Object> findGoalDetail(Long finalSeq) {
        FinalGoal finalGoal = finalGoalRepository.findById(finalSeq).orElse(null);
        int done = (int) finalGoal.getPerformances().stream()
                .filter(perfGoal -> perfGoal.getIsDone()==Boolean.TRUE)
                .count();
        System.out.println(finalGoal.getPerformances().size());
        int progress = (int) ((double)done / (double)finalGoal.getPerformances().size() * 100) ;
        return GoalDTO.builder().object(finalGoal).progress(progress).build();
    }

    //오늘의 목표
    @Transactional(readOnly = true)
    public List<PerformanceGoal> findTodaysPerfGoal() {
        List<PerformanceGoal> perfGoalList = performanceGoalRepository.findTodaysPerfGoal();
        return perfGoalList;
    }

    @Transactional
    public void changeIsDoneStatus(Long perfSeq) {
        PerformanceGoal perfGoal = performanceGoalRepository.findById(perfSeq).orElse(null);
        perfGoal.changeIsDoneStatus();
    }
}
