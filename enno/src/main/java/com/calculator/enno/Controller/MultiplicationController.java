package com.calculator.enno.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calculator.enno.DTO.MultiplicationForm;
import com.calculator.enno.Service.MultiplicationService;
import com.calculator.enno.model.Multiplication;

@Controller
@RequestMapping("/Multi")
public class MultiplicationController {
    
    @Autowired
    private MultiplicationService multiplicationService;

    @GetMapping("/multiplications-up")

    public String getAllMultiplications2(Model model) {
        model.addAttribute("multiplicationForm", new MultiplicationForm());

        List<Multiplication> multiplications = multiplicationService.getAll();

        model.addAttribute("multiplications", multiplications);

        return "multiply-form-2";

    }

    @PostMapping("/multiply-up")

    public String multiply(@ModelAttribute MultiplicationForm multiplicationForm, Model model) {
        try {
            List<Multiplication> multiplicationSteps = multiplicationService.Multiply(
                multiplicationForm.getOperA(), multiplicationForm.getMultiplicationTable());
                multiplicationForm.setResult(multiplicationSteps);

        } catch (Exception e) {
            multiplicationForm.setError(e.getMessage());
        }

        List<Multiplication> multiplications = multiplicationService.getAll();
        model.addAttribute("multiplicationForm", multiplicationForm);
        model.addAttribute("multiplications", multiplications);

        return "multiply-form-2";

    }

   

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        multiplicationService.delete(id);
        return "redirect:/Multi/multiplications";
    }
    @GetMapping("/delete-all")
    public String deleteAll() {
        multiplicationService.deleteAll();
        return "redirect:/Multi/multiplications-up";
    }
}
