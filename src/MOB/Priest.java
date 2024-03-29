package mob;


import disposition.Healer;
import model.Mob;

/**
 * A Priest is a friendly Mob that will heal players in the same room. 
 * 
 */
public class Priest extends Mob{

	public Priest(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Healer(this));
	}
	public Priest(){
		super("Priest",	50, 5, 30);
		setDisposition(new Healer(this));
	}
	
	

	

}
