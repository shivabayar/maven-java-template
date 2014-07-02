package com.hashedin;

public class Users {
	
	private int userId;
	private int age;
	private String gender;
	private String profession;
	private int zipcode;
	private int numberOfRatingsDoneCount = 0;
	
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", age=" + age + ", gender="
				+ gender + ", profession=" + profession + ", zipcode="
				+ zipcode + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getNumberOfRatingsDoneCount() {
		return numberOfRatingsDoneCount;
	}
	public void setNumberOfRatingsDoneCount() {
		this.numberOfRatingsDoneCount += 1;
	}
	
	

}
