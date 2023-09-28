package com.company.StructureC;

public class BlockchainT {
	enum Contract {
		Buy,
		List,
		View,
		GetCards
	}
	public Object StandardSmartContract(Contract SignType,String Data) {
		switch(SignType)
		{
			case Buy:
				return true;
				//Imaginary attempt atomic match.

			case List:
				return true;
				//Imaginary attempt atomic match!!!!!!!!!!!!

			case View:
				return true;
				//Imaginary Grab info
			case GetCards:
				return true;
				//Imaginary Grab info
		}
		throw new UnsupportedOperationException();
	}
}