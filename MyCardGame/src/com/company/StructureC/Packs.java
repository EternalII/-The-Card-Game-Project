package com.company.StructureC;

public class Packs extends CollectionManager {

	private int[] PackID;

	public boolean OpenPack(int Id) {
		// TODO - implement Packs.OpenPack
		
		//Naive loop. Real implatation would binnary search
		for(int pid : PackID)
		{
			if(pid==Id){
				//Blockchain magic
				return true;}
		}
		return false; //Pack not found
	}

}