package mob;


import items.Item;
import items.Weapon;
import disposition.Trader;

import model.Living;
import model.Mob;

public class Vendor extends Mob{

	public Vendor(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Trader(this));
	}
	public Vendor(){
		super("Vendor", 50, 10, 500);
		setDisposition(new Trader(this));
	}
	@Override
	public String getDescription() {
		return "Vendor \"" + getName() + "\" ("+hp+"/"+base_hp+")";
	}

	@Override
	public String activate(Living source) {
		source.sendMessage("You poke " + getName());
		String itemlist="";
		for(Item thing: getItems()){
			itemlist = itemlist  + " " + thing;
		}
		source.sendMessage("I have" + itemlist);
		return "";
	}

	@Override
	public String useItem(Living source, Item tool) {
			source.sendMessage("You sell " + tool.getName() + " to " + getName());
			source.removeItem(tool);
			this.addItem(tool);
			source.addMoney(tool.getValue());
			return ""; // Give actions aren't publicly visible. 
		
	}
	

}