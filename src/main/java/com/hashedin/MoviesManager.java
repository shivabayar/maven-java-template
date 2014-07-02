package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;


/*
 * Manager for the Movies class
 * */


public class MoviesManager {
	
	/*
	 * Reading the data file. 
	 * @param File Name @type string
	 * @return Input Stream @type InputStream*/
	
	public InputStream readDataFile(String fileName){
//		System.out.println("working");
		
		InputStream moviesInputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		return moviesInputStream;
	}
	
	/**
	 * Converting the InputStream to a map in which key: Movie ID, value: Movies Object
	 * @param moviesInputStream @type InputStream
	 * @return HashMap<Integer,Movies>()*/
	public Map<Integer,Movies> convertInputStreamToMap(InputStream moviesInputStream){
		
		Map<Integer,Movies> moviesMap = new HashMap<Integer,Movies>();
		
		try {
			
			List<String> lines = IOUtils.readLines(moviesInputStream);
			
			for(String line : lines){
				Movies movies = new Movies();
				
				movies = parseLine(line);
				moviesMap.put(movies.getId(),movies);
				
//				System.out.println(moviesMap);
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return moviesMap;
	}
	
	public Movies parseLine(String line){
		
		StringTokenizer st = new StringTokenizer(line,"|");
		Movies movies = new Movies();
		ArrayList<String> genre = new ArrayList<String>();

		if(st.hasMoreTokens()){
			movies.setId(Integer.parseInt(st.nextToken()));
			movies.setName(st.nextToken());
			movies.setRelease(st.nextToken());
			movies.setUrl(st.nextToken());
			
		
			
			
			int count = 0;
			while(st.hasMoreTokens()){
			
			int tempGenre = Integer.parseInt(st.nextToken());
//			System.out.println(tempGenre);
				if(tempGenre == 1 && count < 19){
					switch(count){
						case 0 : genre.add("unknown");
						break;
						case 1 : genre.add("Action");
						break;
						case 2 : genre.add("Adventure");
						break;
						case 3 : genre.add("Animation");
						break;
						case 4 : genre.add("Children");
						break;
						case 5 : genre.add("Comedy");
						break;
						case 6 : genre.add("Crime");
						break;
						case 7 : genre.add("Documentary");
						break;
						case 8 : genre.add("Drama");
						break;
						case 9 : genre.add("Fantasy");
						break;
						case 10 : genre.add("Film-Noir");
						break;
						case 11 : genre.add("Horror");
						break;
						case 12 : genre.add("Musical");
						break;
						case 13 : genre.add("Mystery");
						break;
						case 14 : genre.add("Romance");
						break;
						case 15 : genre.add("Sci-Fi");
						break;
						case 16 : genre.add("Thriller");
						break;
						case 17 : genre.add("War");
						break;
						case 18 : genre.add("Western");
						break;
						
						default: 
						
						
					}
				}
//				System.out.println(count);
				++count;
				
			}
			
			
		}
		movies.setGenre(genre);
		
		return movies;
	}
	
	public ArrayList<String> generateGenre(){
	
		return null;
	}
	
	
	

}
