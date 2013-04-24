package mob;

import disposition.Hostile;
import items.Item;
import model.Living;
import model.Mob;

public class Troglodyte extends Mob{

	public Troglodyte(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Troglodyte(){
		super("Troglodyte", 30, 5);
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