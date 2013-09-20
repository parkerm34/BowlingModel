package model;
import java.util.Scanner;


public class RunBowlingLine {

	private Scanner rolls = new Scanner(System.in);
	static Scanner bowl = new Scanner(System.in);
	private static int hit;
	public BowlingLine game1 = new BowlingLine();

	
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
	public RunBowlingLine()
	{
		
	}
	
	public RunBowlingLine(int roll)
	{

		
//		while(!(game1.gameOver()))
//		{
//		if(!game1.gameOver())
//			enterRoll();
//			hit = bowl.nextInt();
//			game1.setHit(2);
//			game1.rollBall();
//			game1.printScoreboard();
			RunBowlingLineUI(roll);
//		}
		
//		System.out.println("Game Over.");
	}

	/* Quicker command for s.o.p("enter roll: ")
	 */
	private static void enterRoll()
	{
		System.out.print("Enter roll: ");		
	}

	public void RunBowlingLineUI(int roll) {
		// TODO Auto-generated method stub
		if(!game1.gameOver())
			enterRoll();
//			hit = bowl.nextInt();
			System.out.println();
			game1.setHit(roll);
			game1.rollBall();
			game1.printScoreboard();
	
	}

}
