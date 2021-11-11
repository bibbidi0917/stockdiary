package com.koscom.stockdiary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerformanceGoalRepository extends JpaRepository<PerformanceGoal, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM performance_goal p " +
                    "WHERE DATE(p.start_date) <= DATE(now()) " +
                    "AND (DATE(p.end_date) >= DATE(now()) OR p.end_date is NULL)")
    List<PerformanceGoal> findTodaysPerfGoal();

    @Query(nativeQuery = true,
            value = "SELECT p.tag1 FROM performance_goal p WHERE p.tag1 IS NOT NULL " +
                    "UNION " +
                    "SELECT p.tag2 FROM performance_goal p WHERE p.tag2 IS NOT NULL " +
                    "UNION " +
                    "SELECT p.tag3 FROM performance_goal p WHERE p.tag3 IS NOT NULL ")
    List<String> findAllTag();
}
