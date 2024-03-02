package com.calculator.enno.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calculator.enno.DAO.CalculationResultRepository;
import com.calculator.enno.model.CalculationResult;

@Service
@Transactional
public class CalculatorService {

    @Autowired
    private CalculationResultRepository resultRepository;

    public double add(double a, double b) {
        double result = a + b;
        saveCalculationResult(a, b, "add", result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        saveCalculationResult(a, b, "subtract", result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        saveCalculationResult(a, b, "multiply", result);
        return result;
    }

    public double divide(double a, double b) {
        if (b != 0) {
            double result = a / b;
            saveCalculationResult(a, b, "divide", result);
            return result;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }

    private void saveCalculationResult(double a, double b, String operation, double result) {
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setOperandA(a);
        calculationResult.setOperandB(b);
        calculationResult.setOperation(operation);
        calculationResult.setResult(result);
        calculationResult.setTimestamp(new Date());
        resultRepository.save(calculationResult);
    }

    public List<CalculationResult> getAll() {
        return resultRepository.findAll();
    }
}