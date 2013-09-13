
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;


public class TestBowlingLine {
	
	private BowlingLine game1 = new BowlingLine();	

//	@Test
//	public void testStartGame()
//	{
//		BowlingLine game1 = new BowlingLine();
//		System.setIn(in);
//		assertEquals(game1.getPins(), 7);
//	}
	
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
	}
	
	@Test
	public void testScoreboardStrike()
	{
		game1.setFrameFirstBowl(10, 2);
		assertEquals(game1.getScoreboard()[2][19], 'X');
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
		assertEquals(game1.getScoreboard()[3][18], '5');
	}
}
