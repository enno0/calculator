package com.calculator.enno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.enno.Service.CalculatorService;
import com.calculator.enno.model.CalculationResult;

@RestController
@RequestMapping("/api")
class ApiController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/home")
    public List<CalculationResult> home(Model model) {
        return calculatorService.getAll();
    }
}
