package movies;
import java.util.ArrayList;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive
{
	
	//Sorts movie using Treesets
	public ArrayList<Movie> getSorted(){
		TreeSet<Movie> treeSet = new TreeSet<Movie>(this);
		ArrayList<Movie> movies = new ArrayList<Movie>(treeSet);
		return movies;
		
	}
	
	//Adds movie to arraylist after checking for deep
	//equality within it
	//@param a The movie to be added
	public boolean add(Movie a)
	{
		for (Movie b:this){
			if(a.equals(b)){
				return false;
			}
		}
		return super.add(a);
	}
	
	public static void main(String[] args)
	{
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
		{
			System.out.println(m);
		}
	}

}