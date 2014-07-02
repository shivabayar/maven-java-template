package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

/**
 * Manager for users class*/

public class UsersManager {


	/*
	 * Reading the data file. 
	 * @param File Name @type string
	 * @return Input Stream @type InputStream*/
	public InputStream readDataFile(String fileName){
//		System.out.println("working");
		
		InputStream usersInputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		return usersInputStream;
	}
	
	/**
	 * Converting the InputStream to a map in which key: User ID, value: Users Object
	 * @param moviesInputStream @type InputStream
	 * @return HashMap<Integer,Users>()*/
	public Map<Integer,Users> convertInputStreamToMap(InputStream usersInputStream){
		
		Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
		
		try {
			
			List<String> lines = IOUtils.readLines(usersInputStream);
			
			for(String line : lines){
				Users users = new Users();
				
				users = parseLine(line);
				usersMap.put(users.getUserId(),users);
				
//				System.out.println(moviesMap);
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return usersMap;
	}
	
	public Users parseLine(String line){
		
		StringTokenizer st = new StringTokenizer(line,"|");
		Users users = new Users();

		if(st.hasMoreTokens()){
			users.setUserId(Integer.parseInt(st.nextToken()));
			users.setAge(Integer.parseInt(st.nextToken()));
			users.setGender(st.nextToken());
			users.setGender(st.nextToken());
			users.setGender(st.nextToken());
		}
		
		return users;
	}
}
