package com.hashedin;

import java.util.ArrayList;

public class Movies {

	private int id;
	private String name;
	private String release;
	private String url;
	private ArrayList<String> genre;
	private int totalRating = 0;
	private int ratingsCount = 0;
	private float averageRating = 0;
	private int year ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<String> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name + ", release=" + release
				+ ", url=" + url + ", genre=" + genre + "]";
	}

	public int getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount() {
		
		this.ratingsCount += 1;
	}
	public int getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(int totalRating) {
		this.totalRating += totalRating;
	}
	public float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
