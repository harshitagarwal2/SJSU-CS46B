package sudoku;

import java.util.*;


public class Grid 
{
	private int[][]						values;
	

	//
	// DON'T CHANGE THIS.
	//
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}
	
	
	//
	// DON'T CHANGE THIS. I WON'T
	//
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}
	
	
	//
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full.
	//
	// Example: if this grid = 1........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//
	// Then the returned array list would contain:
	//
	// 11.......          12.......          13.......          14.......    and so on     19.......
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	//
	public ArrayList<Grid> next9Grids()
	{
		ArrayList<Grid> nextNine = new ArrayList<>();
		int[][] intArray=values;
		if(this.isFull())
		{
			return null;
		}
		else
		{
			int row=0;
			int column=0;
			//Returns the location of the first empty member.
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(values[i][j]==0)
					{
						row=i;
						column=j;
						break;
					}
				}
			}
			
			//uses the location of empty member and replaces it with 1-9
			//Also adds the grid to the arraylist
			for(int o=1;o<10;o++)
			{
				intArray[row][column]=o;			//Changing the empty member to a number from 1-9
				String[] sArray = new String[9];
				for(int l=0;l<9;l++)
				{
					String s = "";
					for(int m=0;m<9;m++)
					{
						s+=intArray[l][m];
					}
					sArray[l]=s;
				}
				Grid newGrid = new Grid(sArray);
				nextNine.add(newGrid);				//Adding the grid to the arraylist
				
			}
		}
		return nextNine;
	}
	
	//
	// Returns true if this grid is legal. A grid is legal if no row, column, or 
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal()
	{	
		//The hashset declarations for checking the repeated numbers.
		HashSet<Integer> rowCheck = new HashSet<>();
		HashSet<Integer> columnCheck = new HashSet<>();
		HashSet<Integer> first = new HashSet<>();
		HashSet<Integer> second = new HashSet<>();
		HashSet<Integer> third = new HashSet<>();
		
		//Checks for repeated numbers in rows and columns
		for(int a=0;a<9;a++)
		{
			for(int b=0;b<9;b++)
			{
				int val1 = values[a][b];
				int val2 = values[b][a];
				//Row Checker
				if(val1 != 0 && !rowCheck.add(val1))
				{
					return false;
				}
				
				//Column Checker
				if(val2 != 0 && !columnCheck.add(val2))
				{
					return false;
				}
				
			}
			rowCheck.clear();
			columnCheck.clear();
		}
		
		//Checks if 3x3 block contains a repeated digit.
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(values[i][j]>0&&values[i][j]<10)
				{
					
					if(j<3)
					{
						if(!first.add(values[i][j]))
						{
							return false;
						}
						
					}
					else if(j<6)
					{
						if(!second.add(values[i][j]))
						{
							return false;
						}
					}
					else
					{
						if(!third.add(values[i][j]))
						{
							return false;
						}
					}
				}
			}
			//Clears the HashSets when changing blocks
			if(i==2 || i==5 || i==8)
			{
				first.clear();
				second.clear();
				third.clear();
			}	
		}
		return true;
	}
	
	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{	
				if (values[i][j] == 0)
				{	
					return false;
				}
			}
		}
		return true;
	}
	
	//
	// Returns true if x is a Grid and, for every (i,j), 
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x)
	{
		Grid gridd = (Grid)x;
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(gridd.values[i][j]!=this.values[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	

}
