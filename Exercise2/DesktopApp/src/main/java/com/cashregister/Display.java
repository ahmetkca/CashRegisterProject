package com.cashregister;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Display extends JPanel implements View, Subscriber{
    static final int minWidth = Configuration.MAIN_WINDOWS_WIDTH;
    static final int minHeight = (int) ((Configuration.MAIN_WINDOWS_WIDTH * (70.0 / 100.0)) / 2.0);

    private JLabel header;
    private JLabel label;

    public Display() {
        init();
    }

    public void init() {
        setSize(new Dimension(minWidth, minHeight));
        setMinimumSize(new Dimension(Display.minWidth, Display.minHeight));
        setUpHeader();
        setUpLabel();
        final GridLayout gl = new GridLayout(2, 1);
//        gl.setVgap(10);
        setLayout(gl);
        add(header);
        add(label);
    }

    public void setUpLabel() {
        label = new JLabel("Please scan barcode to display product info.");
        header.setSize(new Dimension(header.getWidth(),(int) (minHeight * (15.0 / 100.0))));
        Border border = label.getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        label.setBorder(new CompoundBorder(border, margin));
        label.setSize(new Dimension(label.getWidth(),(int) (minHeight * (85.0 / 100.0))));
    }

    public void setUpHeader() {
        header = new JLabel("Product Info");
        Font font = new Font("Courier", Font.BOLD,16);
        header.setFont(font);
    }

    @Override
    public void displayText(String text) {
        label.setText(text);
    }

    @Override
    public void update(String text) {
        displayText(text);
    }

    public Display getDisplay() {
        return this;
    }

}
