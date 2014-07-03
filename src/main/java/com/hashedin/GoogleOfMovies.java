package com.hashedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
 * Class where all the use-cases are implemented**/

public class GoogleOfMovies {

	Map<Integer, Movies> moviesMap = new HashMap<Integer, Movies>();
	ArrayList<Ratings> ratingsArrayList = new ArrayList<Ratings>();
	Map<Integer, Users> usersMap = new HashMap<Integer, Users>();
	int[] movieId = new int[moviesMap.size()];

	/**
	 * Parameterized constructor
	 * 
	 * @param Movies
	 *            Map , arrayList of ratings object, UsersMap
	 */
	public GoogleOfMovies(Map<Integer, Movies> _moviesMap,
			ArrayList<Ratings> _ratingsArrayList, Map<Integer, Users> _usersMap) {

		moviesMap = _moviesMap;
		ratingsArrayList = _ratingsArrayList;
		usersMap = _usersMap;

		updateMaps();
		
	}

	/*
	 * Update the Movies map i.e., adding into the total rating and setting the
	 * ratingsCount
	 * 
	 * @return void
	 */

	private void updateMaps() {
		
		updateTotalRatingsOfEachMovie();
		updateAverageIntoMaps();
		updateYearInMaps();
	}

	public void updateTotalRatingsOfEachMovie() {

		for (Ratings rating : ratingsArrayList) {

			Movies movies = moviesMap.get(rating.getMovieId());
			Users users = usersMap.get(rating.getUserId());

			movies.setTotalRating(rating.getRating());
			movies.setRatingsCount();

			users.setNumberOfRatingsDoneCount();

		}
	}

	private void updateAverageIntoMaps() {

		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();

		while (moviesMapIterator.hasNext()) {
			int tempId = moviesMapIterator.next();
			moviesMap.get(tempId).setAverageRating(findAverage(moviesMapIterator.next()));
		}
	}

	private void updateYearInMaps() {
		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();

		while (moviesMapIterator.hasNext()) {
			Movies movies = moviesMap.get(moviesMapIterator.next());
			movies.setYear(findYear(movies.getRelease()));
		}

	}
	
	/*
	 * Find the average rating of a particular movies object
	 * 
	 * @param movieId
	 * 
	 * @return average in float
	 */
	public float findAverage(int movieId) {
	
		return ((float) moviesMap.get(movieId).getTotalRating() / (float) moviesMap
				.get(movieId).getRatingsCount());
	}

	/*
	 * */
//	public float[] createArrayOfAverageRating() {
//
//		movieId = new int[moviesMap.size()];
//		float[] averages = new float[moviesMap.size()];
//
//		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();
//
//		for (int i = 0; moviesMapIterator.hasNext(); ++i) {
//			movieId[i] = (int) moviesMapIterator.next();
//			averages[i] = findAverage(movieId[i]);
//			moviesMap.get(movieId[i]).setAverageRating(averages[i]);
//			// System.out.println(findAverage(movieId[i]));
//			// ++count;
//		}
//
//		// System.out.println(moviesMap.get(814).getGenre());
//
//		return averages;
//	}

	// public Movies findTopMovie1()
	// {
	// Iterator moviesIterator = moviesMap.keySet().iterator();
	//
	// int maxId = (int)moviesIterator.next();
	// float maxRating = moviesMap.get(maxId).getAverageRating();
	//
	// while(moviesIterator.hasNext()){
	// int tempId = (int)moviesIterator.next();
	// float tempMaxRating = moviesMap.get(tempId).getAverageRating();
	//
	// if(maxRating < tempMaxRating)
	// {
	// maxRating = tempMaxRating;
	// maxId = tempId;
	// }
	// }
	// return moviesMap.get(maxId);
	// }

