package edu.lab.refactoring;

public class Calculator {
    public double calculateSumProductRatio(double firstNumber, double secondNumber) {
        double sum = firstNumber + secondNumber;
        double product = firstNumber * secondNumber;
        return sum / product;
    }

    public String formatResult(double result) {
        return "Result: " + result;
    }

    public void printResult(double result) {
        System.out.println(formatResult(result));
    }
}
