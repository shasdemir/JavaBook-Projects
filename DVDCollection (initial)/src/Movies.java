public class Movies {
	public static void main(String[] args) {
	DVDCollection movies = new DVDCollection();
		
	movies.addDVD("The Godfather", "Francis Ford Coppola", 1972, 24.95, true);
	movies.addDVD("District 9", "Neill Blokamp", 2009, 19.95, false);
	movies.addDVD("Iron Man", "Jon Favreau", 2008, 15.95, false);
	movies.addDVD("All About Eve", "Joseph Mankiewicz", 1950, 17.50, false);
	movies.addDVD("The Matrix", "Andy & Lana Wachowski", 1999, 19.95, true);
	
	System.out.println(movies);
	
	movies.addDVD("Iron Man 2", "Jon Favreau", 2010, 22.99, false);
	movies.addDVD("Casablanca", "Michael Curtiz", 1942, 19.95, false);
	
	System.out.println(movies);
	}
}
