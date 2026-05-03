package edu.lab.refactoring.fivecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class AfterRefactoringCasesTest {

    @Test
    void renameCaseBehavior() {
        AfterRefactoringCases.CalculatorAfter calculator = new AfterRefactoringCases.CalculatorAfter();
        assertEquals(0.75, calculator.calculateSumProductRatio(2, 4), 1e-9);
    }

    @Test
    void nestedConditionalCaseBehavior() {
        assertEquals(5000, new AfterRefactoringCases.Manager().calculateBonus(), 1e-9);
        assertEquals(3000, new AfterRefactoringCases.Developer().calculateBonus(), 1e-9);
        assertEquals(1000, new AfterRefactoringCases.Intern().calculateBonus(), 1e-9);
    }

    @Test
    void guardClauseCaseBehavior() {
        AfterRefactoringCases.DiscountCalculatorAfter calculator = new AfterRefactoringCases.DiscountCalculatorAfter();
        assertEquals(0.0, calculator.calculateDiscount(90, false), 1e-9);
        assertEquals(0.1, calculator.calculateDiscount(120, false), 1e-9);
        assertEquals(0.2, calculator.calculateDiscount(120, true), 1e-9);
    }

    @Test
    void strategyCaseBehavior() {
        AfterRefactoringCases.PaymentProcessorAfter processor = new AfterRefactoringCases.PaymentProcessorAfter();
        processor.setPaymentStrategy(new AfterRefactoringCases.CreditCardPayment());
        assertEquals("Processing credit card payment of $100.0", processor.processPayment(100));
    }

    @Test
    void extractMethodCaseBehavior() {
        AfterRefactoringCases.OrderProcessorAfter processor = new AfterRefactoringCases.OrderProcessorAfter();
        assertEquals(27.0, processor.processOrder(List.of(10.0, 2.5), List.of(2, 4), true), 1e-9);
    }
}
