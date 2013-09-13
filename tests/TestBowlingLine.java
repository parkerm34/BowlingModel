
import static org.junit.Assert.*;


import org.junit.Test;


public class TestBowlingLine {
	
	private BowlingLine game1 = new BowlingLine();	
	
	@Test
	public void testGetters()
	{
		game1.setPins(7);
		assertEquals(game1.getPins(), 7);
		
		game1.setCurrentFrame(1);
		assertEquals(game1.getCurrentFrame(), 1);
		
		game1.setHit(3);
		assertEquals(game1.getHit(), 3);
		
		game1.setRollsThisFrame(1);
		assertEquals(game1.getRollsThisFrame(), 1);
		
		game1.setScore(10);
		assertEquals(game1.getScore(), 10);
		assertEquals(game1.totalScore(), 10);
		
		game1.setRollsThisFrame(-1);
		assertEquals(game1.getRollsThisFrame(), 0);

		game1.setRollsThisFrame(5);
		assertEquals(game1.getRollsThisFrame(), 0);
		
		assertNotNull(game1.getScoreboard());
	}
	
	@Test
	public void testIBowlingFunctions()
	{
		game1.setPins(8);
		assertEquals(game1.getPins(), 8);
		
		game1.setHit(2);
		assertEquals(game1.pinsLeftToDown(), 8);
		
		game1.pinsDowned(2);
		assertEquals(2, game1.getHit());
	}
	
	@Test
	public void testGameOver()
	{
		game1.setCurrentFrame(10);
		assertTrue(game1.gameOver());
		
		game1.setCurrentFrame(8);
		assertFalse(game1.gameOver());
		
		game1.setCurrentFrame(9);
		game1.setRollsThisFrame(2);
		assertTrue(game1.gameOver());
		assertNotNull(game1.getList());

		game1.setCurrentFrame(9);
		game1.setRollsThisFrame(1);
		assertFalse(game1.gameOver());
		assertNotNull(game1.getList());

		game1.setCurrentFrame(9);
		game1.setRollsThisFrame(1);
		game1.getList().get(9).setHit1(2);
		game1.getList().get(9).setHit2(2);
		assertTrue(game1.gameOver());
		assertNotNull(game1.getList());

		game1.setCurrentFrame(9);
		game1.setRollsThisFrame(1);
		game1.getList().get(9).setHit1(5);
		game1.getList().get(9).setHit2(5);
		assertFalse(game1.gameOver());
		assertNotNull(game1.getList());

		game1.setCurrentFrame(9);
		game1.setRollsThisFrame(2);
		game1.getList().get(9).setSpare(true);
		game1.getList().get(9).setStrike(true);
		assertFalse(game1.gameOver());
		assertNotNull(game1.getList());

		game1.setCurrentFrame(9);
		game1.setRollsThisFrame(2);
		game1.getList().get(9).setSpare(false);
		game1.getList().get(9).setStrike(true);
		assertFalse(game1.gameOver());
		assertNotNull(game1.getList());
}
	
	@Test
	public void testRollBall()
	{
		game1.setRollsThisFrame(0);
		game1.rollBall();
		assertEquals(game1.getPins(), 10);
		
		game1.setPins(4);
		game1.setRollsThisFrame(1);
		assertEquals(game1.getPins(), 4);
		
		game1.setHit(2);
		game1.setRollsThisFrame(1);
		
		game1.setHit(8);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();


	}
	
	@Test
	public void testScoreboardStrike()
	{
		game1.setFrameFirstBowl(10, 2);
		assertEquals(game1.getScoreboard()[2][19], 'X');
	}
	
	@Test
	public void testGetRollsForFrame()
	{
		game1.getList().get(0).setHit1(2);
		game1.getList().get(0).setHit2(2);
		assertEquals(game1.getRollsForFrame(0), "22");
	}
	
	@Test
	public void testSetFrameBowl()
	{
		game1.setFrameFirstBowl(0, 2);
		game1.setFrameSecondBowl(10, 2);
		assertEquals(game1.getScoreboard()[2][19], '/');
		
		game1.setFrameSecondBowl(0, 2);
		assertEquals(game1.getScoreboard()[2][19], '-');
		
		game1.setFrameFirstBowl(2, 2);
		game1.setFrameSecondBowl(3, 2);
		assertEquals(game1.getScoreboard()[2][19], '3');
	}
	
	
	
	@Test
	public void testSetLastFrameBowl()
	{
		game1.setLastFrameFirstBowl(10, 2);
		assertEquals(game1.getScoreboard()[2][17], 'X');
		
		game1.setLastFrameFirstBowl(0, 2);
		assertEquals(game1.getScoreboard()[2][17], '-');
		
		game1.setLastFrameFirstBowl(3, 2);
		assertEquals(game1.getScoreboard()[2][17], '3');
		
		game1.setLastFrameSecondBowl(10, 2);
		assertEquals(game1.getScoreboard()[2][18], 'X');

		game1.setLastFrameSecondBowl(0, 2);
		assertEquals(game1.getScoreboard()[2][18], '-');

		game1.setLastFrameSecondBowl(3, 2);
		assertEquals(game1.getScoreboard()[2][18], '3');

		game1.setLastFrameThirdBowl(10, 2);
		assertEquals(game1.getScoreboard()[2][19], 'X');

		game1.setLastFrameThirdBowl(0, 2);
		assertEquals(game1.getScoreboard()[2][19], '-');

		game1.setLastFrameThirdBowl(3, 2);
		assertEquals(game1.getScoreboard()[2][19], '3');
	}

