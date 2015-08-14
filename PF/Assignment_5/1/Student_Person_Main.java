package assignment_5;

/**
 * @author Nidhi
 *This class is main class containing main function
 */

public class Student_Person_Main {

	public static void main(String args[])          
	{
		String name,Show;
		String course[]={"chemistry","Physics"};
		String showCourse[];
		java.util.Scanner sc= new java.util.Scanner(System.in);
		System.out.println("Enter name, uid, studentID,");
		name=sc.next();
		int uID = sc.nextInt();
		int studentID= sc.nextInt();
		Person obj=new Student(uID,name,studentID);
		Show=obj.toString();
		System.out.println(Show);//to show name uid and student_id
		Student obj1=new Student(uID,name,studentID);
		obj1.setCourses(course);
		showCourse=obj1.getCourses();//to show courses
		for(int i=0;i<course.length;i++)
		{
		System.out.println(showCourse[i]);
		}
		sc.close();
		}
}

