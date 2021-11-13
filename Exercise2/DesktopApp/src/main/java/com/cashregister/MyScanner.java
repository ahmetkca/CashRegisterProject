package com.cashregister;

import javax.swing.*;
import java.awt.*;

public class MyScanner extends JPanel {
    static final int minWidth = Configuration.MAIN_WINDOWS_WIDTH;
    static final int minHeight = (int) (Configuration.MAIN_WINDOWS_WIDTH * (30.0 / 100.0));

    private String input;
    private JButton button;
    private JTextField inputField;
    private CashRegister cashRegister;

    public MyScanner(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
        init();
    }

    private void init() {
        setLayout(new GridLayout(0, 2));
        button = new JButton("Search");
        inputField = new JTextField("Enter UPC Code here...");
        add(inputField);
        add(button);
        setUpButton();
    }

    private void setUpButton() {
        button.addActionListener(e -> {
            inputField.setEnabled(false);
            input = inputField.getText();
            try {
                cashRegister.setCurrentProductUPC(Long.parseLong(input));
            } catch (NumberFormatException err) {
                err.printStackTrace();
            }
            cashRegister.getCurrentProductInfo();
            inputField.setEnabled(true);
        });
    }

    public MyScanner getMyScanner() {
        return this;
    }
}
