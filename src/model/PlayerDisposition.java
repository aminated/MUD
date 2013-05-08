package model;

import items.Item;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import controller.Stream;
import disposition.Disposition;

public class PlayerDisposition extends Disposition{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5327640191565083269L;
	private ClientConnection listener;
	private class ClientConnection extends Thread{
		public ObjectInputStream istream;
		public ObjectOutputStream ostream;
		public void run(){
			while(true){
				try {
					ostream.writeObject(">");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String command = "";
				try {
					command = (String) istream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Handle dropped connection.
					e.printStackTrace();
				}
				CommandParser parser = null;
				for(CommandParser candidate : commands){
					if(candidate.matches(command))
						parser = candidate;
				}
				if(parser == null){
					puts("Command not found. \n");
				}
				else{
					parser.invoke();
				}
				/*
				if(command.equals("look"))
					puts(owner.getRoom().describe());
				else
					queue.add(new Action(owner, command));
					*/
			}
		}
		public void puts(String message){
			try {
				ostream.writeObject(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private List<CommandParser> commands = new LinkedList<CommandParser>();
	private abstract class CommandParser implements Cloneable {
		public String regex;
		public String command;
		public String[] args;
		/**
		 * Split a command into a unix-style arg array. 
		 * @param command
		 * @return
		 */
		public CommandParser(String regex){
			this.regex = regex;
		}
		private String[] split(String command){ 
			Pattern p = Pattern.compile("\\s+((on|go|at|to|from)\\s+)?", Pattern.CASE_INSENSITIVE);
			String[] args = p.split(command);
			if(args[0].equals("")) args = Arrays.copyOfRange(args, 1, args.length);
			return args;
		}
		public CommandParser clone(){
			CommandParser copy = null;
			try {
				copy = (CommandParser) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return copy;
		}

		public CommandParser rename(String newName){
			CommandParser copy = this.clone();
			copy.regex = newName;
			return copy;
		}
		public boolean matches(String command){
			Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			String[] args = split(command);
			if(p.matcher(args[0]).matches()){
				this.args = args;
				this.command = command;
				return true;
			}
			else return false;
		}
		public abstract void invoke();
	}
	private void addCommands(){
		CommandParser cmdInventory = new CommandParser("inventory"){
			public void invoke(){
				String output = "Inventory: \n";
				for(Item i: owner.getItems()) 
					output += i.getName() + ": " + i.getDescription() + "\n";
				listener.puts(output);
			}
		};
		commands.add(cmdInventory);
		CommandParser cmdMove = new CommandParser("(north|south|east|west)"){
			private String capitalize(String string){
				char[] charArray = string.toCharArray();
				charArray[0] = Character.toUpperCase(charArray[0]);
				return new String(charArray);
			}
			public void invoke(){
				String dir = capitalize(args[0]);
				String doorName = dir + "-door";
				addAction(new Action(owner, "use " + doorName));
			}
		};
		commands.add(cmdMove);
		CommandParser cmdLook = new CommandParser("look"){
			public void invoke(){
				if(args.length == 1)
					listener.puts(owner.getRoom().describe());
				// TODO: Implement Look command taking arguments. 
			}
		};
		commands.add(cmdLook);
		CommandParser cmdUse = new CommandParser("use"){
			public void invoke(){
				// Pass off to Action
				// TODO: Handle different types of "use" so we don't parse things twice. 
				// Leave that for refactoring.
				queue.add(new Action(owner, command));
			}
		};
		commands.add(cmdUse);
		
		CommandParser cmdSay = new CommandParser("say"){
			public void invoke(){
				String message = command.substring(4);
				owner.getRoom().announce(owner.getName() + " says: " + message);
			}
		};
		commands.add(cmdSay);
		
		CommandParser cmdTell = new CommandParser("tell"){
			public void invoke(){
				String targetName = args[1];
				Targetable target = owner.getRoom().getByName(targetName);
				if(!(target instanceof Living)){
					listener.puts(target.getName() + " isn't alive! \n");
					return;
				}
				Living receiver = (Living) target;
				String message = command.substring(targetName.length() + 4);
				receiver.sendMessage(message);
			}
		};
		commands.add(cmdTell);
		
		CommandParser cmdDrop = new CommandParser("drop"){
			public void invoke(){
				String itemName = args[1];
				Item item = owner.getItem(itemName);
				owner.getRoom().add(item);
				owner.removeItem(item);
				owner.getRoom().announce(owner.getName()+" drops "+ item.getName()+".\n");
			}
		};
		commands.add(cmdDrop);
		
		CommandParser cmdGive = new CommandParser("give"){
			public void invoke(){
				String targetName = args[2];
				String itemName = args[1];
				Targetable target = owner.getRoom().getByName(targetName);
				Item item = owner.getItem(itemName);
				if(!(target instanceof Living)){
					listener.puts(target.getName() + " isn't alive! \n");
					return;
				}
				Living receiver = (Living) target;
				GiveAction action = new GiveAction(owner, receiver, item);
				owner.setGiveAction(action);
				addAction(action);
			}
		};
		commands.add(cmdGive);
		
		CommandParser cmdGet = new CommandParser("get"){
			public void invoke(){
				String sourceName = args[2];
				String itemName = args[1];
				Targetable source = owner.getRoom().getByName(sourceName);
				Item item = owner.getItem(itemName);
				if(!(source instanceof Living)){
					listener.puts(source.getName() + " isn't alive! \n");
					return;
				}
				Living giver = (Living) source;
				GiveAction action = new GiveAction(giver, owner, item);
				owner.setGiveAction(action);
				addAction(action);
			}
		};
		commands.add(cmdGet);
		
	}
	public PlayerDisposition(Stream client, Player player){
		super(player);
		
		addCommands();
		this.listener = new ClientConnection();
		listener.istream =  client.in ;
		listener.ostream =  client.out ;
		listener.start();
	}
	@Override
	public void notify(Action event) {
		
		listener.puts(event.describe() + "\n");
	}
	@Override
	public void notify(String message) {
		listener.puts(message+ "\n");
	}

}
