package com.cashregister;

public class TicketPrinter implements Subscriber, View {

    public TicketPrinter() {

    }

    public void displayText(String text) {
        System.out.println("Physically printing the Product info.");
        System.out.println(text);
    }

    @Override
    public void update(String text) {
        this.displayText(text);
    }
}
