package com.company.StructureC;
import com.company.Main;

import java.lang.*;

public class MatchmakingServer {
	// JUNIT test for negative rank
	public String FindMatch(int Rank) {

		//Server is calling me to find a match!
		//Searching for player via smart db query that doesn't exists
		//Beeb beep thanks for the data pseudo data base
		String Enemy="Bot1";
		if(Math.abs(Rank-GetRank(Enemy))<100) {
		return Enemy;
		}
		else {
		return "@Error=NoMatch";
		}

	}

	public int GetRank(String Username) {
		int MMR;
		if(Username.equals("Bot1"))
			MMR=1000;
		else
			MMR=Integer.parseInt(Main.GameServer.GetPlayerInfo(0,Username)[2]);
		//TRUE MMR LOGIC HERE IS NOT IMPLANTED. BECAUSE WE ARE NOT MAGICIANS... Super long implantions
		//MMR == Secret internal rank of player that is more dynamic and contain date like trust level, time not played... and it goes on and on for ever with Machine Learning and other stuff you know. Like in any likewise game that respects itself.
		return MMR;
	}

}