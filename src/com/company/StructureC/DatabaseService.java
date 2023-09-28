package com.company.StructureC;

import java.util.ArrayList;
import java.util.List;

//PEDUDO DATA BASE WITH DATA WE NEED
//I CAN DO A REAL DATABASE BUT THERE'S NO POINT THIS ISN'T A JAVA COURSE(Nor DB course)
//NOR THIS IS A NETWORK OR A GAME DEVELOPMENT COURSE
//IT IS ALL ABOUT THE SOFTWARE DESIGN HERE AND ABSTRACT OF THE SOFTWARE!
public class DatabaseService {
	//ARRs are FAKE database info. Implementing as naive.
	private String[][] UserTable = new String[100][3]; // i IS UserId, j=0 UserName; j=1 Password j=2 UserRank
	private String AdminPassword="this123"; // You know this is pseudo database... =)
	private String[] Cards = new String[100]; // i IS CARD-ID, Content == IMAGE ABS PATH!!!
	private String[][] CardOwnership = new String[100][100]; // I IS user ID, j IS card id. Content is count our how much of that card the user owns
	private String[][][] DECKS = new String[100][5][30]; // 1st I IS user id,2nd j is DECK ID, J.CONTENT is CARD ID.
	//"Player decks table"


	//Singelton desgin on this class!
	private static DatabaseService single_instance = null;

	private DatabaseService()
	{
		int i,j;

		for(i=0;i<100;i++)
		{

			UserTable[i][0]="@"; //@ Means no user(Username can't contain @)(This is just for shows anyway <3 But still respectable for a fake database)
			for (j = 0; j < 100; j++) {
				CardOwnership[i][j]="1"; //Everyone gets 1 card of each just out of the blue
			}
		}
		// TODO init some cards with abs image source
	}
	public static DatabaseService getInstance()
	{
		if (single_instance == null)
			single_instance = new DatabaseService();

		return single_instance;
	}
	public String Response(int id) {
		// TODO - implement DatabaseService.Response

		//Responding
		switch (id)
		{
			case -1:
				return "Success";
			case 0:
				return "User Exists";
			case 1:
				return "Wrong Password";
			case 2:
				return "User doesn't exist";
			case 3:
				return "Only 5 decks allowed";
		}
		throw new UnsupportedOperationException();
	}

	public String Query(String requesting,int Id,String Data) {
		// TODO - implement DatabaseService.Query
		// id=0 REG;
		//Init query (Pseudo)
		//MAGIC APPLYEING QUERY TO DATA BASE
		//(Pesudo action taking)
		if(requesting=="Admin Login")
		{
			if(Data.equals(AdminPassword))
			{
				return Response(-1);
			}
			else
				return Response(1);
		}
		else if(requesting=="User Login")
		{
			//Does UserName match password?
			String[] userVpass = Data.split("@");
			for (String[] User:UserTable)
			{
				if(User[0].toLowerCase().equals(userVpass[0].toLowerCase()))
				{
					if(User[1].equals(userVpass[1]))
						return Response(-1);
					else
						return Response(1);
				}
			}
			return Response(2);
		}
		else if(requesting=="Grab Collection") //BlockChain grab on server. this is DB grab
		{
			String result="";
			int i=0;
			for (String CardCount:
					CardOwnership[Id]) {
				result=result.concat(CardCount);
				if(i!=99) result=result.concat("@"); //Naive, it's just to move the gears, real smart coding of the arch' would be  time consuming to have it in the form we have it as.
				i++; //Just not concating the last "@", this really is just a naive solution instead of burning time over Mountains of code
			}
			return result;
		}
		else if(requesting=="Register User") //Everything in this fake database is naive.
		{
			String[] userVpass = Data.split("@");
			int i=0;
			for (String[] User:UserTable) {
				if(User[0]=="@")
				{
					//Register Here
					User[0]=userVpass[0];
					User[1]=userVpass[1];
					User[2]="1000"; //Base mmr rank is 1000, it's all for shows ;)

					DECKS[i][0][0]="@"; //Means that deck is empty
					//Yay! We did it == -1
					return Response(-1);
				}
				else if(User[0].toLowerCase().equals(userVpass[0].toLowerCase()))
				{
					//User Exists;
					return Response(0);
				}
				i++;
			}
			// Error! if you reach this place (No more place)
			// You will hit Exception
		}
		else if(requesting=="Player Info")
		{
			int i=0;
			for (String[] User:UserTable) {
				if(Data.toLowerCase().equals(User[0].toLowerCase()))
				{
					// i IS UserId, j=0 UserName; j=1 Password j=2 UserRank
					String info;
					info = String.valueOf(i);
					info=info.concat("@");
					info=info.concat(User[0]);
					info=info.concat("@");
					info=info.concat(User[2]);
					return info;
				}
				i++;
			}
			return "-1@-1@-1"; //error
		}
		else if(requesting=="CardImage")
		{
			return Cards[Id];
		}
		else if(requesting=="CreateDeck") //Id is USER ID!!! UNLESS SAID DIFFERENT
		{
			if(DECKS[Id][5][0]!="@")
				return Response(3);
			else{
				for (int i=0;i<5;i++){
					if(DECKS[Id][i][0]=="@")
					{
						for(int j=0;j<30;j++) {
							DECKS[Id][i][j] = "-1"; //EmptyDeck created
						}
						return Response(-1);
					}

				}
			}
		}
		else if(requesting=="GetDeck") //Id HERE IS DECK ID and DATA IS USER ID! CAREFUL WHEN CALLING THIS REQUEST
		{
			String Dck="";
			for(int i=0;i<30;i++) {
				Dck = Dck.concat(DECKS[Integer.parseInt(Data)][Id][i]);
				if(i!=29)
					Dck.concat("@");
			}
			return Dck;
		}
		throw new UnsupportedOperationException();
	}

}