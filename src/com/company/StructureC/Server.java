package com.company.StructureC;

import com.company.Main;

import javax.swing.*;
//SERVER - CLEINT design (Pseudo server, but still!)
public class Server {
	//Server Mange Class (No real server, pseudo returns)
	private DatabaseService DataBase;
	private MatchmakingServer MatchService;
	// User data 1st dimension == title @ 2nd dimension == content
	// i=0 > UserId; i=1 UserName; i=2 UserRank
	BlockchainT JustForShows;

	public Server()
	{
		DataBase = DatabaseService.getInstance(); //Singleton dbs created
		JustForShows = new BlockchainT();
		MatchService = new MatchmakingServer();
	}
	public String[] GetPlayerInfo(int type,String Username) {
		//Type=0 ALL >> Just concept of the function to return different
		//counts of information about the user
		String[] UserData=ReturnPlayerInfo(Username);
		return UserData;
	}

	private String[] ReturnPlayerInfo(String Username) {

		//DATA VIA Username match BEEP BEEP "QUERY MAGIC"
		String info=DataBase.Query("Player Info",0,Username);
		return info.split("@");
		//throw new UnsupportedOperationException();
	}

	public boolean ValidateCaptcha() {
		//Concept function valid at all cases
		//Pesudo Captcha
		return true;
	}

	public boolean Validate(String Username,String Password) {

		String msg;
		msg=Username;
		msg=msg.concat("@");
		msg=msg.concat(Password);
		msg=DataBase.Query("User Login",0,msg);
		if(msg=="Success") return true;
		else return false;
	}

	public String ConfirmRegistration(String Username,String Password) {
		// Check if user exists
		if(Username.toLowerCase().equals("admin")) {

			return "If you try to register admin we send missiles";
		}
		String msg; //Used for multiple uses, just for fun... this is all pseudo Server it is all about the concept =)
		msg=Username;
		msg=msg.concat("@");
		msg=msg.concat(Password);

		msg=DataBase.Query("Register User",0,msg);
	/*	if(msg=="Success")
		{
			//Reg is good!
			//Imaginary function here!
		}
		else
		{
			// REG is bad
			//Imaginary function here!
			//FLAGS FLAGS FLAGS =) Anti bot system ;)
		}*/
		return msg; //Client will popup, other wise it beats the purpose of client-server
		//throw new UnsupportedOperationException();
	}

	private String[] GetCollectionDB(int uid) {
		String CardCollection = DataBase.Query("Grab Collection",uid,null);
		//BEEP BEEP GET COLLECTION FROM "DB"
		String[] arrCollection=CardCollection.split("@");
		return arrCollection;
		//throw new UnsupportedOperationException();
	}

	private void GetCollectionBC() {
		//BEEP BEEP SYNCING COLLECTION FROM "BlockChain"
		//Conceptual
		JustForShows.StandardSmartContract(BlockchainT.Contract.View,null);
		return;
		//throw new UnsupportedOperationException();
	}

	public String[] ReturnCollection(int userId) {
		GetCollectionBC(/*user*/);
		String[] collection=GetCollectionDB(userId);
		//Return what we need
		return collection;
		//throw new UnsupportedOperationException();
	}

	public boolean GetManagementPermission(String password) {

		//Check if admin is real
		String msg=DataBase.Query("Admin Login",0,password);
		if(msg.equals("Success"))
		{
			return true;
		}
		else
			return false;
		//throw new UnsupportedOperationException();
	}

	private String GetOpponent(String Username) {
		// Beep beep connecting to server match
		return MatchService.FindMatch(Integer.parseInt(GetPlayerRank(Username)));
		//throw new UnsupportedOperationException();
	}

	public String GetPlayerRank(String Username) {
		//Beep beep server secure scan(beep)
		return GetPlayerInfo(0,Username)[2];
		//Beep beep getting match
		//throw new UnsupportedOperationException();
	}

	public String MatchPlayers(String Username) {
		// TODO - implement Server.MatchPlayers

		//Beep beep finding appropriate rank vis matchmaking server
		return GetOpponent(Username);
		//throw new UnsupportedOperationException();
	}

	public void Timeout() {
		JOptionPane.showMessageDialog(null, "Connection to server timed out, sending nukes");
		//throw new UnsupportedOperationException();
	}

	public boolean ValidateGameLogic(int logic) {
		//Logic=0 OK; Logic=1 NOT OK
		//Concept function. Game logic will not be implanted
		//Because it would mean de facto manifesting the game and we won't do that for less than a lot of money
		if(logic==0)
			return true;
		else
			return false;
	}

}