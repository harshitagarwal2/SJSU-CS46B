package movies;

public class Movie implements Comparable<Movie>
{
	private String title;
	private int year;
	
	public Movie(String title, int year)
	{
		this.title=title;
		this.year=year;
	}
// Compares the movie titles and their years
	public int compareTo(Movie other)
    {
		int something = (this.getTitle().compareTo(other.getTitle()));
		
        if(something!=0)
        {
            return something;
        }
        return this.getYear()-other.getYear();
    
    }
	public String getTitle()
	{
		return title;
	}
	
	public int getYear()
	{
		return year;
	}
	
	//Tests deep equality between movie objects
	public boolean equals(Object a)
	{
		Movie b = (Movie)a;
		if ((this.compareTo(b))==0)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Movie" + " " + this.getTitle() + " " + "(" + this.getYear() + ")" ;
	}
	
	
	//Array of movies
	public static Movie[] getTestMovies()
	{
		Movie[] array = new Movie[10];
		array[0] = new Movie("The Memelord", 1929);
		array[1] = new Movie("The Memelord", 2009);
		array[2] = new Movie("A Legend is Born",1998);
		array[3] = new Movie("Psycho", 1998);
		array[4] = new Movie("The Human Centipede", 2009);
		array[5] = new Movie("The Human Centipede", 2009);
		array[6] = new Movie("Donnie Darko", 2001);
		array[7] = new Movie("Fight Club", 1999);
		array[8] = new Movie("Predestination", 2014);
		array[9] = new Movie("Triangle", 2009);
		
		return array;
		
	}
	
	public int hashCode()
	{
		return title.hashCode() + year;
	}
	
}