package items;

import model.Living;
import items.Weapon;
/**
 * The baseball Bat is an average melee Weapon.
 */
public class Bat extends Weapon {


	public Bat(String name, String description, int weight , int usetime) {
		super(name, description, weight,usetime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Bat(){
		name="Bat";
		description="The baseball Bat is an average melee Weapon.";
		weight=10;
		usetime=30;
		atk = 5;
	}
	@Override
		public String use(Living source) {
		// TODO Auto-generated method stub
			return null;
		}
	 	
}
