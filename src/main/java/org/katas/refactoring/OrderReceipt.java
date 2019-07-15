package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private static final double Sales_Tax_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output = printHeaders(output);
        output = printCustomerInfo(output,order);
        output = printLineItems(output);
        return output.toString();
    }

    private StringBuilder printLineItems(StringBuilder output){
        double totalSalesTx = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output = printDescription(lineItem.getDescription(),output);
            output = printPrice(lineItem.getPrice(),output);
            output = printQuantity(lineItem.getQuantity(),output);
            output = printTotal(lineItem.totalAmount(),output);
            totalSalesTx += calculateSalesTax(lineItem);
            totalAmount += lineItem.totalAmount() + calculateSalesTax(lineItem);
        }

        output = printStateTax(output,totalSalesTx);
        output = printTotalAmout(output,totalAmount);
        return output;
    }

    private StringBuilder printTotal(double totalAmount, StringBuilder output) {
        output.append(totalAmount);
        output = addSpaceN(output);
        return output;
    }

    private StringBuilder printQuantity(int quantity, StringBuilder output) {
        output.append(quantity);
        output = addSpaceT(output);
        return output;
    }

    private StringBuilder printPrice(double price, StringBuilder output) {
        output.append(price);
        output = addSpaceT(output);
        return output;
    }

    private StringBuilder printDescription(String description,StringBuilder output) {
        output.append(description);
        output = addSpaceT(output);
        return output;
    }

    private double calculateSalesTax(LineItem lineItem){
        return lineItem.totalAmount() * Sales_Tax_RATE;
    }

    private StringBuilder printStateTax(StringBuilder output,double totalSalesTx){
        output.append("Sales Tax").append('\t').append(totalSalesTx);
        return output;
    }

    private StringBuilder printTotalAmout(StringBuilder output,double totalAmount){
        output.append("Total Amount").append('\t').append(totalAmount);
        return output;
    }

    private StringBuilder printCustomerInfo(StringBuilder output, Order order) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        return output;
    }

    public StringBuilder printHeaders(StringBuilder output){
        output.append("======Printing Orders======\n");
        return output;
    }

    private StringBuilder addSpaceT(StringBuilder output){
        output.append('\t');
        return output;
    }

    private StringBuilder addSpaceN(StringBuilder output){
        output.append('\n');
        return output;
    }
}