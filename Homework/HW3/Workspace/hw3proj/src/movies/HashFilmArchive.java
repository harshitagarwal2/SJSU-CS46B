package movies;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {
	
	//Sorts movie using Treesets
	public ArrayList<Movie> getSorted()
	{
		TreeSet<Movie> treeSet = new TreeSet<Movie>(this);
		ArrayList<Movie> movies = new ArrayList<Movie>(treeSet);
		return movies;
	}
	
	public static void main(String[] args)
	{
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
		{
			System.out.println(m);
		}
	}
}

