package com.company.StructureC;

import com.company.Main;

public class CardView extends CollectionManager {

	private static int CardCount;
	private static String[] Cards;

	public String[] DisplayCollection() {
		//Function fills
		Cards = Main.GameServer.ReturnCollection(Player.getPlayerID());
		//Now you have you have list with the card count for each [I==CardID]

		//Basicly this function's point is to be called from CollectionManger
		//Which EXTENDS this class
		return Cards;
		//Working with UI. displaying cards
		//throw new UnsupportedOperationException();
	}

	public void EnlargeCard() {
		//Concept fucking for getting higher Res image
		//throw new UnsupportedOperationException();
	}

	public void ListCardForSale() {

		//Beep beep send query to server
		//throw new UnsupportedOperationException();
	}

}