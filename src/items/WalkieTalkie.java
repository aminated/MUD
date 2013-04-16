package items;

import model.Living;


/**
 * The WalkieTalkie allows the Player to interact in the chat Panel of the GUI.
 * All Players start with a WalkieTalkie. If a Player drops their WalkieTalkie, the
 * chat Panel will be greyed out.
 */
public class WalkieTalkie extends Item{

	

	public WalkieTalkie(String name, String description, int weight) {
		super(name, description, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
