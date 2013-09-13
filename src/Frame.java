public class Frame {
	private int hit1;
	private int hit2;
	private int additionalScore;
	private boolean strike;
	private boolean spare;
//	private char[] frameScore;
	
	public Frame pevious;
	public Frame next;
	
	public Frame() {
		setHit1(-1);
		setHit2(-1);
		setAdditionalScore(0);
		setStrike(false);
		setSpare(false);
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