package com.calculator.enno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculator.enno.DAO.CalculationResultRepository;
import com.calculator.enno.DTO.CalculatorForm;
import com.calculator.enno.Service.CalculatorService;
import com.calculator.enno.model.CalculationResult;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculationResultRepository resultRepository;
    
    @GetMapping("/form")
    public String calculatorForm(Model model) {
        model.addAttribute("calculatorForm", new CalculatorForm());
        List<CalculationResult> calculationResults = resultRepository.findAll();
        model.addAttribute("calculationResults", calculationResults);
        return "calculator";
    }
    
    @GetMapping("/add")
    public String add(@RequestParam double a, @RequestParam double b, Model model) {
        model.addAttribute("result", calculatorService.add(a, b));

        return "calculator";
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam double a, @RequestParam double b, Model model) {
        model.addAttribute("result", calculatorService.subtract(a, b));
        return "calculator";
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double a, @RequestParam double b, Model model) {
        model.addAttribute("result", calculatorService.multiply(a, b));
        return "calculator";
    }

    @GetMapping("/divide")
    public String divide(@RequestParam double a, @RequestParam double b, Model model) {
        try {
            model.addAttribute("result", calculatorService.divide(a, b));
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "calculator";
    }

  
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable long id){
        calculatorService.delete(id);
        return "redirect:/";
    }
}
