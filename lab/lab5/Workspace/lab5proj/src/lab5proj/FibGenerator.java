package lab5proj;

public class FibGenerator 
{
	private int[] callCounter;
	public int nthFib(int n)
	{
		callCounter = new int[n+1];
		return computeFibRecurse(n);
	}
	private int computeFibRecurse(int n)
	{
		callCounter[n]+=1;
		if(n==1||n==2)
			return 1;
		else
			return computeFibRecurse(n-2) + computeFibRecurse(n-1);
	}
	public void printCallCounter()
	{
		for(int i=0;i<callCounter.length;i++)
		{
			System.out.println(callCounter[i]);
		}
	}
	public static void main(String[] args)
	{
		FibGenerator fb = new FibGenerator();
		for(int i=1;i<20;i++)
		{
			System.out.println(i+" "+fb.nthFib(i));
		}
		fb.printCallCounter();
	}
}
	

