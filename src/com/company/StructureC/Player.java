package com.company.StructureC;


import com.company.Main;

public class Player extends Thread{

	private static int PlayerID;
	private static String UserName;
	public static void AccountRequest(String userName) {
		//Request ID > do it
		setUserName(userName);
		setPlayerID(Integer.parseInt(Main.GameServer.GetPlayerInfo(0,UserName)[0]));
		return;
		//throw new UnsupportedOperationException();
	}

	public static int getPlayerID() {
		return PlayerID;
	}

	public static void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public static void setUserName(String userName) {
		UserName = userName;
	}

	public static String getUserName() {
		return UserName;
	}

	public void GameAction() {
		// TODO - implement Player.GameAction
		//Asking server to do all carp
		//Also, Actions have ID (switch case/etc...)
		throw new UnsupportedOperationException();
	}

}