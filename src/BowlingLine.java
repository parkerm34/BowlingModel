/*
 * Parker Mathewson and Nicholas Pierson
 * 
 * NetID: Parkerm34 and nopierson
 * 
 * University of Arizona, CSc 335, Mercer Fall '13
 * 
 * 9/11/13
 * 
 * File: BowlingLine.java
 * 
 * 
 * Functions
 * +++++++++
 * Public
 * ======
 * BowlingLine()
 * int getPins()
 * int getCurrentFrame()
 * int getRollsThisFrame()
 * int getScore()
 * void setPins(int remain)
 * void setCurrentFrame(int frame)
 * void setRollsThisFrame(int bowls)
 * boolean can ShowScoreFrame(int frame)
 * boolean gameOver()
 * String getRollsForFrame(int frame)
 * void pinsDowned(int pins)
 * int pinsLeftToDown()
 * int scoresAtFrame(int frame)
 * int totalScore()
 * 
 * Private
 * =======
 * void rollBall()
 * void rollAction()
 * void score(int downed)
 * boolean bowlCheck(int downed)
 * void enterRoll()
 * 
 * 
 * Instance Variables
 * ++++++++++++++++++
 * Public
 * ======
 * LAST_FRAME 10
 * 
 * Private
 * =======
 * Scanner rolls
 * Scanner bowl
 * int pinsLeft
 * int hit
 * int rollsThisFrame
 * int currentFrame
 * int score
 * 
 * String invalidMessage = "Invalid roll, try again"
 * 
 * ---------------------------------------------------------------
 * 
 * This file is the main brain of the Bowling Model.
 * This is where the methods will be kept that calculate the score during the whole game.
 * Keeping score consists of which frame the bowler is in, what their total score is,
 * which ball they are on in the frame, how many pins they have left in the current frame,
 * and counts the strikes and spares in their legal ways in bowling rules. 
 * 
 * X represents a strike
 * / represents a spare
 * - represents a gutter ball
 * 
 */

import java.util.Scanner;


public class BowlingLine {

	private Scanner rolls = new Scanner(System.in);
	private Scanner bowl = new Scanner(System.in);
	
	private int pinsLeft;
	private int hit;
	private int rollsThisFrame;
	private int currentFrame;
	private int score;
	
	private static final String invalidMessage = "Invalid roll, try again";
	
	/* Constructor for BowlingLine
	 * Inputs: 
	 * Outputs: game ending score.
	 * 
	 * What: This method initiates the whole game. It initially sets the score to 0
	 * and sets the current frame to 1. Then, as if the machines came down, 10 pins
	 * are sat nicely on the lane. The player bowls, the computer counts the pins
	 * knocked down and compares them to make sure they arent bowling more pins
	 * then there are standing. There is an error message if players are trying to
	 * cheat. The bowl then gets scored and passed on to the rest of the game.
	 */
	public BowlingLine()
	{
		score = 0;
		currentFrame = 1;
		setPins(10);
		enterRoll();
		this.hit = this.bowl.nextInt();
		if(bowlCheck(this.hit))
		{
			System.out.println(invalidMessage);
			rollBall();
		}
		else
			score(this.hit);
	}
	
	/* Wind up to the bowl
	 * Inputs:
	 * Outputs: 
	 * 
	 * What: This method is the turn repeater. This will make sure the game goes
	 * for 10 frames. This is the same as the walk up or wind up in bowling. This
	 * method then calls for the rollAction method
	 */
	private void rollBall()
	{
		while(currentFrame <= 10)
		{
			if(rollsThisFrame == 0)	
				setPins(10);
			rollAction();
			if(currentFrame < 10)
				rollAction();
		}
	}
	
	/* Action of throwing the ball
	 * Inputs:
	 * Outputs:
	 * 
	 * What: This method is the throwing of the ball, first, it asks the user
	 * for input on what they rolled and checks to how many pins are left. 
	 * Once a correct roll has happened, the knocked over pins will get added
	 * to the score instance variable in the correct manner.
	 */
	private void rollAction()
	{
		enterRoll();
		this.hit = this.bowl.nextInt();
		if(bowlCheck(this.hit))
		{
			System.out.println(invalidMessage);
			rollBall();
		}
		else
			score(this.hit);
	}
	
