package game;
import java.util.Scanner;

public class Game {


	static Scanner scan = new Scanner(System.in);
	static Player player = new Player(0,0);

	public static void main(String[] args) 
	{
		String input = "";
		Map.setGrid();

		while(true){


			Map.printGrid();

			input = scan.next();
			if(input.equals("e"))
				break;
			else if(input.equals("n"))
				Map.setGrid();
			else if(input.equals("sm"))
				Map.smoothenGrid();
			else if(input.charAt(0) == 'p'){
				Map.percentageFilled = Integer.parseInt(input.substring(1, input.length()));
				Map.setGrid();}
			else if(input.equals("start"))
				placePlayer();
			else if(input.equals("w"))
				movePlayer("up");
			else if(input.equals("a"))
				movePlayer("left");
			else if(input.equals("s"))
				movePlayer("down");
			else if(input.equals("d"))
				movePlayer("right");


		}
	}

	public static void placePlayer(){
		while(true){
			int yVal = Map.rand.nextInt(Map.height);
			int xVal = Map.rand.nextInt(Map.width);
			if(Map.arr.get(yVal).get(xVal).equals(Map.charLand)){
				player.setPos(xVal, yVal);
				break;
			}

		}
		Player.findPlayer();

	}

	public static void wipeConsole(){
		for(int i = 0; i < Map.height + 1; i++)
		{
			System.out.println("\n");
		}
	}

	public static void movePlayer(String input){
		if(input.equals("up")){
			if ( Map.arr.get(player.y - 1).get(player.x) == Map.charLand ){
				removePlayerChar();
				player.setPos(player.x, player.y - 1);
				player.findPlayer();
				Map.printGrid();
			}
		}
		else if(input.equals("left")){
			if ( Map.arr.get(player.y).get(player.x - 1) == Map.charLand ){
				removePlayerChar();
				player.setPos(player.x - 1, player.y);
				player.findPlayer();
				Map.printGrid();
			}
		}
		else if(input.equals("right")){
			if ( Map.arr.get(player.y).get(player.x + 1) == Map.charLand ){
				removePlayerChar();
				player.setPos(player.x + 1, player.y);
				player.findPlayer();
				Map.printGrid();
			}
		}
		else if(input.equals("down")){
			if ( Map.arr.get(player.y + 1).get(player.x) == Map.charLand ){
				removePlayerChar();
				player.setPos(player.x, player.y + 1);
				player.findPlayer();
				Map.printGrid();
			}
		}

	}

	public static void removePlayerChar(){
		Map.arr.get(player.y).set(player.x, Map.charLand);
	}

}
