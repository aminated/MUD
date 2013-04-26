package mob;


import disposition.Trader;

import model.Mob;

public class Vendor extends Mob{

	public Vendor(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Trader(this));
	}
	public Vendor(){
		super("Vendor", 50, 10, 500);
	}
	
	

}