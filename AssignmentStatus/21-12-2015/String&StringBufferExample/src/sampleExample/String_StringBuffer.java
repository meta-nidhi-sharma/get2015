package sampleExample;

public class String_StringBuffer {
	public static void main(String args[]) {
		String str = "Hello";
		
		str.concat("World");
		System.out.println("String is immutable so 'world' is not appended : " + str);
		
		str = str.concat("Nidhi");
		System.out.println("String is immutable so created new instance of this string : " + str);
	}
}
