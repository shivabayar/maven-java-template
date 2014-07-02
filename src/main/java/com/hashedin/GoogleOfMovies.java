package com.hashedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Class where all the use-cases are implemented**/

public class GoogleOfMovies {
	
	Map<Integer,Movies> moviesMap = new HashMap<Integer,Movies>();
	ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
	Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
	int []movieId = new int[moviesMap.size()];
	
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
	
	
	public void findTotalRatingsOfEachMovie(){
		
		
		
		for(Ratings rating: ratingsArrayList){
			
			Movies movies = moviesMap.get(rating.getMovieId());
		
			movies.setTotalRating(rating.getRating());
			movies.setRatingsCount();

			
		}

//		createArrayOfMovieIdAndAverageRating();
	}
	
	
	public float findAverage(int movieId){
		
		return ((float)moviesMap.get(movieId).getTotalRating()/(float)moviesMap.get(movieId).getRatingsCount());
	}
	
	public float[] createArrayOfAverageRating(){
		
		movieId = new int[moviesMap.size()];
		float []averages = new float[moviesMap.size()];
		
		Iterator moviesMapIterator = moviesMap.keySet().iterator();
		
		for(int i = 0 ;moviesMapIterator.hasNext(); ++i){
			movieId[i] = (int) moviesMapIterator.next();
			averages[i] = findAverage(movieId[i]);
			moviesMap.get(movieId[i]).setAverageRating(averages[i]);
//			System.out.println(findAverage(movieId[i]));
//			++count;
		}
		
		return averages;
	}
	

	public Movies findTopMovie(){
		
		float averages[] = createArrayOfAverageRating();
		float max = averages[0];
		int positionOfMax = 0;
		for(int i = 1 ; i < averages.length ; ++i){
			
			if(max < averages[i]){
				positionOfMax = i;
				max = averages[i];
			}
			
		}
		
		return moviesMap.get(movieId[positionOfMax]);
		
	}
	
	public Movies MostWatchedMovie(){
		
		int numberOfTimesWatched[] = new int[moviesMap.size()];
		
		Iterator moviesMapIterator = moviesMap.keySet().iterator();
		
		int maxId = (int)moviesMapIterator.next();
		
		int max = moviesMap.get(maxId).getRatingsCount();
		
		while(moviesMapIterator.hasNext()){
			int tempId = (int)moviesMapIterator.next();
			int tempMax = moviesMap.get(tempId).getRatingsCount();
			if(max < tempMax){
				maxId = tempId;
				max = tempMax;
			}
			
		}
		
		return moviesMap.get(maxId);
	}
	
//	public Movies

}
