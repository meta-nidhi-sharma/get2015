package assignment_5;

/**
author: Nidhi Sharma
Description: This program contains a class person, which takes unique ID and name as input and print them on output     

*/


public class Person {

	private int uid;
	private String name;
	public Person(int uid, String name)
		{
			this.uid=uid;
			this.name =name;
		}
	
	public int getUid()                    //To get UID
		{
		return uid;
		}
	
	public void setUid(int uid)             //To set UID
		{
			this.uid=uid;
		}
	
	public String getName()                    //To get Name
		{
			return name;
		}
		
	public void setName(String name)           //To set Name
		{
			this.name=name;
		}
	
	public String toString()                         //returning String whicj gives name and uid of person
		{
			return "Name: "+name+"\nuid: "+uid+"\n";
		}
	
}
