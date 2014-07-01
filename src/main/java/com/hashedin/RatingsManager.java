package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class RatingsManager {
	
	
	public InputStream readDataFile(String fileName){
		System.out.println("working");
		
		InputStream ratingsInputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		return ratingsInputStream;
	}
	
	public ArrayList<Ratings> convertInputStreamToArrayListOfObjects(InputStream ratingsInputStream){
		
		ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
		
		try {
			
			List<String> lines = IOUtils.readLines(ratingsInputStream);
			
			for(String line : lines){
				Ratings r = new Ratings();
				
				r = parseLine(line);
				ratingsArrayList.add(r);
			
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return ratingsArrayList;
	}
	
	public Ratings parseLine(String line){
		
		StringTokenizer st = new StringTokenizer(line,"\t");
		Ratings r = new Ratings();
		
		if(st.hasMoreTokens())
		{
			r.setUserId(Integer.parseInt(st.nextToken()));
			r.setMovieId(Integer.parseInt(st.nextToken()));
			r.setRating(Integer.parseInt(st.nextToken()));
			r.setTimeStamp(st.nextToken());
		}
		
		return r;
	}
	
	public void highestRatedMovie(ArrayList<Ratings> ratingsArrayList){
		
	}
	
}



