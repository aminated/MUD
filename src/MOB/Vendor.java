package mob;

import disposition.Neutral;
import items.Item;
import model.Living;
import model.Mob;

public class Vendor extends Mob{

	public Vendor(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Neutral(this));
	}
	public Vendor(){
		super("Vendor", 50, 10);
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