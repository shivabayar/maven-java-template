package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

/**
 * Manager for Ratings class*/

public class RatingsManager {
	
	/*
	 * Reading the data file. 
	 * @param File Name @type string
	 * @return Input Stream @type InputStream*/
	public InputStream readDataFile(String fileName){
		System.out.println("working");
		
		InputStream ratingsInputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		return ratingsInputStream;
	}
	
	/**
	 * Converting the InputStream to an arrayList 
	 * @param moviesInputStream @type InputStream
	 * @return ArrayList<Ratings>*/
	public ArrayList<Ratings> convertInputStreamToArrayListOfObjects(InputStream ratingsInputStream){
		
		ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
		
		try {
			
			List<String> lines = IOUtils.readLines(ratingsInputStream);
			
			for(String line : lines){
				Ratings ratings = new Ratings();
				
				ratings = parseLine(line);
				ratingsArrayList.add(ratings);
				
			
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		return ratingsArrayList;
	}
	
	public Ratings parseLine(String line){
		
		StringTokenizer st = new StringTokenizer(line,"\t");
		Ratings ratings = new Ratings();
		
		if(st.hasMoreTokens())
		{
			ratings.setUserId(Integer.parseInt(st.nextToken()));
			ratings.setMovieId(Integer.parseInt(st.nextToken()));
			ratings.setRating(Integer.parseInt(st.nextToken()));
			ratings.setTimeStamp(st.nextToken());
		}
		
		return ratings;
	}
	
	
}



