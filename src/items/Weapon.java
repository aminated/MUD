package items;

import model.Living;

/**
 * Weapons can be used on Players and Mobs.
 */
public abstract class Weapon extends Item {
	
	public Weapon(String name, String description, int weight , int usetime) {
		super(name, description, weight,usetime);
		// TODO Auto-generated constructor stub
	}
	public Weapon(){
		
	}


	public String use(Living source){
		return "Weapons need a target to use";
		}


	protected int atk;

	



	
	
	

	public int getAtkdmg() {
		return atk;
	}

	

}
