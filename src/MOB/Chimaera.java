package mob;

import disposition.Hostile;
import items.Item;
import model.Living;
import model.Mob;

public class Chimaera extends Mob{

	public Chimaera(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Chimaera(){
		super("CHimaera", 150, 25);
	}
	
	@Override
	public String getDescription() {
		return "Mob \"" + getName() + "\" ("+hp+"/"+base_hp+")";
	}

	@Override
	public String activate(Living source) {
		source.sendMessage("You poke " + getName());
		return source.getName() + " pokes " + getName();
	}

	@Override
	public String useItem(Living source, Item tool) {
		source.sendMessage("You give " + tool.getName() + " to " + getName());
		source.removeItem(tool);
		this.addItem(tool);
		return ""; // Give actions aren't publicly visible. 
	}

}