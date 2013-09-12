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
	
	private void rollBall()
	{
		if(rollsThisFrame == 0)
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
	
	private void score(int downed)
	{
		pinsLeft = pinsLeft - downed;
		if(rollsThisFrame == 0)
		{
			rollsThisFrame++;
//			rollBall();
			this.score = score + downed;
		}
		else
			this.score = score + downed;
	}
	
	private boolean bowlCheck(int downed)
	{
		if((this.pinsLeft - downed) < 0)
			return true;
		return false;
	}
	
	private void enterRoll()
	{
		System.out.print("Enter roll: ");
		
	}
	
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
		if(bowls > 3 || bowls < 0)
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
}
