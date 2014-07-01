package com.hashedin;

public class Ratings {
	
	private int userId ;
	private int movieId;
	private int rating;
	
	
	@Override
	public String toString() {
		return "Ratings [userId=" + userId + ", movieId=" + movieId
				+ ", rating=" + rating + ", timeStamp=" + timeStamp + "]";
	}
	private String timeStamp;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
