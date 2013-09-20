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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.RunBowlingLine;

public class BowlingGUI extends JFrame implements ActionListener, ListSelectionListener
{

	  public static void main(String[] args)
	  {
		    new BowlingGUI().setVisible(true);
	  }

	  private JButton rollButton = new JButton("Roll");
	  private JButton newGameButton = new JButton("New Game");
	  private JLabel selectNewNumber = new JLabel("Select a number before clicking roll");
	  private JList rollsHere;
	  private RunBowlingLine game = new RunBowlingLine();
	  private JTextArea scoreSheet = new JTextArea();
	  private DefaultListModel listSelection = new DefaultListModel();

	  
	  private int list = -1;

	  public BowlingGUI()
	  {
		  layoutTheGUI();
		  registerListeners();
		  setBackground(Color.CYAN);
	  }

	  private void layoutTheGUI()
	  {
		  setTitle("Bowling");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		  // TODO: size, locate all the graphical components
		  this.setSize(1000, 400);
		  this.setLocation(100, 50);
		    
		  rollButton.addActionListener(this);
		  newGameButton.addActionListener(this);
		    
		  JPanel panel = new JPanel();
		    		    
		  panel.add(rollButton);
		  panel.add(selectNewNumber);
		  panel.add(newGameButton);
		    
		  this.add(panel, BorderLayout.NORTH);
		    
		    
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
		  
//		  JList rollsHere = new JList(listSelection);
		  rollsHere = new JList(listSelection);
		  rollsHere.setBackground(Color.CYAN);
		  this.add(rollsHere, BorderLayout.WEST);
		    
		  rollsHere.addListSelectionListener(this);
		  rollsHere.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		    		    		 
		  scoreSheet.setFont(new Font("Courier", Font.BOLD, 16));
		  this.add(scoreSheet);
		  
	  }

		  
	  public void actionPerformed(ActionEvent evt)
	  {
		  
		  if(evt.getSource() == rollButton && list != -1 && !(game.game1.gameOver()))
		  {
			  System.out.println(list);
			  game.RunBowlingLineUI(list);
			  list = -1;
			  rollsHere.removeAll();
			  listSelection.removeAllElements();
			  String printer = game.game1.printScoreboard();
			  scoreSheet.setText(printer);
			  for(int x = 0; x < (game.game1.pinsLeftToDown() + 1); x++)
				  listSelection.addElement(x);
		  }
		  else if(evt.getSource() == rollButton && list == -1 && !(game.game1.gameOver()))
			  JOptionPane.showMessageDialog(null, "Select Pins First (0..Max Possible)");
		  else if(evt.getSource() == rollButton && game.game1.gameOver())
			  JOptionPane.showMessageDialog(null,  "Please select new game or close");
		  else if(evt.getSource() == newGameButton)
		  {
			  game = new RunBowlingLine();
			  scoreSheet.setText("");
			  listSelection.removeAllElements();
			  for(int x = 0; x < 11; x++)
				  listSelection.addElement(x);

		  }
	  }
	  
	  private void registerListeners()
	  {
		    
		    // TODO: register both listeners (instances of private inner classes),
		    // the the correct JTextField 
		    
		       
	  }	
		
	  public void valueChanged(ListSelectionEvent selected)
	  {
		  list = rollsHere.getSelectedIndex();
	  }
		 
}
