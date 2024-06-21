package com.example.DoAnJava.Repository;

import com.example.DoAnJava.models.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Parts, Integer> {
}