	@Test
	public void testScoreboardTotal()
	{
		game1.setScore(53);
		game1.setCurrentFrame(3);
		assertNotSame(game1.getScoreboard()[3][18], '5');

		game1.setScore(0);
		game1.printScoreboard();
		game1.setCurrentFrame(9);
		assertNotSame(game1.getScoreboard()[3][77], '5');
		
		game1.setScore(300);
		game1.printScoreboard();
		
		game1.setScore(-1);
		game1.printScoreboard();
	}
	
	@Test
	public void testLastFrameSecondBowlSpare() 
	{
		game1.getList().get(9).setHit1(6);
		game1.setLastFrameSecondBowl(4, 9);
		assertEquals(game1.getScoreboard()[2][67], '/');
	}

	@Test
	public void testLastFrameSecondBowlSpare2() 
	{
		game1.getList().get(9).setHit1(5);
		game1.setLastFrameSecondBowl(5,9);
		game1.getList().get(9).setHit2(5);
		game1.setLastFrameThirdBowl(5,9);
//		assertNotEquals(game1.getScoreboard()[2][68], '/');
		assertEquals(game1.getScoreboard()[2][68], '5');
		assertEquals(game1.getScoreboard()[2][67], '/');
	}
	
	
	@Test
	public void testLastFrameThirdBowlSpare() 
	{
		game1.getList().get(9).setHit1(10);
		game1.setLastFrameSecondBowl(4,9);
		game1.getList().get(9).setHit2(4);
		game1.setLastFrameThirdBowl(6,9);
//		assertNotEquals(game1.getScoreboard()[2][67], '/');
		assertEquals(game1.getScoreboard()[2][67], '4');
		assertEquals(game1.getScoreboard()[2][68], '/');
	}
	
	@Test
	public void manuallyInputHitsInFullGame()
	{
		game1.getList().get(0).setHit1(5);
		game1.getList().get(0).setHit2(5);
		game1.getList().get(1).setHit1(8);
		game1.getList().get(1).setHit2(2);
		game1.getList().get(2).setHit1(9);
		game1.getList().get(2).setHit2(1);
		game1.getList().get(3).setHit1(9);
		game1.getList().get(3).setHit2(0);
		game1.getList().get(4).setHit1(7);
		game1.getList().get(4).setHit2(1);
		game1.getList().get(5).setHit1(8);
		game1.getList().get(5).setHit2(2);
		game1.getList().get(6).setHit1(10);
		game1.getList().get(7).setHit1(3);
		game1.getList().get(7).setHit2(5);
		game1.getList().get(8).setHit1(10);
		game1.getList().get(9).setHit1(5);
		game1.getList().get(9).setHit2(3);
		assertEquals(game1.getScore(), 0);	
	}//////////////////////change//////////////////////
	
	@Test
	public void testReturnPoints()
	{
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(10);
		game1.rollBall();
		
		game1.setHit(10);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(10);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		assertEquals(game1.getScore(), 180);	
//		
	}
	
	@Test
	public void testFullStrike()
	{
		game1.setHit(10);
		game1.rollBall();
		
		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		game1.setHit(10);
		game1.rollBall();

		assertEquals(game1.getScore(), 300);
	}

	@Test
	public void testFullSpare()
	{
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();
		
		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		game1.setHit(5);
		game1.rollBall();

		game1.setHit(5);
		game1.rollBall();
		
		assertNotSame(game1.getScore(), 300);
	}

	@Test
	public void testFullOne()
	{
		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		game1.setHit(1);
		game1.rollBall();
		game1.setHit(1);
		game1.rollBall();

		assertEquals(game1.getScore(), 20);
	}
	
	@Test
	public void testStrikeNoStrike()
	{
		game1.setHit(10);
		game1.rollBall();
		
		game1.setHit(1);
		game1.rollBall();
		
		game1.setHit(2);
		game1.rollBall();
	}
	
	// rollsThisFrame == 2 && (List.get(9).getHit1() + List.get(9).getHit2() < 10)
	
	@Test
	public void testSpecificRoll()
	{
		game1.getList().get(9).setHit1(5);
		game1.getList().get(9).setHit2(5);
		game1.setRollsThisFrame(2);
		
		game1.getList().get(9).setHit1(5);
		game1.getList().get(9).setHit2(5);
		game1.setRollsThisFrame(1);
		
		game1.getList().get(9).setHit1(3);
		game1.getList().get(9).setHit2(2);
		game1.setRollsThisFrame(2);

		game1.getList().get(9).setHit1(3);
		game1.getList().get(9).setHit2(2);
		game1.setRollsThisFrame(1);
		
		game1.getList().get(9).setHit1(10);
		game1.getList().get(9).setHit2(5);
		game1.setRollsThisFrame(2);
		
	}

	@Test
	public void testFullNone()
	{
		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();
		
		assertFalse(game1.canShowScoreFrame(9));
		assertEquals(game1.scoreAtFrame(3), 0);
		assertTrue(game1.canShowScoreFrame(3));

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		game1.setHit(0);
		game1.rollBall();
		game1.setHit(0);
		game1.rollBall();

		assertEquals(game1.getScore(), 0);
	}
}