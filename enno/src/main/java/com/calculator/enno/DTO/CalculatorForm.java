package com.calculator.enno.DTO;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CalculatorForm {
    // da DTO

    private double a;
    private double b;
    private Double result;
    private String error;
    private String Operation;

    // getters and setters

}