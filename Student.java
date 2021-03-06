/**
 * Group Member 1: Luis Velascco 
 * Group Member 2: Larry Hong
 * Group Member 3: Peter Alvarado Nunez
 * Group Leader: Larry Hong
 * Date: 11-12-2015
 * Course: IT 306 - 001
 * Class Activity 9
 */
package classActivity_9;

import java.util.*;

public class Student {
	public final static int MAX = 100;
	public final static String LIST= "IT106,IT206,IT306,IT212,IT213,IT214,COMM100,MATH112,IT293";
	Map<String, String> courseList = new Hashtable<String, String>(){{
		put("IT106", "IT106");
		put("IT206", "IT206");
		put("IT306", "IT306");
		put("IT212", "IT212");
		put("IT213", "IT213");
		put("IT214", "IT214");
		put("IT293", "IT293");
		put("COMM100", "COMM100");
		put("MATH112", "MATH112");
	}};
	private String name; 
	private String address; 
	private String major;
	Map<String, Double> courseGrades = new Hashtable<String, Double>();
	private int id; 
	private int numCourses;
	private static int totalStudent; 
	
	public Student(){
		this.numCourses = 0;
		totalStudent++; 
		this.id = totalStudent;
	}
	public void setName(String name) {this.name = name;}
	public void setAddress(String address) { this.address = address; }
	public void setMajor(String major) {this.major = major; }
	
	public boolean setCourse(double grade, String course){
		if(numCourses >= MAX){
			return false;
		}
		//If statement to check if the course to be added is part of the course list.
		//The toUpperCase allows the user to enter the course number in lower case without errors.
		if(!courseList.containsValue(course.toUpperCase())){
			return false;
		}
		else{
			//If the course is valid then place it inside the hash table and increment the numCourses.
			//The course will be store in upper case to match the format of the key.
			courseGrades.put(course.toUpperCase(), grade);
			numCourses++;
			return true;
		}
	}
	
	public String getName() { return name; }
	public String  getAddress(){ return address; }
	public String getMajor(){ return major; }
	public static int getTotalStudents(){ return totalStudent; }
	public int getNumCourses(){ return numCourses;}
	public int getId(){ return id;}
	
	public double getGrade(String course) {
		//If statement to check if the student has that course in their hash table. The toUpperCase
		//allows the user to enter the course number in lower case without causing errors. The contains key
		//is used, because if there is no key then there is no grade associated with that course.
		if(!courseGrades.containsKey(course.toUpperCase())){
			return -1;
		}
		//If the course is in the list then the grade is returned. The toUpperCase
		//allows for the retrieval of the grade even the user used lower case letters.
		else{
			return courseGrades.get(course.toUpperCase());
		}
	}
}
