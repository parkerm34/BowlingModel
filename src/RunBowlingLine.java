import java.util.Scanner;


public class RunBowlingLine {

	private Scanner rolls = new Scanner(System.in);
	static Scanner bowl = new Scanner(System.in);
	private static int hit;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BowlingLine game1 = new BowlingLine();
		
		while(!(game1.gameOver()))
		{
			enterRoll();
			hit = bowl.nextInt();
			game1.setHit(hit);
			game1.rollBall();
			game1.printScoreboard();
		}
		
		System.out.println("Game Over.");
	}

	/* Quicker command for s.o.p("enter roll: ")
	 */
	private static void enterRoll()
	{
		System.out.print("Enter roll: ");		
	}

}
