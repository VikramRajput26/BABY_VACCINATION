package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
}
