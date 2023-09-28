package com.company;

import com.company.StructureC.DisplayUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SocialScreen extends DisplayUI {
    private JTextField ChatField;
    private JButton buttonSend;
    private JButton buttonBack;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;

    public SocialScreen() {
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
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Type massage
                ChatField.setText(ChatField.getText()+"Thank you for trying our demo! ");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
