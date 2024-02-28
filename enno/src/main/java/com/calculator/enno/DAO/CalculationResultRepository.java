package com.calculator.enno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.enno.model.CalculationResult;

public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
}