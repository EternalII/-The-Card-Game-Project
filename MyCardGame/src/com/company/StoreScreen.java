package com.company;

import com.company.StructureC.DisplayUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StoreScreen extends DisplayUI {
    private JButton button1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button7;
    private JButton button8;
    private JButton button2;
    private JButton button6;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JTextField textField1;
    private JPanel panel1;
    private JButton buttonBack;

    public StoreScreen() {
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);

                try {
                    GenerateDisplay("MainDialog");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File pic = new File("Resources/Chain_Lightning_Big.png");
                ImageIcon icn = new ImageIcon(pic.getAbsolutePath());
                button9.setIcon(icn);
                textField1.setText("2000$");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
