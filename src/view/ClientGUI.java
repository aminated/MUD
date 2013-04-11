package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @authors Team Dungeon Masters
 * CSC 335
 * Project Manager: Dylan
 *
 */

@SuppressWarnings("serial")
public class ClientGUI extends JFrame{
	
	private JTextField gameInput;
	private JTextArea gameOutput;
	private JTextField chatInput;
	private JTextArea chatOutput;
	private String newLine = "\n";
	private Font plainFont;
	private String gameName = "GAME NAME GOES HERE";
	
	public ClientGUI(){
		layoutGUI();
		registerListeners();
	}

	/**
	 * 
	 */
	private void registerListeners() {
	    InputListener inputListener = new InputListener();
	    gameInput.addActionListener(inputListener);
	    
	    /**
	     * Calls onExit() when JFrame is closed
	     * Source: stackoverflow.com/questions/6084039/create-custom-operation-for-setdefaultcloseoperation
	     */
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
					onExit();
				}});
	}
	
	/**
	 * Notifies the server to save the Player when the JFrame is closed.
	 */
	public void onExit(){
		System.exit(0);
	}
	
	/**
	 * Constructs the GUI
	 */
	private void layoutGUI() {
		// Layout JFrame
		this.setTitle(gameName);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLocation(500, 150);
		
		// Define fonts		
		plainFont = new Font("Courier", Font.PLAIN, 12);
		
		// Sets the look of gameInput
		gameInput = new JTextField();
		gameInput.setFont(plainFont);
		gameInput.setBackground(Color.BLACK);
		gameInput.setForeground(Color.WHITE);
		gameInput.setMaximumSize(new Dimension(800,1));
		
		// Sets the look of gameOutput
		gameOutput = new JTextArea();
		gameOutput.setFont(plainFont);
		gameOutput.setLineWrap(true);
		gameOutput.setEditable(false);
		gameOutput.setBackground(Color.BLACK);
		gameOutput.setForeground(Color.GREEN);
		gameOutput.setText("#######################");
		gameOutput.append(newLine + "# " + gameName + " #" + newLine);
		gameOutput.append("#######################");
		

		// Sets the look of chatInput
		chatInput = new JTextField();
		chatInput.setFont(plainFont);
		chatInput.setBackground(Color.BLACK);
		chatInput.setForeground(Color.WHITE);
		chatInput.setMaximumSize(new Dimension(400,1));
		
		// Sets the look of chatOutput
		chatOutput = new JTextArea();
		chatOutput.setFont(plainFont);
		chatOutput.setLineWrap(true);
		chatOutput.setEditable(false);
		chatOutput.setBackground(Color.BLACK);
		chatOutput.setForeground(Color.GRAY);
		chatOutput.setText("You must login before entering the chat");
		
		JPanel chat = new JPanel();
		chat.add(chatOutput);
		chat.add(chatInput);
		
		// Game Panel (top to bottom layout)
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.PAGE_AXIS));
		gamePanel.add(gameOutput);
		gamePanel.add(gameInput);
		
		// Chat Panel (top to bottom layout)
		JPanel chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.PAGE_AXIS));
		chatPanel.add(chatOutput);
		chatPanel.add(chatInput);		
		
		// Main panel containing both game and chat panels (left to right layout)
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
		mainPanel.add(gamePanel);
		mainPanel.add(Box.createRigidArea(new Dimension(1,0)));	// Filler
		mainPanel.add(chatPanel);
		
		// Add everything to the JFrame and sets it to visible
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	/**
	 * Inner class for listening to events
	 */
	private class InputListener implements ActionListener {
		
		/**
		 *  Called when text is entered in inputField
		 */
		public void actionPerformed(ActionEvent anActionEvent) {

			
		}
	}
	
	/**
	 * Appends outputArea with a String
	 */
	public void appendOutputArea(String string) {
		gameOutput.append(string);
	}	
}