	/*
	 * Finds the max of the value in key value map
	 * 
	 * @param hashMap
	 * 
	 * @return id type integer
	 */
	public int findMax(HashMap<Integer, Float> filteredMoviesMap) {
		Iterator<Integer> moviesIterator = filteredMoviesMap.keySet()
				.iterator();

		int maxId = (int) moviesIterator.next();
		float maxRating = filteredMoviesMap.get(maxId);

		while (moviesIterator.hasNext()) {
			int tempId = (int) moviesIterator.next();
			float tempMaxRating = filteredMoviesMap.get(tempId);

			if (maxRating < tempMaxRating) {
				maxRating = tempMaxRating;
				maxId = tempId;
			}
		}
		return maxId;
	}

//	public Movies findTopMovie() {
//
//		float averages[] = createArrayOfAverageRating();
//		float max = averages[0];
//		int positionOfMax = 0;
//		for (int i = 1; i < averages.length; ++i) {
//
//			if (max < averages[i]) {
//				positionOfMax = i;
//				max = averages[i];
//			}
//		}
//		return moviesMap.get(movieId[positionOfMax]);
//	}

	public Movies findTopMovie1() {

		Map<Integer, Float> filteredMaps = new HashMap<Integer, Float>();

		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();

		while (moviesMapIterator.hasNext()) {
			int tempId = moviesMapIterator.next();
			float tempAverage = moviesMap.get(tempId).getAverageRating();

			filteredMaps.put(tempId, tempAverage);
		}

		return moviesMap.get(findMax((HashMap<Integer, Float>) filteredMaps));
	}

	/*
	 * Finding the most watched movies on the basis of number of enteries in
	 * ratings.data
	 * 
	 * @pram null
	 * 
	 * @return movies object
	 */
	public Movies MostWatchedMovie() {

		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();

		int maxId = (int) moviesMapIterator.next();

		int max = moviesMap.get(maxId).getRatingsCount();

		while (moviesMapIterator.hasNext()) {
			int tempId = (int) moviesMapIterator.next();
			int tempMax = moviesMap.get(tempId).getRatingsCount();
			if (max < tempMax) {
				maxId = tempId;
				max = tempMax;
			}

		}

		return moviesMap.get(maxId);
	}

	public Movies findTopMovieByGenre(String genre) {

		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();
		Map<Integer, Float> genreMap = new HashMap<Integer, Float>();

		while (moviesMapIterator.hasNext()) {
			int tempId = (int) moviesMapIterator.next();
			ArrayList<String> genreList = moviesMap.get(tempId).getGenre();

			Iterator<String> genreListIterator = genreList.iterator();

			while (genreListIterator.hasNext()) {
				if (genreListIterator.next() == genre) {
					genreMap.put(tempId, moviesMap.get(tempId)
							.getAverageRating());
				}
			}
		}

		return moviesMap.get(findMax((HashMap<Integer, Float>) genreMap));
	}

	public Users MostActiveUser() {

		Iterator<Integer> usersMapIterator = usersMap.keySet().iterator();
		int maxUserId = (int) usersMapIterator.next();
		int maxCount = usersMap.get(maxUserId).getNumberOfRatingsDoneCount();

		while (usersMapIterator.hasNext()) {
			int tempUserId = (int) usersMapIterator.next();
			int tempMaxCount = usersMap.get(tempUserId)
					.getNumberOfRatingsDoneCount();

			if (maxCount < tempMaxCount) {
				maxCount = tempMaxCount;
				maxUserId = tempUserId;
			}

		}

		return usersMap.get(maxUserId);
	}

	

	public Movies topMovieByYear(int year) {

		Map<Integer,Float> filteredMap = new HashMap<Integer,Float>();
		Iterator<Integer> moviesMapIterator = moviesMap.keySet().iterator();
		
		while(moviesMapIterator.hasNext()){
			int tempId = moviesMapIterator.next();
//			System.out.println(moviesMap.get(tempId).getAverageRating());
			if(moviesMap.get(tempId).getYear() == year){
				
				filteredMap.put(tempId, moviesMap.get(tempId).getAverageRating());
			}
		}

		return moviesMap.get(findMax((HashMap<Integer, Float>) filteredMap));
	}

	public int findYear(String date) {

		String ResultString = new String();
		try {
			Pattern regex = Pattern
					.compile("([0-9]{2})-([aA-zZ]{3})-([0-9]{4})");
			Matcher regexMatcher = regex.matcher(date);
			if (regexMatcher.find() &&regex!=null) {
				ResultString = regexMatcher.group(3);
//				System.out.println(ResultString);
			}
			else{
				ResultString = "12345";
			}
			
		} 
		catch (PatternSyntaxException ex) {
			// Syntax error in the regular expression
		}
		
		return Integer.parseInt(ResultString);
	}
}
