package com.calculator.enno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.calculator.enno.Service.CalculatorService;
import com.calculator.enno.model.CalculationResult;
@Controller
public class Home {
    @Autowired
    private CalculatorService calculatorService;

      @GetMapping("/")
    public String home(Model model) {
        List<CalculationResult> calculator = calculatorService.getAll();
        model.addAttribute("home", calculator);
        return "home";
    }
}
