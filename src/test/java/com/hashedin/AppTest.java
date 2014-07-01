package com.hashedin;

import java.io.InputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	MoviesManager movieManager = new MoviesManager();
    	RatingsManager ratingsManager = new RatingsManager();
    	
    	InputStream movieInputStream = movieManager.readDataFile("movies_test.data");
    	
//    	movieManager.convertInputStreamToMap(movieInputStream);
//    	
//    	InputStream ratingsInputStream = ratingsManager.readDataFile("ratings.data");
    	
//        assertEquals( movieManager.convertInputStreamToMap(movieInputStream).size(),3 );
        
        assertEquals( movieManager.convertInputStreamToMap(movieInputStream).get(3).getName(),"Four Rooms (1995)" );
    }
}
