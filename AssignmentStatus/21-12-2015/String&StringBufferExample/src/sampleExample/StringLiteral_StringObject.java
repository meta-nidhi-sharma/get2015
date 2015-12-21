package sampleExample;

public class StringLiteral_StringObject {

	public static void main(String args[]) {
		String stringLiteral1 = "HelloWorld";
		String stringLiteral2 = "HelloWorld";
		if (stringLiteral1 == stringLiteral2) {
			System.out
					.println("String literals pointing to same value in pool");
		}
		else{
			System.out
			.println("String literals pointing to different value in pool");
		}

		String stringObject1 = new String("Hello World");
		String stringObject2 = new String("Hello World");
		if (stringObject1 == stringObject2) {
			System.out
					.println("String objects pointing to same reference in heap ");
		} else {
			System.out
					.println("String objects pointing to different reference in heap ");
		}
	}
}
