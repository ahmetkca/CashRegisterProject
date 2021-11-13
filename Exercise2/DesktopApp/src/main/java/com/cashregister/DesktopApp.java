package com.cashregister;

import javax.swing.*;
import java.awt.*;

public class DesktopApp extends JFrame {
    static String appName;
    private CashRegister cashRegister;

    public DesktopApp() {
        super(appName);
        appName = CommonUtility.getAppName();
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        Display display = new Display();
        cashRegister = new CashRegister();
        cashRegister.subscribe(display);
        MyScanner myScanner = new MyScanner(cashRegister);
        add(myScanner, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Configuration.MAIN_WINDOWS_WIDTH, Configuration.MAIN_WINDOWS_HEIGHT);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DesktopApp().setVisible(true));
    }
}
