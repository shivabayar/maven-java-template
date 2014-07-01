package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class MoviesManager {
	
	
	public InputStream readDataFile(String fileName){
		System.out.println("working");
		
		InputStream moviesInputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		return moviesInputStream;
	}
	
	public Map<Integer,Movies> convertInputStreamToMap(InputStream moviesInputStream){
		Map<Integer,Movies> moviesMap = new HashMap<Integer,Movies>();
		
		try {
			
			List<String> lines = IOUtils.readLines(moviesInputStream);
			
			for(String line : lines){
				Movies m = new Movies();
				
				m = parseLine(line);
				moviesMap.put(m.getId(),m);
				
//				System.out.println(moviesMap);
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return moviesMap;
	}
	
	public Movies parseLine(String line){
		
		StringTokenizer st = new StringTokenizer(line,"|");
		Movies m = new Movies();

		if(st.hasMoreTokens()){
			m.setId(Integer.parseInt(st.nextToken()));
			m.setName(st.nextToken());
			m.setRelease(st.nextToken());
			m.setUrl(st.nextToken());
		}
		
		return m;
	}
	
	
	

}
