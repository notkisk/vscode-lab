package edu.lab.refactoring.fivecases;

import java.util.List;

public class AfterRefactoringCases {

    public static class CalculatorAfter {
        public double calculateSumProductRatio(double firstNumber, double secondNumber) {
            double sum = firstNumber + secondNumber;
            double product = firstNumber * secondNumber;
            return sum / product;
        }
    }

    public abstract static class Employee {
        public abstract double calculateBonus();
    }

    public static class Manager extends Employee {
        @Override
        public double calculateBonus() { return 5000; }
    }

    public static class Developer extends Employee {
        @Override
        public double calculateBonus() { return 3000; }
    }

    public static class Intern extends Employee {
        @Override
        public double calculateBonus() { return 1000; }
    }

    public static class DiscountCalculatorAfter {
        public double calculateDiscount(double totalAmount, boolean premiumCustomer) {
            if (totalAmount <= 100) {
                return 0.0;
            }
            if (premiumCustomer) {
                return 0.2;
            }
            return 0.1;
        }
    }

    public interface PaymentStrategy {
        String pay(double amount);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        @Override
        public String pay(double amount) { return "Processing credit card payment of $" + amount; }
    }

    public static class PayPalPayment implements PaymentStrategy {
        @Override
        public String pay(double amount) { return "Processing PayPal payment of $" + amount; }
    }

    public static class BitcoinPayment implements PaymentStrategy {
        @Override
        public String pay(double amount) { return "Processing Bitcoin payment of $" + amount; }
    }

    public static class PaymentProcessorAfter {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public String processPayment(double amount) {
            return paymentStrategy.pay(amount);
        }
    }

    public static class OrderProcessorAfter {
        public double processOrder(List<Double> prices, List<Integer> quantities, boolean member) {
            double totalPrice = calculateTotalPrice(prices, quantities);
            return applyDiscount(totalPrice, member);
        }

        private double calculateTotalPrice(List<Double> prices, List<Integer> quantities) {
            double total = 0;
            for (int i = 0; i < prices.size(); i++) {
                total += prices.get(i) * quantities.get(i);
            }
            return total;
        }

        private double applyDiscount(double totalPrice, boolean member) {
            return member ? totalPrice * 0.9 : totalPrice;
        }
    }
}
