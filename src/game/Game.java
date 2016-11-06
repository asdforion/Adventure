package game;
import java.util.Random;
import java.util.Scanner;

public class Game
{
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	static Game game;

	Player player;
	Map map;

	public Game(Map map)
	{
		this.map = map;
	}

	public void placePlayer()
	{
		while(true)
		{
			int yVal = rand.nextInt(map.height);
			int xVal = rand.nextInt(map.width);
			if(map.grid[yVal][xVal].equals(Tile.GRASS))
			{
				player.setPos(xVal, yVal);
				return;
			}
		}
	}

	public static void wipeConsole()
	{
		for(int i = 0; i < 20; i++)
		{
			System.out.println("\n");
		}
	}

	public static void main(String[] args) 
	{
		game = new Game(new Map(45,126));
		game.map.setProceduralMap(1, 56);
		game.map.smoothenGrid(4);
		game.map.printGrid();
			
	}

}
