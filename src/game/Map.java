package game;

public class Map
{
	final int width, height;
	
	final Tile[][] grid;

	public Map(int height, int width)
	{
		this.height = height;
		this.width = width;
		grid = new Tile[height][width];
		
		//the default map is filled with water.
		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col < width; col++)
			{
				grid[row][col] = Tile.WATER;
			}
		}
	}

	public void setProceduralMap(int borderWidth, int percentageFilled)
	{
		for(int row = borderWidth; row < height - borderWidth; row++)
		{
			for(int col = borderWidth; col < width - borderWidth; col++)
			{
				grid[row][col] = (getRandThreshold(percentageFilled) == 0) ? Tile.WATER : Tile.GRASS;
			}
		}
	}

	public void printGrid()
	{
		Game.wipeConsole();
		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col < width; col++)
			{
				System.out.print(grid[row][col] + " ");
			}
			System.out.print("\n");
		}
	}

	public int getRandThreshold(int percentageFilled)
	{
		int rand100 = Game.rand.nextInt(100) + 1;
		if (rand100 <= percentageFilled)
			return 1;
		else
			return 0;
	}

	public int getSurroundingLand(int y, int x)
	{
		int counterLand = 0;
		for(int row = y-1; row <= y+1; row++)
		{
			for(int col = x-1; col <= x+1; col++)
			{
				if (row >= 0 && col >= 0 && row < height && col < width)
				{
					if(!(row == y && col == x))
					{
						if(grid[row][col].equals(Tile.GRASS))
							counterLand++;
					}
				} else {
					counterLand--;
				}
			}
		}
		return counterLand;
	}

	public void smoothenGrid(int smoothFactor)
	{
		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col < width; col++)
			{
				int surroundings = getSurroundingLand(row, col);
				if(surroundings > smoothFactor) 
				{
					grid[row][col] = Tile.GRASS;
				} else if (surroundings < smoothFactor) {
					grid[row][col] = Tile.WATER;
				}
			}
		}
	}
}
