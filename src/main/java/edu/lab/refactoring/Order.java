package edu.lab.refactoring;

import java.util.List;

public class Order {
    private final Customer customer;
    private final List<Item> items;

    public Order(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = List.copyOf(items);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}
