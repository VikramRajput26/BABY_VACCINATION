package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.VaccineSchedule;

public interface VaccineScheduleRepository extends JpaRepository<VaccineSchedule, Integer> {
}
