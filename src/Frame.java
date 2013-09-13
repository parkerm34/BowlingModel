public class Frame {
	private int hit1;
	private int hit2;
	private int additionalScore;
	private boolean strike;
	private boolean spare;
	private char[] frameRolls;
	
	public Frame pevious;
	public Frame next;
	
	public Frame() {
		setHit1(0);
		setHit2(0);
		setAdditionalScore(0);
		setStrike(false);
		setSpare(false);
	}
	
//	public String getFrameRolls()
//	{
//		String tempString = new String();
//		char tempChar1 = (char)(48 + hit1);
//		char tempChar2 = (char)(48 + hit2);
//		char tempChar3;
//		if(additionalScore >=0 )
//			tempChar3 = (char)(48 + additionalScore);
//		
//		return ();
//		
//	}
	
	public void addAdditionalScore(int score) {
		additionalScore += score;
	}
	
	public void setHit1(int down) {
		hit1 = down;
	}
	
	public int getHit1() {
		return hit1;
	}
	
	public void setHit2(int down) {
		hit2 = down;
	}
	
	public int getHit2() {
		return hit2;
	}
	
	public void setAdditionalScore(int score) {
		additionalScore = score;
	}
	
	public int getAdditionalScore() {
		return additionalScore;
	}
	
	public void setStrike(boolean bool) {
		strike = bool;
	}
	
	public boolean getStrike() {
		return strike;
	}
	
	public void setSpare(boolean bool) {
		spare = bool;
	}
	
	public boolean getSpare() {
		return spare;
	}	
	
}