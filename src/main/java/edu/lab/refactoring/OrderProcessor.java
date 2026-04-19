package edu.lab.refactoring;

import java.util.List;

public class OrderProcessor {

    private static final double MEMBER_DISCOUNT_RATE = 0.10;

    public String buildOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order.getItems());
        double discountedPrice = applyDiscount(totalPrice, order.getCustomer().isMember());
        return formatSummary(order, discountedPrice);
    }

    public void printOrderSummary(Order order) {
        System.out.print(buildOrderSummary(order));
    }

    double calculateTotalPrice(List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    double applyDiscount(double totalPrice, boolean isMember) {
        if (isMember) {
            return totalPrice * (1 - MEMBER_DISCOUNT_RATE);
        }
        return totalPrice;
    }

    private String formatSummary(Order order, double totalPrice) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order Summary:\n");
        builder.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        builder.append("Items:\n");
        appendItems(order.getItems(), builder);
        builder.append(String.format("Total Price: $%.2f%n", totalPrice));
        return builder.toString();
    }

    private void appendItems(List<Item> items, StringBuilder builder) {
        for (Item item : items) {
            double lineTotal = item.getQuantity() * item.getPrice();
            builder.append("  - ")
                .append(item.getName())
                .append(": ")
                .append(item.getQuantity())
                .append(" x $")
                .append(item.getPrice())
                .append(" = $")
                .append(lineTotal)
                .append("\n");
        }
    }
}
