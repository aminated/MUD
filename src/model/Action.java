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
	protected boolean completed = false;
	protected String result; 
	
	/**
	 * Parse a command and create an action. 
	 */
	public Action(Living source, String command){
		this.source = source;
		Pattern p = Pattern.compile("\\s*(use|on)\\s*", Pattern.CASE_INSENSITIVE);
		String[] args = p.split(command);
		String targetName = args[1];
		System.out.println(targetName);
		if(args.length == 3){
			String toolName = args[2];
		}
		targetName = targetName.replaceAll("\\s", "");
		this.target = source.getRoom().getByName(targetName);
		
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
	
	/**
	 * @return the source
	 */
	public Living getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Living source) {
		this.source = source;
	}
	/**
	 * @return the target
	 */
	public Targetable getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(Targetable target) {
		this.target = target;
	}
	/**
	 * @return the tool
	 */
	public Item getTool() {
		return tool;
	}
	/**
	 * @param tool the tool to set
	 */
	public void setTool(Item tool) {
		this.tool = tool;
	}

	public String describe(){
		if(completed)
			return result;
		else
			return "";
	}
	public void execute(){
		
		if(tool != null){
			completed = true;
			result =  target.useItem(source, tool);
		}
		else{
			completed = true;
			result = target.activate(source);
		}
		System.out.println("In room #" + source.getRoom().hashCode() + ": " + this.describe());

	}
	
}
