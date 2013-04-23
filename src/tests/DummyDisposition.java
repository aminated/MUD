package tests;

import model.Action;
import model.Disposition;
import model.Living;
/**
 * Dummy plug: this disposition exposes addAction to enable it to be controlled externally. 
 */
public class DummyDisposition extends Disposition {

	public DummyDisposition(Living owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}
	public void addAction(Action a){
		super.addAction(a);
	}
	@Override
	public void notify(Action event) {
		// Do nothing.
		
	}

	@Override
	public void notify(String message) {
		// Do nothing. 

	}

}
