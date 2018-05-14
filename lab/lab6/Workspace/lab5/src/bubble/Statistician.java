package bubble;

import java.util.*;

public class Statistician 
{
	private final static int N_REPETITIONS=5000;
	
	private static void getStats(int arrayLength)
	{
		ArrayList<Long> visitCounts = new ArrayList<>();
		ArrayList<Long> swapCounts = new ArrayList<>();
		
		for (int i=0; i<N_REPETITIONS; i++)
		{
			int[] array = BubbleSortTestCaseMaker.buildRandom(arrayLength, arrayLength*100);
			BubbleSorter sorter = new BubbleSorter(array);
			sorter.sort();
			// Assert that the sorter sorted correctly.
			assert sorter.isSorted() : "Array isn't sorted";
			// Append # visits and # swaps to the array lists.
			visitCounts.add(sorter.getNVisits());
			swapCounts.add(sorter.getNSwaps());
		}
		long sumVisits=0;
		long sumSwaps=0;
		long minVisits=visitCounts.get(0);
		long minSwaps=swapCounts.get(0);
		long maxVisits=visitCounts.get(0);
		long maxSwaps=swapCounts.get(0);
		for(Long visits:visitCounts)
		{
			sumVisits+=visits;
			if(minVisits>visits)
			{
				minVisits=visits;
			}
			if(maxVisits<visits)
			{
				maxVisits=visits;
			}
		}
		for(Long swaps:swapCounts)
		{
			sumSwaps+=swaps;
			if(minSwaps>swaps)
			{
				minSwaps=swaps;
			}
			if(maxSwaps<swaps)
			{
				maxSwaps=swaps;
			}
		}

		System.out.println(minVisits+ " "+(sumVisits/visitCounts.size()) +" " +maxVisits);
		System.out.println(minSwaps+ " "+(sumSwaps/swapCounts.size()) +" " +maxSwaps);
		// Compute and print min/average/max number of visits.
		// Compute and print min/average/max number of swaps.
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("1000:");
		long startTime = System.currentTimeMillis();
		getStats(1000);
		long endTime = System.currentTimeMillis();
		System.out.println("time ran for" + (endTime-startTime));
		System.out.println("3000:");
		startTime = System.currentTimeMillis();
		getStats(3000);
		endTime = System.currentTimeMillis();
		System.out.println("time ran for" + (endTime-startTime));
	}
}
