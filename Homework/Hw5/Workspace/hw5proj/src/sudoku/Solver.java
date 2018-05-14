package sudoku;

import java.util.*;


public class Solver 
{
	private Grid						problem;
	private ArrayList<Grid>				solutions;
	
	
	public Solver(Grid problem)
	{
		this.problem = problem;
	}
	
	
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}
	
		
	//
	// Standard backtracking recursive solver.
	//
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			return; 						// Abandon evaluation of this illegal board.
		}
		else if (eval == Evaluation.ACCEPT)
		{
			solutions.add(grid); 			// A complete and legal solution. Add it to solutions.
		}
		else
		{
			// Here if eval == Evaluation.CONTINUE. Generate all 9 possible next grids. Recursively 
			// call solveRecurse() on those grids.
			for (Grid gg: grid.next9Grids())
				solveRecurse(gg);
		}
	}

	
	//
	// Returns Evaluation.ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	//
	public Evaluation evaluate(Grid grid)
	{
		if (!grid.isLegal())
			return Evaluation.ABANDON;
		
		else if (grid.isFull())
			return Evaluation.ACCEPT;
		
		else
			return Evaluation.CONTINUE;
	}


	//Gets the solutions to the problems
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	
	public static void main(String[] args)
	{
		Grid g = TestGridSupplier.getPuzzle1();		// or any other puzzle
		Solver solver = new Solver(g);
		System.out.println("isLegal: " + g.isLegal());
		solver.solve();
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
		System.out.println(solver.getSolutions().contains(TestGridSupplier.getSolution1()));
	}
}