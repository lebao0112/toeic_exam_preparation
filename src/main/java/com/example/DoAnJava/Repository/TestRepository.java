package com.example.DoAnJava.Repository;

import com.example.DoAnJava.models.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Tests, Integer> {
}

