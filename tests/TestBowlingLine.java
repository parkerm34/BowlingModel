
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;


public class TestBowlingLine {
	
	private BowlingLine game1 = new BowlingLine();
	
	private ByteArrayInputStream in = new ByteArrayInputStream("3\n7\n".getBytes());
	

	@Test
	public void testStartGame()
	{
		assertEquals(game1.getPins(), 7);
	}
	
	@Test
	public void testGetters()
	{
		
	}
}
