package com.company;

import com.company.StructureC.DisplayUI;
import com.company.StructureC.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainDialog extends DisplayUI {
    private JButton ButtonPlay;
    private JPanel panel1;
    private JButton storeButton;
    private JButton collectionMangerButton;
    private JButton socialButton;
    private JButton button1;

    public JPanel getPanel1() {
        return panel1;
    }

    //LISTENERS
    public MainDialog() {
        ButtonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Matcher=Main.GameServer.MatchPlayers(Player.getUserName());
                if(!Matcher.equals("@Error=NoMatch")) //TODO Search players via server.
                {
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    topFrame.setVisible(false);

                    try {
                        GenerateDisplay("GameScreen");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"No match found");

            }
        });
        collectionMangerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        socialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);

                try {
                    GenerateDisplay("SocialScreen");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);

                try {
                    GenerateDisplay("Store");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        collectionMangerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                topFrame.setVisible(false);

                try {
                    GenerateDisplay("CollectionManger");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
