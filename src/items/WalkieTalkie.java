package items;

import model.Living;

/**
 * The WalkieTalkie allows the Player to interact in the chat Panel of the GUI.
 * All Players start with a WalkieTalkie. If a Player drops their WalkieTalkie,
 * the chat Panel will be greyed out.
 */
public class WalkieTalkie extends Item {

	public WalkieTalkie() {
		// TODO Auto-generated constructor stub
		name = "WalkieTalkie";
		description = "The WalkieTalkie allows the Player to interact in the chat Panel. If a Player drops their WalkieTalkie, the chat Panel will be greyed out.";
		weight = 5;
		value = 10;
	}

	// interact in the chat Panel
	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub

		return "Connecting to chat.";
	}

}
