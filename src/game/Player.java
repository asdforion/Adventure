package game;

public class Player {
	
	static int x, y;
	static String character = "O";
	
	public Player(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
	
	public void setPos(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
	
	public static void findPlayer(){
		Map.arr.get(y).set(x, character);
	}
}
