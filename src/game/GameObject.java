package game;

public enum GameObject {
	
	PLAYER	("P", false),
	ROCK	("r", false);
 
	private String character;
	private boolean canWalk;
	
	GameObject(String character, boolean canWalk){
		this.character = character;
		this.canWalk = canWalk;
	}
	
	@Override
	public String toString(){
		return character;
	}
}
