package game;
import java.util.ArrayList;
import java.util.Random;


public class Map
{
	//Settings
	final int width;
	final int height;
	final int percentageFilled = 45;
	final int smoothFactor;
	final int borderWidth;
	//
	static String charWater = " ";
	static String charLand = "-";
	//
	static Random rand = new Random();
	static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>(height);
	//static int[][] = new int[width][height];
	//
public Map(int width)
	

	public static void setGrid(){
		for(int row = 0; row < height; row++){
			arr.add(row, new ArrayList<String>());
			for(int col = 0; col < width; col++)
			{
				if(col <= (borderWidth - 1) || row <= (borderWidth - 1) || col >= (width - borderWidth) || row >= (height - borderWidth))
					arr.get(row).add(col, charWater);
				else
					arr.get(row).add(col, ( Integer.toString( getRandPercentage() ).equals("0") )?charWater:charLand );

			}
		}
	}

	public static void printGrid(){
		Game.wipeConsole();
		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col < width; col++)
			{
				System.out.print(arr.get(row).get(col));

			}
			System.out.print("\n");
		}

	}

	public static int getRandPercentage(){
		int rand100 = rand.nextInt(100) + 1;
		if (rand100 <= percentageFilled)
			return 1;
		else
			return 0;
	}

	public static int getSurroundingLand(int y, int x){
		int counterLand = 0;

		for(int row = y-1; row <= y+1; row++)
		{
			for(int col = x-1; col <= x+1; col++)
			{
				if (row >= 0 && col >= 0 && row < height && col < width){
					if(!(row == y && col == x)){
						if(arr.get(row).get(col).equals(charLand))
							counterLand++;
					}
				}
				else{
					counterLand--;
				}
			}
		}
		return counterLand;

	}

	public static void smoothenGrid(){

		for(int row = 0; row < height; row++){
			for(int col = 0; col < width; col++){
				int surroundings = getSurroundingLand(row, col);
				if(surroundings > smoothFactor){
					arr.get(row).set(col, charLand);
				}
				else if (surroundings < smoothFactor){
					arr.get(row).set(col, charWater);
				}


			}
		}
	}

	

}
