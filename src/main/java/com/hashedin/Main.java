package com.hashedin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class Main {
	public static void main(String args[])
	{
		MoviesManager movieManager = new MoviesManager();
		RatingsManager ratingsManager = new RatingsManager();
		UsersManager usersManager = new UsersManager();
		
		
		InputStream movieInputStream = movieManager.readDataFile("movie.data");
		Map<Integer,Movies> moviesMap = movieManager.convertInputStreamToMap(movieInputStream);
		
		InputStream ratingsInputStream = ratingsManager.readDataFile("ratings.data");	
		ArrayList<Ratings> ratingsArrayList = ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream);
		
		InputStream usersInputStream = usersManager.readDataFile("user.data");
		Map<Integer,Users> usersMap = usersManager.convertInputStreamToMap(usersInputStream);
		
		GoogleOfMovies googleOfMovies = new GoogleOfMovies(moviesMap, ratingsArrayList, usersMap);
		
//		googleOfMovies.findTotalRatingsOfEachMovie();
		System.out.println("Top Movie By rating : "+googleOfMovies.findTopMovie1().getName());
//		System.out.println("Top Movie By rating : "+googleOfMovies.findTopMovie1().getName());
		System.out.println("Most Watched Movie : "+googleOfMovies.MostWatchedMovie().getName());
		System.out.println("Top Movie By Genre : "+googleOfMovies.findTopMovieByGenre("Animation").getName());	
		System.out.println("Most Active User : "+googleOfMovies.MostActiveUser().getUserId());
		System.out.println("Top Movie by year : "+googleOfMovies.topMovieByYear(1996).getName());
//		googleOfMovies.topMovieByYear();
	}
}
