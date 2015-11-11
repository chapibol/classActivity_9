package classActivity_9;

import java.util.*;

public class Student {
	public final static int MAX = 100;
	public final static String[] COURSE_LIST = {"IT106","IT206" , "IT306","IT212","IT213","IT214","COMM100","MATH112","IT293"};
	public final static String LIST= "IT106,IT206,IT306,IT212,IT213,IT214,COMM100,MATH112,IT293";
	Map<String, String> courseList = new Hashtable<String, String>();
	Map<String, Double> courseGrades = new Hashtable<String, Double>();
	private String name; 
	private String address; 
	private String major;
	private int id; 
	private int numCourses;
	private static int totalStudent; 
	
	public Student(){
//		courseGrades = new double[MAX];
//		courses = new String[MAX];
		this.numCourses = 0;
		totalStudent++; 
		this.id = totalStudent;
	}
	public void setName(String name) {this.name = name;}
	public void setAddress(String address) { this.address = address; }
	public void setMajor(String major) {this.major = major; }
	
	public boolean setCourse(double grade, String course){
		if(numCourses >= MAX) return false;
		for(int i=0; i<COURSE_LIST.length; i++){
			if(COURSE_LIST[i].equalsIgnoreCase(course)){
				courseGrades[numCourses]=grade;
				courses[numCourses++]=course;
				return true; 
			}
		}
		
		return false;
	}
	
	public String getName() { return name; }
	public String  getAddress(){ return address; }
	public String getMajor(){ return major; }
	public static int getTotalStudents(){ return totalStudent; }
	public int getNumCourses(){ return numCourses;}
	public int getId(){ return id;}
	
	public double getGrade(String course) {
		for(int i= 0;i<COURSE_LIST.length; i++){
			if(COURSE_LIST[i].equalsIgnoreCase(course)){
				double grade = courseGrades[i]; 
				return grade;
			}
		}
		return -1;
	}
	

}
