package com.company;

import com.company.StructureC.DisplayUI;
import com.company.StructureC.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterScreen extends DisplayUI {
    private JTextField UserText;
    private JPasswordField PassText;
    private JButton registerButton;
    private JButton backButton;
    private JPanel panel1;
    private JButton button1;

    public RegisterScreen() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Beep beep checking with server
                String Username = UserText.getText();
                String Password = PassText.getText(); //NO HASH FOR THIS BAD BOY
                String msg;
                msg = Main.GameServer.ConfirmRegistration(Username,Password);
                JOptionPane.showMessageDialog(null,msg);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);
                //Register window
                try {
                    GenerateDisplay("LoginScreen");
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
