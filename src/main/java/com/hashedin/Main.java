package com.hashedin;

import java.io.InputStream;

public class Main {
	public static void main(String args[])
	{
		MoviesManager movieManager = new MoviesManager();
		
		InputStream movieInputStream = movieManager.readDataFile("movie.data");
		
		movieManager.convertInputStreamToMap(movieInputStream);
		
		InputStream ratingInputStream = movieManager.readDataFile("reatings.data");
		
		
	}
}
