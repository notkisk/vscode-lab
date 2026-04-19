package edu.lab.refactoring;

import java.util.List;

public class RefactoringTestRunner {

    public static void main(String[] args) {
        testCalculateSumProductRatio();
        testFormatResult();
        testCalculateTotalPrice();
        testApplyDiscount();
        testBuildOrderSummary();
        System.out.println("All refactoring tests passed.");
    }

    private static void testCalculateSumProductRatio() {
        Calculator calculator = new Calculator();
        assertDoubleEquals(0.75, calculator.calculateSumProductRatio(2.0, 4.0), "calculateSumProductRatio");
    }

    private static void testFormatResult() {
        Calculator calculator = new Calculator();
        assertEquals("Result: 1.5", calculator.formatResult(1.5), "formatResult");
    }

    private static void testCalculateTotalPrice() {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Item> items = List.of(
            new Item("Keyboard", 50.0, 1),
            new Item("Mouse", 25.0, 2)
        );
        assertDoubleEquals(100.0, orderProcessor.calculateTotalPrice(items), "calculateTotalPrice");
    }

    private static void testApplyDiscount() {
        OrderProcessor orderProcessor = new OrderProcessor();
        assertDoubleEquals(90.0, orderProcessor.applyDiscount(100.0, true), "applyDiscount member");
        assertDoubleEquals(100.0, orderProcessor.applyDiscount(100.0, false), "applyDiscount non-member");
    }

    private static void testBuildOrderSummary() {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order(
            new Customer("Alice", true),
            List.of(
                new Item("Notebook", 10.0, 2),
                new Item("Pen", 2.5, 4)
            )
        );

        String expected = String.join("\n",
            "Order Summary:",
            "Customer: Alice",
            "Items:",
            "  - Notebook: 2 x $10.0 = $20.0",
            "  - Pen: 4 x $2.5 = $10.0",
            "Total Price: $27.00",
            ""
        );

        assertEquals(expected, orderProcessor.buildOrderSummary(order), "buildOrderSummary");
    }

    private static void assertEquals(String expected, String actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(testName + " failed: expected [" + expected + "] but got [" + actual + "]");
        }
    }

    private static void assertDoubleEquals(double expected, double actual, String testName) {
        double delta = 1e-9;
        if (Math.abs(expected - actual) > delta) {
            throw new AssertionError(testName + " failed: expected [" + expected + "] but got [" + actual + "]");
        }
    }
}
