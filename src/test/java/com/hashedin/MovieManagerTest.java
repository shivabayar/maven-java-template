package com.hashedin;

import java.io.InputStream;

import junit.framework.Test;
import junit.framework.TestCase;

public class MovieManagerTest extends TestCase {
	
	
	 public void testApp()
	    {
	    	MoviesManager movieManager = new MoviesManager();
	    	RatingsManager ratingsManager = new RatingsManager();
	    	
	    	InputStream movieInputStream = movieManager.readDataFile("movies_test.data");
	    	
//	    	movieManager.convertInputStreamToMap(movieInputStream);
//	    	
//	    	InputStream ratingsInputStream = ratingsManager.readDataFile("ratings.data");
	    	
//	        assertEquals( movieManager.convertInputStreamToMap(movieInputStream).size(),3 );
	        
	        assertEquals( movieManager.convertInputStreamToMap(movieInputStream).get(3).getName(),"Four Rooms (1995)" );
	    }
}
