package sampleExample;

public class StringBuffer_StringBuilderExample {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		StringBuffer stringBuffer = new StringBuffer("Hello");
		for (int i = 0; i < 10000; i++) {
			stringBuffer.append("World");
		}
		System.out.println("Time taken by StringBuffer: "
				+ (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("Hello");
		for (int i = 0; i < 10000; i++) {
			stringBuilder.append("World");
		}
		System.out.println("Time taken by StringBuilder: "
				+ (System.currentTimeMillis() - startTime) + "ms");
	}
}