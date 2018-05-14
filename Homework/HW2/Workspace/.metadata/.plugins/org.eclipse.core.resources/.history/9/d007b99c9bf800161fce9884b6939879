package weather;

import java.util.ArrayList;


public class Sky2 extends ArrayList<Cloud>
{
	// Like Sky, this ctor creates an ArrayList with initial capacity of 100. Unlike
	// Sky, which "has-a" ArrayList<Cloud>, Sky2 "is-a" ArrayList<Cloud>. The ArrayList<Cloud>
	// portion of this onion is created by the superclass ctor. Here we call the superclass
	// ctor version that takes one int as an arg.
	public Sky2()
	{
		super(100);	
	}
	
	
	public float getMeanHeight()
	{
		float totalHeight = 0f;
		for (Cloud c: this)
			totalHeight += c.getHeight();
		return totalHeight / size();		// since there is no size() method here in
		  									// Sky2, Java looks to see if there's one in
											// the superclass. There is. Inheritance!
	}
	
	
	// For adding clouds, don't do anything. Since Sky2 extends ArrayList<Cloud>, it
	// inherits public boolean add(Cloud c).
	
	
	//
	// This is the main() that I SHOULD HAVE told you to implement. It's just like
	// the Sky main(), except it creates and exercises an instance of Sky2.
	//
	public static void main(String[] args)
	{
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		CumulusCloud cumu = new CumulusCloud(200, 2000);
		if (!cumu.rain().startsWith("It is raining"))
			System.out.println("Bad CumulusCloud::rain");
		CirrusCloud cirr = new CirrusCloud(300, 3000);
		if (!cirr.rain().startsWith("I cannot make"))
			System.out.println("Bad CirrusCloud::rain");
		Sky2 sky2 = new Sky2();
		sky2.add(strat);
		sky2.add(cumu);
		sky2.add(cirr);
		float mean = sky2.getMeanHeight();
		if (mean < 1799  ||  mean > 1801)
			System.out.println("Bad mean height: expected 1800, saw " + mean);
		System.out.println("Everything (else) is ok");
	}
}
