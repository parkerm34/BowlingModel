package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BowlingGUI extends JFrame implements ActionListener{

	  public static void main(String[] args) {
		    new BowlingGUI().setVisible(true);
		  }

		  private JButton rollButton = new JButton("Roll");
		  private JButton newGameButton = new JButton("New Game");
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
		    
		    rollButton.addActionListener(this);
		    newGameButton.addActionListener(this);
		    
		    JPanel panel = new JPanel();
		    		    
		    panel.add(rollButton);
		    panel.add(selectNewNumber);
		    panel.add(newGameButton);
		    
		    this.add(panel, BorderLayout.NORTH);
		    
		    DefaultListModel listSelection = new DefaultListModel();
		    
		    listSelection.addElement("0");
		    listSelection.addElement("1");
		    listSelection.addElement("2");
		    listSelection.addElement("3");
		    listSelection.addElement("4");
		    listSelection.addElement("5");
		    listSelection.addElement("6");
		    listSelection.addElement("7");
		    listSelection.addElement("8");
		    listSelection.addElement("9");
		    listSelection.addElement("10");
		    
		    JList rollsHere = new JList(listSelection);
		    
		    this.add(rollsHere, BorderLayout.WEST);
		    
		    JTextArea scoreSheet = new JTextArea();
		    
		    this.add(scoreSheet);
		   }

		  
		  public void actionPerformed(ActionEvent evt)
		  {
			  if(evt.getSource() == rollButton)
				  System.out.println("1");
			  else if(evt.getSource() == newGameButton)
				  System.out.println();
		  }
		  
		  private void registerListeners() {
		    
		    // TODO: register both listeners (instances of private inner classes),
		    // the the correct JTextField 
		    
		       
		  }

//		  private class InputListener implements ActionListener {
//			  public void valueChanged()
//			  {
//				  
//			  }
//		  }
		  // TODO: Add the private inner classes that implement ActionListener
		  // and implement the actionPerformed method to do what should be done.
		 
		  
}
