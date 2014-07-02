package com.hashedin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String args[])
	{
		MoviesManager movieManager = new MoviesManager();
		RatingsManager ratingsManager = new RatingsManager();
		UsersManager usersManager = new UsersManager();
		
		
		Map<Integer,Movies> moviesMap = new HashMap<Integer,Movies>();
		ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
		Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
		
		InputStream movieInputStream = movieManager.readDataFile("movie.data");
		moviesMap = movieManager.convertInputStreamToMap(movieInputStream);
		
		InputStream ratingsInputStream = ratingsManager.readDataFile("ratings.data");	
		ratingsArrayList = ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream);
		
		InputStream usersInputStream = usersManager.readDataFile("user.data");
		usersMap = usersManager.convertInputStreamToMap(usersInputStream);
		
		GoogleOfMovies googleOfMovies = new GoogleOfMovies(moviesMap, ratingsArrayList, usersMap);
		
		googleOfMovies.findTotalRatingsOfEachMovie();
		System.out.println("Top Movie By rating : "+googleOfMovies.findTopMovie().getName());
		System.out.println("Most Watched Movie : "+googleOfMovies.MostWatchedMovie().getName());
		System.out.println("Top Movie By Genre : "+googleOfMovies.findTopMovieByGenre("Animation").getName());
		
		System.out.println(googleOfMovies.MostActiveUser().getUserId());
	}
}
