package mergesort;
import java.util.Arrays;

public class MergeSorter 
{
	private int[] array;
	
	//The constructor for the integer array
	public MergeSorter(int[] array)
	{
		this.array=array;
	}
	
	//Sort method that calls Sort Recurse method and returns the sorted array
	public int[] sort()
	{
		mergeSortRecurse(array);
		return array;
	}
	
	//Method splitting the array, sorting and merging it using recursion
	private void mergeSortRecurse(int[] sortMe)
	{
		
		//Counters
		int j=0;
		int k=0;
		
		int lengthArray = sortMe.length;
		
		//Case that check for singular element array
		if(lengthArray <= 1)
			return;
		
		//Splitting the array into left and right
		int[] leftHalf = Arrays.copyOfRange(sortMe,0,lengthArray/2);
		int[] rightHalf = Arrays.copyOfRange(sortMe, lengthArray/2, lengthArray);
		
		//Recursively calling the method on the left and the right half of the array
		mergeSortRecurse(leftHalf); 
		mergeSortRecurse(rightHalf);
		
		//The actual sorting
		for(int i=0;i<lengthArray;i++) 
		{
			if(k<rightHalf.length && j<leftHalf.length)
			{
				if(leftHalf[j]<rightHalf[k])
				{
					sortMe[i]=rightHalf[k];
					k++;
				}
				else
				{
					sortMe[i]=leftHalf[j];
					j++;
				}
			}
			else if(k<rightHalf.length)
			{
				sortMe[i]=rightHalf[k];
				k++;
			}
			else
			{
				sortMe[i]=leftHalf[j];
				j++;
			}
		}	
	}

	public static void main(String[] args)
	{
		int[] gg = {1,2,3,3,3,3,3,8};
		MergeSorter hh = new MergeSorter(gg);
		hh.sort();
		for(int i:gg){
			System.out.println(i);
		}
		
	}
}
