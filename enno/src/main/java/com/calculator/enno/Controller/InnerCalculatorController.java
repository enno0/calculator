package com.calculator.enno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calculator.enno.DAO.CalculationResultRepository;
import com.calculator.enno.DTO.CalculatorForm;
import com.calculator.enno.Service.CalculatorService;
import com.calculator.enno.model.CalculationResult;

/**
 * InnerCalculatorController
 */
@Controller
@RequestMapping("/up")
 class InnerCalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @Autowired
    private CalculationResultRepository resultRepository;

    @GetMapping("/form")
    public String calculatorForm(Model model) {
        model.addAttribute("calculatorForm", new CalculatorForm());
        List<CalculationResult> calculationResults = resultRepository.findAll();
        model.addAttribute("calculationResults", calculationResults);
        return "up";
    }


    @PostMapping("/calculate")
    public String calculate(@ModelAttribute CalculatorForm calculatorForm, Model model) {
        try {
            double result = calculatorService.performOperation(
                    calculatorForm.getA(),
                    calculatorForm.getB(),
                    calculatorForm.getOperation()
            );
            calculatorForm.setResult(result);
        } catch (IllegalArgumentException e) {
            calculatorForm.setError(e.getMessage());
        }

        List<CalculationResult> calculationResults = calculatorService.getAll();
        model.addAttribute("calculatorForm", calculatorForm);
        model.addAttribute("calculationResults", calculationResults);

        return "up";
    }
 
    
}
