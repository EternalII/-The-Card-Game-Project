package com.company;

import com.company.StructureC.DisplayUI;
import com.company.StructureC.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginScreen extends DisplayUI {
    private JButton buttonLogin;
    private JPanel panel1;
    private JButton buttonReg;
    private JTextField UserName;
    private JPasswordField passwordField1;
    private JButton button1;

    public LoginScreen() {
        buttonReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);
                //Register window
                try {
                    GenerateDisplay("RegisterScreen");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String box;
                String User=UserName.getText();
                String Pass=passwordField1.getText();
                if(User.toLowerCase().equals("admin"))
                {
                    //Admin case
                    if(Main.GameServer.GetManagementPermission(Pass))
                    {
                        JOptionPane.showMessageDialog(null, "Hey admin");
                        //Move to admin controls
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Trying to hack admin? Punk.");
                    }
                    return;
                }
                if(Main.GameServer.Validate(User,Pass))
                {
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    topFrame.setVisible(false);

                    try {
                        GenerateDisplay("MainDialog");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    box="Login successful";
                    Player.AccountRequest(User);
                }
                else
                {
                    box="Login failed";
                }
                JOptionPane.showMessageDialog(null, box);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
 //   public void DesignLogin() throws IOException {
 //    //Here for reference. Problem solved in other means...
 //   }


}
