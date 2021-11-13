package com.cashregister;

public class Display implements Subscriber, View {

    public Display() {

    }

    public void displayText(String text) {
        System.out.println("Displaying the Product: ");
        System.out.println(text);
    }

    @Override
    public void update(String text) {
        this.displayText(text);
        
    }
}
