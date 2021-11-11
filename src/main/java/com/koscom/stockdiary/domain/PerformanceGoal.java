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
public class PerformanceGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Boolean isDone = false;

    private String tag1;
    private String tag2;
    private String tag3;

    @Builder
    public PerformanceGoal(String title, LocalDate startDate, LocalDate endDate, String tag1, String tag2, String tag3) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    public void update(String title, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void changeIsDoneStatus() {
        this.isDone = !this.isDone;
    }
}
