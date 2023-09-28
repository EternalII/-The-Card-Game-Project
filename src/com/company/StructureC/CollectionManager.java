package com.company.StructureC;

import com.company.Main;

public class CollectionManager extends DisplayUI {
	protected String[] Collection;
	enum Action{
		load,
		create,
		edit,
		delete
	}
	private void loadCollection()
	{
		Collection=Main.GameServer.ReturnCollection(Player.getPlayerID());
	}

	public void SelectAction(Action act) {
		switch (act)
		{
			case load:
				loadCollection();
		}
		throw new UnsupportedOperationException();
	}

}