package com.koscom.stockdiary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerformanceGoalRepository extends JpaRepository<PerformanceGoal, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM performance_goal p " +
                    "WHERE DATE(p.start_date) <= DATE(now()) " +
                    "AND (DATE(p.end_date) >= DATE(now()) OR p.end_date is NULL) " +
                    "AND p.is_done = false")
    public List<PerformanceGoal> findTodaysPerfGoal();
}
