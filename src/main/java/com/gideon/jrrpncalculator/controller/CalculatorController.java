package com.gideon.jrrpncalculator.controller;

import com.gideon.jrrpncalculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Stack;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @RequestMapping("/")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("expression") String expression, Model model) {
        try {
            System.out.println("Input Expression: " + expression);

            String[] tokens = expression.split("\\s+");
            System.out.println("Tokens: " + Arrays.toString(tokens));

            BigDecimal result = calculatorService.evaluateRPN(expression);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("error", "Invalid expression or operation.");
        }
        return "calculator";
    }

}
