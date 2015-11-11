/**
 * Group Member 1: Luis Velascco - Email:  GNumber:  
 * Group Member 2: Larry Hong - Email:  GNumber: 
 * Group Member 3: Peter Alvarado Nunez - Email:  GNumber:
 * Group Leader: Larry Hong
 * Date: 11-12-2015
 * Course: IT 306 - 001
 * Class Activity 9
 */
package classActivity_9;

/*
 * In this application, course list for students is implemented using parallel arrays.  
 * List of university courses is also represented with an array.
 * For this Activity, add/make the required changes so that the complexity of the accessing course grade is improved to  O(1). 
 * hint: use Map instead of array structure.
 * Upload all YOUR java files (those you created/modified/used). 
 */

import java.util.*;

import javax.swing.JOptionPane;

public class UniversityApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Student> studentsRecords = new HashMap<Integer, Student>();
		String menu ="1- Add Student\n2-Show a student grade\n3-Exit.";
		int option = 0;
		double grade=-1; 
		do{
			option = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch(option){
			case 1:
				Student s = getInput();
				studentsRecords.put(s.getId(), s);   //adding student to hashmap
				break;
			case 2:
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter an id number between 1 and " + Student.getTotalStudents()) );
				if(studentsRecords.containsKey(new Integer(id))){
					s = studentsRecords.get(new Integer(id));  //retrieving student from hashmap
					String course="";
					do{
						course = JOptionPane.showInputDialog("Enter course title from the list " + Student.LIST.toString()); 
						grade = s.getGrade(course);
					}while(grade==-1);
					JOptionPane.showMessageDialog(null, "Grade for course "+course + " is: "+ grade);
				}
				else{
					JOptionPane.showMessageDialog(null, "This id number does not exist.");
				}
				break;
			case 3:
				System.exit(0); 
			}
		}while(true);

	}
	
	public static Student getInput(){
		Student s = new Student(); 
		s.setName(JOptionPane.showInputDialog("Enter student name."));
		s.setMajor(JOptionPane.showInputDialog("Enter student major."));
		do{
			String course = null;
			double grade=-1;
			boolean flag = true;	
			course = JOptionPane.showInputDialog("Enter course title from the list of " + Student.LIST.toString()); 
			do{
				try{
					grade = Double.parseDouble(JOptionPane.showInputDialog("Enter a grade for course " + course)); 
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You must provide a numeric value."); 
					flag= false;
				}
			}while(!flag);
			if(!s.setCourse(grade, course))
				JOptionPane.showMessageDialog(null, "This course does not exist in the course list.");
		}while(JOptionPane.showConfirmDialog(null, "Add another course?") == JOptionPane.YES_OPTION); 
		
		return s;
	}

}
