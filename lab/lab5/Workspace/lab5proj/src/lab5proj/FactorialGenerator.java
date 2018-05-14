package lab5proj;

public class FactorialGenerator 
{
	
	public double nthFactorial(int n)
	{
		return computeFactorialRecurse(n);
	}
	private double computeFactorialRecurse(int n)
	{
		assert n >= 0 : "Illegal n: " + n;
		if (n!=0)
			return n*computeFactorialRecurse(n-1);
		else
			return 1;
	}
	
	public static void main(String[] args)
	{
		FactorialGenerator fg = new FactorialGenerator();
		/*for(int i=0;i<33;i++)
			System.out.println(i+" " +fg.nthFactorial(i));*/
		System.out.println(fg.nthFactorial(0));
	}
	
}