	/* Computer updating action
	 * Input: pins hit over by the bowl
	 * Output:
	 * 
	 * What: This method is what the computer will be calculating while
	 * the ball is respawning. First, the method will take the number of
	 * total pins and subtract the number hit over from the remaining.
	 * The method will check to see which bowl in the frame it was, and
	 * score accordingly:
	 * 1st bowl of any frame, hitting over 10 is a strike
	 * 2nd bowl of any frame, hitting over a total of 10 is a spare
	 * 
	 * A strike adds the next 2 bowls to the frame where a strike was achieved
	 * A spare adds the next bowl to the fram where a spare was achieved
	 */
	private void score(int downed)
	{
		pinsLeft = pinsLeft - downed;
		if(rollsThisFrame == 0)
		{
			rollsThisFrame++;
			this.score = score + downed;
			rollBall();
		}
//		else if(rollsThisFrame == 1 && this.currentFrame == 10)
//		{
//			rollsThisFrame++;
//			this.score = score + downed;
//		}
		else
		{
			currentFrame++;
			setPins(10);
			rollsThisFrame = 0;
			this.score = score + downed;
			System.out.println("Total Score in frame " + (currentFrame - 1) + " is " + getScore());
		}
	}
	
	/* Quick method in which a check for "knocking over more pins
	 * than are up." Gotta prevent them cheaters!
	 */
	private boolean bowlCheck(int downed)
	{
		if((this.pinsLeft - downed) < 0)
			return true;
		return false;
	}
	
	/* Quicker command for s.o.p("enter roll: ")
	 */
	private void enterRoll()
	{
		System.out.print("Enter roll: ");	
	}
	
	/* Checks to see which frame of the game and how many bowls have been made
	 * and returns a gameover boolean. True for over, False for still going.
	 */
	public boolean gameOver()
	{
		return false;
	}
	
	/* Checks element if score is prepared at the specified frame yet.
	 * Returns boolean before calculating.
	 */
	public boolean canShowScoreFrame(int frame)
	{
		return false;
	}
	
	/* Input: frame number
	 * Output: String of bowls in the specified frame
	 * 
	 * Finds the correct element and strings together the full frame of bowling
	 * available.
	 */
	public String getRollsForFrame(int frame)
	{
		return "   ";
		// temp "no bowls yet"
	}
	
	/* A single bowl from the user. This is after the keyboard has been scanned
	 * in. This just adds the pins knocked over, assuming the possibility
	 * has already been accepted.
	 */
	public void pinsDowned(int pins)
	{
		score(pins);
	}
	
	/* A quick method just to return how many pins are left on the lane.
	 */
	public int pinsLeftToDown()
	{
		return pinsLeft;
	}
	
	/* TEMPORARILY RETURNING TOTAL SCORE
	 * 
	 * This method returns a score that is calculated at that point in the requested
	 * frame. This can be anywhere between frame 1-10 at any time.
	 */
	public int scoreAtFrame(int frame)
	{
		//TODO
		return this.score;
	}
	
	/* This returns the total score that can be calculated thus far into the game.
	 * This will be in the instance variable this.score during the whole game,
	 * keeping a rolling score.
	 */
	public int totalScore()
	{
		return this.score;
	}
	/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*                                 Setters and Getters                                         */
	/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void setPins(int remain)
	{
		this.pinsLeft = remain;
	}
	
	public int getPins()
	{
		return this.pinsLeft;
	}
	
	public void setCurrentFrame(int frame)
	{
		this.currentFrame = frame;
	}
	
	public int getCurrentFrame()
	{
		return this.currentFrame;
	}
	
	public void setRollsThisFrame(int bowls)
	{
		if(bowls > 2 || bowls < 0)
		{
			System.out.println("Invalid number of rolls, please correct: ");
			setRollsThisFrame(this.rolls.nextInt());
		}
		else
			this.rollsThisFrame = bowls;
	}
	
	public int getRollsThisFrame()
	{
		return this.rollsThisFrame;
	}
	
	public int getScore()
	{
		return this.score;
	}
}
