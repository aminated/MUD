package disposition;

import java.util.LinkedList;
import java.util.List;

import items.Item;
import model.Action;
import model.GiveAction;
import model.Living;

public class Trader extends Neutral {
	private class price{
		public Item item;
		public int cost;
	}
	private List<price> inventory = new LinkedList<price>();
	public Trader(Living owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}
	public void notify(Action event){
		if(! (event instanceof GiveAction)){
			super.notify(event); return;
		}
		GiveAction trade = (GiveAction) event;
		
	}

}
