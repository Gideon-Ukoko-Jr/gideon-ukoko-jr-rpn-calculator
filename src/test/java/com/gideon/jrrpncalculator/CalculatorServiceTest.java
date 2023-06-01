package com.gideon.jrrpncalculator;

import com.gideon.jrrpncalculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.EmptyStackException;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void testAddition() {
        String expression = "5 3 +";
        BigDecimal result = calculatorService.evaluateRPN(expression);
        Assertions.assertEquals(BigDecimal.valueOf(8), result);
    }

    @Test
    public void testSubtraction() {
        String expression = "5 3 -";
        BigDecimal result = calculatorService.evaluateRPN(expression);
        Assertions.assertEquals(BigDecimal.valueOf(2), result);
    }

    @Test
    public void testMultiplication() {
        String expression = "5 3 *";
        BigDecimal result = calculatorService.evaluateRPN(expression);
        Assertions.assertEquals(BigDecimal.valueOf(15), result);
    }

    @Test
    public void testDivision() {
        String expression = "10 2 /";
        BigDecimal result = calculatorService.evaluateRPN(expression);
        Assertions.assertEquals(BigDecimal.valueOf(5), result);
    }

    @Test
    public void testSquareRoot() {
        String expression = "25 sqrt";
        BigDecimal expected = BigDecimal.valueOf(5);
        BigDecimal result = calculatorService.evaluateRPN(expression);
        Assertions.assertEquals(0, result.compareTo(expected));
    }

    @Test
    public void testComplexExpression() {
        String expression = "5 3 4 + *";
        BigDecimal result = calculatorService.evaluateRPN(expression);
        Assertions.assertEquals(BigDecimal.valueOf(35), result);
    }

    @Test
    public void testInvalidExpression() {
        String expression = "5 3 + *";
        Assertions.assertThrows(EmptyStackException.class, () -> calculatorService.evaluateRPN(expression));
    }
}
