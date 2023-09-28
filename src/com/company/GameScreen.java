package com.company;

import com.company.StructureC.DisplayUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameScreen extends DisplayUI {
    private JButton button1;
    private JButton legalActionButton;
    private JButton illegalActionServerWillButton;
    private JPanel panel1;
    private JButton button3;

    public GameScreen() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //P.S I'm not killing hidden windows
                //Simply because this project is NOT ABOUT DOING THINGS PERFECT
                //Clearly those stuff needs to be taken care of in a real complete software
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);
                //Register window
                try {
                    GenerateDisplay("MainDialog");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
