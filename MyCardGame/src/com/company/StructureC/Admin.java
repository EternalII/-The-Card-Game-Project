package com.company.StructureC;

import com.company.Main;

import javax.swing.*;

public class Admin {

	private int AdminID;
	private String UserName;
	DatabaseService DBUnit;

	public void LogIn() {
		JOptionPane.showMessageDialog(null, "Welcome to demo version, here the admin is imaginary");
		int AdminID=0; //There's only one boss in this town.
		UserName="Admin";
		//throw new UnsupportedOperationException();
		// Go get server
	}

	public void DisplayData() {
		JOptionPane.showMessageDialog(null, "Data is in the RAM, just analyze the bits");
		DatabaseService DBUnit = DatabaseService.getInstance();
		//throw new UnsupportedOperationException();
		//Pesudo "data from server laying"
	}

	public void DisplayQuery() {
		JOptionPane.showMessageDialog(null, "This function is really a mean to display concept, no real queries on this demo");
		//The Queries are: "Call me I'll talk to the tuples and tell them to change"
		//throw new UnsupportedOperationException();
		//Pesudo "got info server"
	}

}