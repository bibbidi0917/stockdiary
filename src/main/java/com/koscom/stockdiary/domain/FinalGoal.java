package com.koscom.stockdiary.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FinalGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @OneToMany
    @JoinColumn(name="FINALGOAL_SEQ")
    private List<PerformanceGoal> performances = new ArrayList<>();

    @Builder
     public FinalGoal(String title, LocalDate startDate, LocalDate endDate) {
         this.title = title;
         this.startDate = startDate==null ? LocalDate.now() : startDate;
         this.endDate = endDate;
     }

     public void update(String title, LocalDate startDate, LocalDate endDate) {
         this.title = title;
         this.startDate = startDate;
         this.endDate = endDate;
     }

    public void add(PerformanceGoal performanceGoal) {
         this.getPerformances().add(performanceGoal);
    }
}
