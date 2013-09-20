package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BowlingGUI extends JFrame{

	  public static void main(String[] args) {
		    new BowlingGUI().setVisible(true);
		  }

		  private JButton rollLabel = new JButton("Roll");
		  private JButton newGameLabel = new JButton("New Game");
		  private JLabel selectNewNumber = new JLabel("Select a number before clicking roll");

		  public BowlingGUI() {
		    layoutTheGUI();
		    registerListeners();
		    setBackground(Color.CYAN);
		    setFont(new Font("Courier", Font.BOLD, 16));
		  }

		  private void layoutTheGUI() {
		    setTitle("Bowling");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		    // TODO: size, locate all the graphical components
		    this.setSize(700, 200);
		    this.setLocation(100, 50);
		    
		    JPanel panel = new JPanel();
		    		    
		    panel.add(rollLabel);
		    panel.add(selectNewNumber);
		    panel.add(newGameLabel);
		    
		    this.add(panel, BorderLayout.NORTH);
		    
		    JList rollsHere = new JList();
		    
		    
		    
		    this.add(rollsHere, BorderLayout.WEST);
		    
		    JTextArea scoreSheet = new JTextArea();
		    
		    this.add(scoreSheet);
		   }

		  private void registerListeners() {
		    
		    // TODO: register both listeners (instances of private inner classes),
		    // the the correct JTextField 
		    
		       
		  }

//		  private class InputListener implements ActionListener {
//			  public void valueChanged()
//		  }
		  // TODO: Add the private inner classes that implement ActionListener
		  // and implement the actionPerformed method to do what should be done.
		 
		  
}
