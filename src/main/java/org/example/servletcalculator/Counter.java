package org.example.servletcalculator;

public class Counter {
    public double calculate (double num1, double num2, String type){
        double resultOperation = switch (type) {
            case "sum" -> num1 + num2;
            case "sub" -> num1 - num2;
            case "mul" -> num1 * num2;
            case "div" -> num1 / num2;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
     return  resultOperation;
    }
}
