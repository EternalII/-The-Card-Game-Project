package com.company;

import com.company.StructureC.CardView;
import com.company.StructureC.CollectionManager;
import com.company.StructureC.DisplayUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CollectionManagerSC extends CardView {
    private JButton button1;
    private JButton button5;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button6;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button8;
    private JButton button7;
    private JButton button12;
    private JPanel panel1;
    //Here for future development

    public JPanel getPanel1() {
        return panel1;
    }

    public CollectionManagerSC() {
        button12.addActionListener(new ActionListener() {
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
    }
}
