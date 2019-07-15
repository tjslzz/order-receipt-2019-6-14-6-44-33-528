package org.katas.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String custormerAddress;
    List<LineItem> LineItems;

    public Order(String customerName, String custormerAddress, List<LineItem> LineItems) {
        this.customerName = customerName;
        this.custormerAddress = custormerAddress;
        this.LineItems = LineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return custormerAddress;
    }

    public List<LineItem> getLineItems() {
        return LineItems;
    }
}
