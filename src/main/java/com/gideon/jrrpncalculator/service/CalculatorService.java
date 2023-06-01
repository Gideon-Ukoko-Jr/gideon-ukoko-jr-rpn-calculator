package com.gideon.jrrpncalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

@Service
public class CalculatorService {

    public BigDecimal evaluateRPN(String expression) {
        String[] tokens = expression.split("\\s+");
        Stack<BigDecimal> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(new BigDecimal(token));
            } else if (token.equals("+")) {
                stack.push(stack.pop().add(stack.pop()));
            } else if (token.equals("-")) {
                BigDecimal b = stack.pop();
                BigDecimal a = stack.pop();
                stack.push(a.subtract(b));
            } else if (token.equals("*")) {
                BigDecimal b = stack.pop();
                BigDecimal a = stack.pop();
                stack.push(a.multiply(b));
            } else if (token.equals("/")) {
                BigDecimal b = stack.pop();
                BigDecimal a = stack.pop();
                stack.push(a.divide(b, MathContext.DECIMAL128));
            } else if (token.equals("sqrt")) {
                stack.push(sqrt(stack.pop()));
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        return stack.pop();
    }

    private BigDecimal sqrt(BigDecimal value) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal two = BigDecimal.valueOf(2);

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Square root of a negative number is not supported.");
        }

        // Initial approximation
        BigDecimal x = value.divide(two, MathContext.DECIMAL128);

        // Perform Newton's method for square root approximation
        for (int i = 0; i < 100; i++) {
            result = x.add(value.divide(x, MathContext.DECIMAL128))
                    .divide(two, MathContext.DECIMAL128);
            if (result.equals(x)) {
                break;
            }
            x = result;
        }

        return result;
    }

    private boolean isNumeric(String token) {
        try {
            new BigDecimal(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
