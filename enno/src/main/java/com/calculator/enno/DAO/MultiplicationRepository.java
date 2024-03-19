package com.calculator.enno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.enno.model.Multiplication;

public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {
    
}
