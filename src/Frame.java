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
	
	public String getFrameRolls()
	{
		String tempString = new String();
		String tempChar1 = new String();
		String tempChar2 = new String();
		String tempChar3 = new String();
		
		if(hit1 == 10 && hit2 == 10 && additionalScore == 10)
			return "XXX";
		
		if(hit1 == 10)
			return "X  ";
		else if(hit1 > 0)
			tempChar1 = Integer.toString(hit1);
		else if(hit1 == 0)
			tempChar1 = "-";
		
		if(hit1 + hit2 == 10)
			return hit1 + " /";
		else if(hit2 > 0)
			tempChar2 = Integer.toString(hit2);
		else if(hit2 == 0)
			tempChar2 = "-";
		
		if(additionalScore >=0 )
		{
			if(additionalScore > 0)
				tempChar3 = Integer.toString(additionalScore);
			else
				tempChar3 = 
			tempString = tempChar1 + tempChar2 + tempChar3;
		}
		else
			tempString = tempChar1 + " " + tempChar2;
		
		return (tempString);
		
	}
	
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