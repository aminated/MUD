package model;
import java.util.regex.Pattern;

import items.Item;
/**
 * An action that affects the state of the world, to be executed by a living entity. 
 * For Iteration 1, this is just an activation of a Targetable entity with an optional Item. 
 * An example of the Command design pattern. 
 * @author Andrey Kuklev
 *
 */
public class Action {
	private Living source;
	private Targetable target;
	private Item tool;
	/**
	 * Parse a command and create an action. 
	 */
	public Action(Living source, String command){
		this.source = source;
		Pattern p = Pattern.compile("\\w*(use|on)\\w*", Pattern.CASE_INSENSITIVE);
		String[] args = p.split(command);
		String targetName = args[1];
		if(args.length == 3){
			String toolName = args[2];
		}
		else{
			
		}
	}
	public Action(Living source, Targetable target){
		this.source = source;
		this.target = target;
		this.tool = null;
	}
	public Action(Living source, Targetable target, Item tool){
		this.source = source;
		this.target = target;
		this.tool = tool;
	}
	public String execute(){
		if(tool != null)
			return target.useItem(source, tool);
		else
			return target.activate(source);
	}
	
}
