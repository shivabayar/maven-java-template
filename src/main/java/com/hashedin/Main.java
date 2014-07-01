package com.hashedin;

import java.io.InputStream;

public class Main {
	public static void main(String args[])
	{
		MoviesManager movieManager = new MoviesManager();
		RatingsManager ratingsManager = new RatingsManager();
		
		InputStream movieInputStream = movieManager.readDataFile("movie.data");
		
		movieManager.convertInputStreamToMap(movieInputStream);
		
		InputStream ratingsInputStream = ratingsManager.readDataFile("ratings.data");
		System.out.println(ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream).size());	
//		ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream);
		
	}
}
