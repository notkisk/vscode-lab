package edu.lab.refactoring.fivecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BeforeRefactoringCasesTest {

    @Test
    void renameCaseBehavior() {
        BeforeRefactoringCases.CalculatorBefore calculator = new BeforeRefactoringCases.CalculatorBefore();
        assertEquals(0.75, calculator.calc(2, 4), 1e-9);
    }

    @Test
    void nestedConditionalCaseBehavior() {
        BeforeRefactoringCases.BonusCalculatorBefore calculator = new BeforeRefactoringCases.BonusCalculatorBefore();
        assertEquals(5000, calculator.calculateBonus("Manager"), 1e-9);
        assertEquals(3000, calculator.calculateBonus("Developer"), 1e-9);
        assertEquals(1000, calculator.calculateBonus("Intern"), 1e-9);
    }

    @Test
    void guardClauseCaseBehavior() {
        BeforeRefactoringCases.DiscountCalculatorBefore calculator = new BeforeRefactoringCases.DiscountCalculatorBefore();
        assertEquals(0.0, calculator.calculateDiscount(90, false), 1e-9);
        assertEquals(0.1, calculator.calculateDiscount(120, false), 1e-9);
        assertEquals(0.2, calculator.calculateDiscount(120, true), 1e-9);
    }

    @Test
    void strategyCaseBehavior() {
        BeforeRefactoringCases.PaymentProcessorBefore processor = new BeforeRefactoringCases.PaymentProcessorBefore();
        assertEquals("Processing credit card payment of $100.0", processor.processPayment("CreditCard", 100));
    }

    @Test
    void extractMethodCaseBehavior() {
        BeforeRefactoringCases.OrderProcessorBefore processor = new BeforeRefactoringCases.OrderProcessorBefore();
        assertEquals(27.0, processor.processOrder(new double[]{10, 2.5}, new int[]{2, 4}, true), 1e-9);
    }
}
