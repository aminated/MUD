package mob;


import disposition.Trader;

import model.Mob;

public class Vendor extends Mob{

	public Vendor(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Trader(this));
	}
	public Vendor(){
		super("Vendor", 50, 10);
	}
	
	

}