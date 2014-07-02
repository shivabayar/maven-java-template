package com.hashedin;

import java.io.InputStream;

import junit.framework.TestCase;

public class RatingsManagerTest extends TestCase{
	
	public void testApp()
    {
		RatingsManager ratingsManager = new RatingsManager();
    	
    	InputStream ratingsInputStream = ratingsManager.readDataFile("ratings_test.data");
  
    	assertEquals( ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream).size(),9 );
        
//        assertEquals( ratingsManager.convertInputStreamToArrayListOfObjects(ratingsInputStream).get(1).getUserId(), 62);
    }

}
