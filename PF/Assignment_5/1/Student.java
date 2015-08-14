package assignment_5;
/**
author: Nidhi Sharma
Description: This program contains a class which inherit person class and takes student ID as input while at
             output it gives a string which consist oh student ID along with persom name and UID.
*/

public class Student extends Person{

	private int studentID;
	private String[] courses;
	
	public Student(int uid, String name, int studentID) 
		{
			super(uid, name);
			this.studentID=studentID;
		}

	public int getStudentID()                      //To get StudentID
		{
			
			return studentID;
		}
	
	public void setStudentID(int studentID)         //To set studentID
		{
			this.studentID=studentID;
		}
		
	public String[] getCourses()                   //To get courses opted by student
		{
			return courses;
		}
	
	public void setCourses(String[] courses)        //To set courses
		{
			this.courses=courses;
		}
	
	public String toString()                        //To return string which consist  of studentID
		{
			return super.toString()+"StudentID: "+studentID;
		}
	
	
}
