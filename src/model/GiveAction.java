package model;

import items.Item;

public class GiveAction extends Action {
	private Living target; // Targets of give actions must be living. 
	private GiveAction give;
	private GiveAction get;
	private boolean isValid(){
		boolean success = true;
		success &= getSource().getRoom() == target.getRoom();
		success &= getSource().hasItem(getTool());
		return success;
	}
	private boolean canGive(){
		give = getSource().getGiveAction();
		if(give == null ) return false;
		if(give.getTool() != getTool()) return false;
		return true;
	}
	private boolean canGet(){
		get = target.getGetAction();
		if(get.getTool() != getTool()) return false;
		if(get == null) return false;
		return true;
	}
	public GiveAction(Living source, Living target, Item tool) {
		super(source, target, tool);
		// TODO Auto-generated constructor stub
	}
	public String describe(){
		if(completed)
			return getSource().getName() + " gives " 
					+ getTool().getName() + " to " 
				    + target.getName() + "\n";
		else if(!canGive())
			return target.getName() + " asks to get "
			+ getTool().getName() + " from " 
		    + getSource().getName() + "\n";		
		else if(!canGet())
			return getSource().getName() + " asks to give " 
			+ getTool().getName() + " to " 
		    + target.getName() + "\n";
		return "";
	}
	public void execute(){
		if(!isValid()) return;
		if(!canGive()){
			getSource().sendMessage(this);
		}
		if(!canGet()){
			target.sendMessage(this);
		}
		if(canGive() && canGet()){
			getSource().removeItem(getTool());
			target.addItem(getTool());
			getSource().getRoom().announce(this);
		}
	}

}
