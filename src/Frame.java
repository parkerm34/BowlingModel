public class Frame {
	private int hit1;
	private int hit2;
	private int additionalScore;
	private boolean strike;
	private boolean spare;
	
	public Frame() {
		setHit1(-1);
		setHit2(-1);
		setAdditionalHit(0);
		setStrike(false);
		setSpare(false);
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
	
	public int getHit1() {
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