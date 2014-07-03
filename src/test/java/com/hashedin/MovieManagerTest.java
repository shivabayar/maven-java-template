package com.hashedin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;

public class MovieManagerTest extends TestCase {
	
	
	 public void testApp()
	    {
//	    	MoviesManager movieManager = new MoviesManager();
//	    	
//	    	InputStream movieInputStream = movieManager.readDataFile("movies_test.data");
//	  
//	    	assertEquals( movieManager.convertInputStreamToMap(movieInputStream).size(),3 );
	        
//	        assertEquals( movieManager.convertInputStreamToMap(movieInputStream).get(3).getName(),"Four Rooms (1995)" );
	    	MoviesManager movieManager = new MoviesManager();
			RatingsManager ratingsManager = new RatingsManager();
			UsersManager usersManager = new UsersManager();
			
			
			Map<Integer,Movies> moviesMap = new HashMap<Integer,Movies>();
			ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
			Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
			
			InputStream movieInputStream = movieManager.readDataFile("movies_test.data");
			moviesMap = movieManager.convertInputStreamToMap(movieInputStream);
			
			InputStream ratingsInputStream = ratingsManager.readDataFile("ratings_test.data");	
			ratingsArrayList = ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream);
//			
//			InputStream usersInputStream = usersManager.readDataFile("user.data");
//			usersMap = usersManager.convertInputStreamToMap(usersInputStream);
			
			GoogleOfMovies googleOfMovies = new GoogleOfMovies(moviesMap, ratingsArrayList, usersMap);
			
//			googleOfMovies.findTotalRatingsOfEachMovie();
//			System.out.println(googleOfMovies.findTopMovie().getName());
//			System.out.println(googleOfMovies.findTopMovie().getName());
//			assertEquals(googleOfMovies.findTopMovie().getName(), "Four Rooms (1995)");
//			assertEquals("Copycat (1995)", "Copycat (1995)");
				
	    }
}
