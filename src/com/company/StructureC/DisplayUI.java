package com.company.StructureC;

import com.company.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class DisplayUI extends UserInterface {

	private Object[] WindowDialog;

	public void GenerateDisplay(String display) throws IOException {
		// TODO - implement DisplayUI.GenerateDisplay

		// BEEP BEEP KEEP CONNECTION WITH SERVER THREAD BEEP BEEP (No real server)

		//Manges UI logic wise
		//Call login from
		JFrame FrameDis;
		DisplayUI ScreenDis;
		JPanel PanDis;
		switch (display) {
			case "LoginScreen": {
				FrameDis = new JFrame(display);
				ScreenDis = (DisplayUI)new LoginScreen();
				PanDis = ((LoginScreen)ScreenDis).getPanel1();
				break;
			}
			case "RegisterScreen": {
				FrameDis = new JFrame(display);
				ScreenDis = (DisplayUI) new RegisterScreen();
				PanDis = ((RegisterScreen) ScreenDis).getPanel1();
				break;
			}
			case "MainDialog": {
				FrameDis = new JFrame(display);
				ScreenDis = (DisplayUI)new MainDialog();
				PanDis = ((MainDialog)ScreenDis).getPanel1();
				break;
			}
			case "GameScreen": {
				FrameDis = new JFrame(display);
				ScreenDis = (DisplayUI)new GameScreen();
				PanDis = ((GameScreen)ScreenDis).getPanel1();
				break;
			}
			case "SocialScreen": {
				FrameDis = new JFrame(display);
				ScreenDis = (DisplayUI)new SocialScreen();
				PanDis = ((SocialScreen)ScreenDis).getPanel1();
				break;
			}
			default:
				throw new IllegalStateException("Unexpected value: " + display);
		}
		if(FrameDis!=null) FrameDis.setContentPane(PanDis);
		FrameDis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameDis.pack();
		FrameDis.setVisible(true);


	}

}