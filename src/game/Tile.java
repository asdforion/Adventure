package game;

public enum Tile {
	
	WATER	("~", false),
	GRASS	("M", true);

	private String character;
	private boolean canWalk;
	
	Tile(String character, boolean canWalk){
		this.character = character;
		this.canWalk = canWalk;
	}
	
	@Override
	public String toString(){
		return character;
	}
}
