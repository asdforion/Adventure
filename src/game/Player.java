package game;

public class Player {
	
	int x, y;
	String character = "O";
	
	public Player(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
	
	public Player(){
		
	}
	
	public void setPos(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
}
