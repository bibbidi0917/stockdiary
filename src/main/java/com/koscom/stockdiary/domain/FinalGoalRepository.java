package com.koscom.stockdiary.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.CopyOnWriteArrayList;

public interface FinalGoalRepository extends JpaRepository<FinalGoal, Long> {
    public CopyOnWriteArrayList findAll();
}
