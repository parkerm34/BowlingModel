package model;
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

import java.util.ArrayList;


public class BowlingLine implements IBowlingLine {
	
	private int pinsLeft;
	private int hit;
	private int rollsThisFrame;
	private int currentFrame;
	private int score;
	
	private int [] frameScores = new int [10];

	private ArrayList<Frame> List = new ArrayList<Frame>();
	
	private char[][] scoreboard = new char [4][80];
	
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
		setScoreBoard();
		score = 0;
		currentFrame = 0;
		setPins(10);
		initList(); ///////change/////////
		for(int x = 0; x < 10; x++)
			frameScores[x] = -1;
	}
	
	/* Set up the scoreboard
	 * Inputs:
	 * Outputs: a blank scoreboard
	 * 
	 * What: This method creates an empty scoreboard with each number in each
	 * frame. Also, this fills in the word TOTAL in the final frame.
	 */
	private void setScoreBoard()
	{
		for(int colCount = 0; colCount < 80; colCount++)
		{
			if((colCount%7 == 0) && (colCount != 0) && (colCount < 75))
			{
				scoreboard[0][colCount] = '|';
				scoreboard[1][colCount] = '+';
				scoreboard[2][colCount] = '|';
				scoreboard[3][colCount] = '|';
			}
			else
			{
				scoreboard[0][colCount] = ' ';
				scoreboard[1][colCount] = '-';
				scoreboard[2][colCount] = ' ';
				scoreboard[3][colCount] = ' ';
			}
		}
			scoreboard[0][5]  = '1';
			scoreboard[0][12] = '2';
			scoreboard[0][19] = '3';
			scoreboard[0][26] = '4';
			scoreboard[0][33] = '5';
			scoreboard[0][40] = '6';
			scoreboard[0][47] = '7';
			scoreboard[0][54] = '8';
			scoreboard[0][61] = '9';
			scoreboard[0][67] = '1';
			scoreboard[0][68] = '0';
			
			scoreboard[2][75] = 'T';
			scoreboard[2][76] = 'O';
			scoreboard[2][77] = 'T';
			scoreboard[2][78] = 'A';
			scoreboard[2][79] = 'L';
					
			printScoreboard();
	}
	
	public void setFrameFirstBowl(int hit, int currentFrame)
	{
		if(hit == 10)
			scoreboard[2][(7*(currentFrame) + 5)] = 'X';
		else if(hit == 0)
			scoreboard[2][(7*(currentFrame) + 3)] = '-';
		else
		{
			int temp = 48 + hit;
			scoreboard[2][(7*(currentFrame) + 3)] = (char)temp;
		}
	}
	
	public void setFrameSecondBowl(int hit, int currentFrame)
	{
		if(List.get(currentFrame).getHit1() + hit == 10)
			scoreboard[2][(7*(currentFrame) + 5)] = '/';
		else if(hit == 0)
			scoreboard[2][(7*(currentFrame) + 5)] = '-';
		else
		{
			int temp = 48 + hit;
			scoreboard[2][(7*(currentFrame) + 5)] = (char)temp;
		}
	}
	
	public void setLastFrameFirstBowl(int hit, int currentFrame)
	{
		if(hit == 10)
			scoreboard[2][(7*(currentFrame) + 3)] = 'X';
		else if(hit == 0)
			scoreboard[2][(7*(currentFrame) + 3)] = '-';
		else
		{
			int temp = 48 + hit;
			scoreboard[2][(7*(currentFrame) + 3)] = (char)temp;
		}

	}

	public void setLastFrameSecondBowl(int hit, int currentFrame)
	{
		if(hit == 10)
			scoreboard[2][(7*(currentFrame) + 4)] = 'X';
		else if(hit == 0)
			scoreboard[2][(7*(currentFrame) + 4)] = '-';
		else if(List.get(currentFrame).getHit1() + hit == 10)
			scoreboard[2][(7*(currentFrame) + 4)] = '/';
		else
		{
			int temp = 48 + hit;
			scoreboard[2][(7*(currentFrame) + 4)] = (char)temp;
		}
	}

	public void setLastFrameThirdBowl(int hit, int currentFrame)
	{
		if(hit == 10)
			scoreboard[2][(7*(currentFrame) + 5)] = 'X';
		else if(hit == 0)
			scoreboard[2][(7*(currentFrame) + 5)] = '-';
		else if(List.get(currentFrame).getHit2() + hit == 10 && List.get(currentFrame).getHit1() + List.get(currentFrame).getHit2() != 10)
			scoreboard[2][(7*(currentFrame) + 5)] = '/';
		else
		{
			int temp = 48 + hit;
			scoreboard[2][(7*(currentFrame) + 5)] = (char)temp;
		}
		this.currentFrame++;

	}

	private void setScoreboardTotal()
	{
		int temp = score;
		if(this.score >= 0)
			scoreboard[3][78] = (char)(48 + (temp%10));
		if(this.score > 9)
			scoreboard[3][77] = (char)(48 + ((temp/10)%10));
		if(this.score > 99 )
			scoreboard[3][76] = (char)(48 + (((temp/10)/10)%10));
	}
	
	private void setScoreboardFrameScore(int frameNum, int frameScore)
	{
		frameScores[frameNum] = frameScore;
		
		if(frameScore > 0)
			scoreboard[3][(7*(frameNum) + 5)] = (char)(48 + (frameScore%10));
		if(frameScore > 9)
			scoreboard[3][(7*(frameNum) + 4)] = (char)(48 + ((frameScore/10)%10));
		if(frameScore > 99 )
			scoreboard[3][(7*(frameNum) + 3)] = (char)(48 + (((frameScore/10)/10)%10));
	}
	
	/* Print scoreboard function
	 * Inputs: 
	 * Outputs: prints scoreboard
	 * 
	 * This method is a helper function to reduce the code in the
	 * setScorBoard method. This contains 2 for loops to print the
	 * 2D char array
	 */
	public void printScoreboard()
	{
		setScoreboardTotal();
		for(int rowCount = 0; rowCount < 4; rowCount++)
		{
			for(int colCount = 0; colCount < 80; colCount++)
				System.out.print(scoreboard[rowCount][colCount]);
			System.out.println();
		}
	}
	
	private void initList() {
		Frame frame0 = new Frame();
		List.add(frame0);
		Frame frame1 = new Frame();
		List.add(frame1);
		Frame frame2 = new Frame();
		List.add(frame2);
		Frame frame3 = new Frame();
		List.add(frame3);
		Frame frame4 = new Frame();
		List.add(frame4);
		Frame frame5 = new Frame();
		List.add(frame5);
		Frame frame6 = new Frame();
		List.add(frame6);
		Frame frame7 = new Frame();
		List.add(frame7);
		Frame frame8 = new Frame();
		List.add(frame8);
		Frame frame9 = new Frame();
		List.add(frame9);
	}
	
	private void strikeOrSpare() {
		if(pinsLeft == 0) {
			if(rollsThisFrame == 0)
				List.get(currentFrame).setStrike(true);
			else
				List.get(currentFrame).setSpare(true);
		}
	}
	
	
	
	/* Wind up to the bowl
	 * Inputs:
	 * Outputs: 
	 * 
	 * What: This method is the turn repeater. This will make sure the game goes
	 * for 10 frames. This is the same as the walk up or wind up in bowling. This
	 * method then calls for the rollAction method
	 */
	public void rollBall()
	{
			if(rollsThisFrame == 0)	
				setPins(10);
			
			rollAction();
			
			
			if(currentFrame == 9 || currentFrame == 10)
				return;
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
		if(bowlCheck(this.hit))
		{
			System.out.println(invalidMessage);
			return;
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
	
	/* Checks the previous 2 frames for strikes if we're on the first roll of the frame, otherwise checks previous
	 * 1 frame for strike. If strikes are found, it adds the current "downed" value to the total score for
	 * each strike found
	 */
	private void strikeScoreAdjuster(int downed) {
		if(currentFrame != 0 && rollsThisFrame < 2) {
			if(List.get(currentFrame - 1).getStrike()) {
				if(currentFrame == 9 && rollsThisFrame == 1) {
					List.get(8).addAdditionalScore(downed);
					setScoreboardFrameScore(8, frameScores[7] + (List.get(8).getHit1() + 
							List.get(8).getHit2() + List.get(8).getAdditionalScore()));
					
				}
				else if(currentFrame > 1 && rollsThisFrame == 0) {
					if(List.get(currentFrame - 2).getStrike()) {
						List.get(currentFrame - 2).addAdditionalScore(downed);
						this.score = score + downed;
						if(currentFrame == 2)
							setScoreboardFrameScore(0, (List.get(0).getHit1() + 
									List.get(0).getHit2() + List.get(0).getAdditionalScore()));
						else
							setScoreboardFrameScore(currentFrame - 2, (frameScores[currentFrame-3] + List.get(currentFrame - 2).getHit1() + 
								List.get(currentFrame - 2).getHit2() + List.get(currentFrame - 2).getAdditionalScore()));
					}
				}
				List.get(currentFrame - 1).addAdditionalScore(downed);
				this.score = score + downed;
				if(rollsThisFrame == 1 && currentFrame != 9) {
					if(currentFrame == 1)
						setScoreboardFrameScore(0, List.get(0).getHit1() + 
								List.get(0).getHit2() + List.get(0).getAdditionalScore());
					else
						setScoreboardFrameScore(currentFrame - 1, (frameScores[currentFrame-2] + List.get(currentFrame - 1).getHit1() + 
								List.get(currentFrame - 1).getHit2() + List.get(currentFrame - 1).getAdditionalScore()));
				}
			}
		}
	}
	
	/* If we're on the first roll of the frame, checks if the previous frame was a spare.
	 * If it was, then we add the current "downed" value to the total score.
	 */
	private void spareScoreAdjuster(int downed) {
		if(currentFrame != 0 && rollsThisFrame == 0) {
			if(List.get(currentFrame - 1).getSpare()) {
				List.get(currentFrame - 1).addAdditionalScore(downed);
				this.score = score + downed;
				if(currentFrame == 1)
					setScoreboardFrameScore(0, (List.get(0).getHit1() + 
							List.get(0).getHit2() + List.get(0).getAdditionalScore()));
				else
				setScoreboardFrameScore(currentFrame - 1, (frameScores[currentFrame-2] + List.get(currentFrame - 1).getHit1() + 
						List.get(currentFrame - 1).getHit2() + List.get(currentFrame - 1).getAdditionalScore()));
			}
		}
	}
	
	/* Increments the currentFrame and resets the roll count and sets pins back to 10,
	 * unless it's the last frame - then it just sets the pins to 10 and adds to the roll count
	 */
	private void newFrame() {
		//if not last frame
		if(currentFrame != 9) {
			currentFrame++;
			rollsThisFrame = 0;
			setPins(10);
		}
		else {    // if last frame
			setPins(10);
			rollsThisFrame++;
		}
	}
	
	/* Adds to the total score for each bowl, 
	 * 
	 */
	private void score(int downed)
	{
		pinsLeft = pinsLeft - downed;
		strikeScoreAdjuster(downed);
		spareScoreAdjuster(downed);
		this.score = score + downed;
		
		if(currentFrame != 9 || rollsThisFrame < 2)
			strikeOrSpare();
		
		if(rollsThisFrame == 0) {
			if(currentFrame != 9)
				setFrameFirstBowl(this.hit, this.currentFrame);
			else
				setLastFrameFirstBowl(this.hit, this.currentFrame);
			
			List.get(currentFrame).setHit1(downed);
			if(pinsLeft == 0)
				newFrame();
			else
				rollsThisFrame++;
		}
		else if(currentFrame == 9) {
			if(rollsThisFrame == 1)
				setLastFrameSecondBowl(this.hit, this.currentFrame);
			if(rollsThisFrame == 2 && ((List.get(9).getHit1() + List.get(9).getHit2()) >= 10))
			{
				List.get(9).addAdditionalScore(downed);
				setPins(10);
				setLastFrameThirdBowl(this.hit, this.currentFrame);
				rollsThisFrame++;
				
				setScoreboardFrameScore(9, frameScores[8] + (List.get(9).getHit1() + 
						List.get(9).getHit2() + List.get(9).getAdditionalScore()));
				return;
			}
			List.get(currentFrame).setHit2(downed);
			if(( List.get(9).getStrike() || List.get(9).getSpare() ) && rollsThisFrame < 2)
				newFrame();
			else {
				setScoreboardFrameScore(9, frameScores[8] + (List.get(9).getHit1() + 
						List.get(9).getHit2()));
				
				return;
			}	
		}
		else {
			setFrameSecondBowl(downed, currentFrame);
			List.get(currentFrame).setHit2(downed);
			
			if(!List.get(currentFrame).getSpare()) {
				if(currentFrame == 0)
					setScoreboardFrameScore(0, List.get(0).getHit1() + 
							List.get(0).getHit2() + List.get(0).getAdditionalScore());
				else
					setScoreboardFrameScore(currentFrame, frameScores[currentFrame-1] + (List.get(currentFrame).getHit1() + 
							List.get(currentFrame).getHit2() + List.get(currentFrame).getAdditionalScore()));
			}
			newFrame();
		}
		
		return;
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
	
	
	/* Checks to see which frame of the game and how many bowls have been made
	 * and returns a gameover boolean. True for over, False for still going.
	 */
	public boolean gameOver()
	{
		if(this.currentFrame == 10 || (this.currentFrame == 9 && rollsThisFrame == 2 && !(List.get(9).getSpare() || List.get(9).getStrike())))
			return true;
		else if(this.currentFrame == 9)
			if((List.get(9).getHit1() + List.get(9).getHit2() < 10))
				if(List.get(9).getHit2() > 0)
					return true;
		return false;
	}
	
	/* Checks element if score is prepared at the specified frame yet.
	 * Returns boolean before calculating.
	 */
	public boolean canShowScoreFrame(int frame)
	{
		if(frameScores[frame - 1] == -1)
			return false;

		return true;
	}
	
	/* Input: frame number
	 * Output: String of bowls in the specified frame
	 * 
	 * Finds the correct element and strings together the full frame of bowling
	 * available.
	 */
	public String getRollsForFrame(int frame)
	{
		return List.get(frame).getFrameRolls();
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
		return frameScores[frame - 1];
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
			System.out.println("Invalid number of rolls, set to 0");
			setRollsThisFrame(0);
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
	
	public int getHit()
	{
		return this.hit;
	}
	
	public void setHit(int downed)
	{
		this.hit = downed;
	}
	
	public void setScore(int tempScore)
	{
		this.score = tempScore;
	}
	
	public ArrayList<Frame> getList()
	{
		return List;
	}
	
	public char[][] getScoreboard()
	{
		return scoreboard;
	}
}
