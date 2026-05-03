package edu.lab.refactoring.fivecases;

public class BeforeRefactoringCases {

    public static class CalculatorBefore {
        public double calc(double a, double b) {
            double x = a + b;
            double y = a * b;
            return x / y;
        }
    }

    public static class BonusCalculatorBefore {
        public double calculateBonus(String type) {
            if (type.equals("Manager")) {
                return 5000;
            } else if (type.equals("Developer")) {
                return 3000;
            } else {
                return 1000;
            }
        }
    }

    public static class DiscountCalculatorBefore {
        public double calculateDiscount(double totalAmount, boolean premiumCustomer) {
            double discount = 0.0;
            if (totalAmount > 100) {
                if (premiumCustomer) {
                    discount = 0.2;
                } else {
                    discount = 0.1;
                }
            }
            return discount;
        }
    }

    public static class PaymentProcessorBefore {
        public String processPayment(String paymentMethod, double amount) {
            if (paymentMethod.equals("CreditCard")) {
                return "Processing credit card payment of $" + amount;
            } else if (paymentMethod.equals("PayPal")) {
                return "Processing PayPal payment of $" + amount;
            } else if (paymentMethod.equals("Bitcoin")) {
                return "Processing Bitcoin payment of $" + amount;
            }
            throw new IllegalArgumentException("Unknown payment method");
        }
    }

    public static class OrderProcessorBefore {
        public double processOrder(double[] prices, int[] quantities, boolean member) {
            double totalPrice = 0;
            for (int i = 0; i < prices.length; i++) {
                totalPrice += prices[i] * quantities[i];
            }
            if (member) {
                totalPrice *= 0.9;
            }
            return totalPrice;
        }
    }
}
