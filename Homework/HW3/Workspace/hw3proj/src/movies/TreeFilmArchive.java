package movies;
import java.util.ArrayList;
import java.util.TreeSet;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {
	
	//Sorts movie using Treesets
	public ArrayList<Movie> getSorted()
	{
		ArrayList<Movie> movies = new ArrayList<Movie>(this);
		return movies;	
	}
	
	public static void main(String[] args)
	{
		TreeFilmArchive archive = new TreeFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
		{
			System.out.println(m);
		}
	}

}
