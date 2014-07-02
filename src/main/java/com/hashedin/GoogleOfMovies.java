package com.hashedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Class where all the use-cases are implemented**/

public class GoogleOfMovies {
	
	Map<Integer,Movies> moviesMap = new HashMap<Integer,Movies>();
	ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
	Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
	
	/**
	 * Parameterized constructor 
	 * @param Movies Map , arrayList of ratings object, UsersMap
	 */
	public GoogleOfMovies(Map<Integer,Movies> _moviesMap, 
			ArrayList<Ratings> _ratingsArrayList,Map<Integer,Users> _usersMap){
		
		moviesMap = _moviesMap;
		ratingsArrayList = _ratingsArrayList;
		usersMap = _usersMap;
	}
	
	
	public void findAverageRatingsOfEachMovie(){
		
		
		
		for(Ratings rating: ratingsArrayList){
			
			Movies movies = moviesMap.get(rating.getMovieId());
			
			movies.setTotalRating(rating.getRating());
			movies.setRatingsCount();
//			System.out.println(movies.getTotalRating());
//			System.out.println(movies.getRatingsCount());
			
		}
//		
//		float a = ((float)moviesMap.get(1).getTotalRating()/(float)moviesMap.get(1).getRatingsCount());
//		
//		System.out.println(a);
		
		
	}
	
	

}
