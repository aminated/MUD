package controller;
import model.Living;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

public class GameTimer {
	private static int DELAY = 2000; // Delay in milliseconds.
	private List<Living> recipients = new LinkedList<Living>();
	private Timer timer;
	  ActionListener taskPerformer = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	          for(Living creature: recipients){
	        	  creature.getDisposition().doNext();
	          }
	      }
	  };
	  
	public GameTimer() {
		timer = new Timer(DELAY, taskPerformer);
		timer.addActionListener(taskPerformer);
	}
	
	public void start(){
		timer.start();
	}
	
	public void add(Living l){
		recipients.add(l);
	}
	
	public void remove(Living l){
		recipients.remove(l);
	}

}
