package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {
}
