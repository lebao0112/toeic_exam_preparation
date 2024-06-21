package com.example.DoAnJava.Repository;

import com.example.DoAnJava.models.Choices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<Choices, Choices> {

}
