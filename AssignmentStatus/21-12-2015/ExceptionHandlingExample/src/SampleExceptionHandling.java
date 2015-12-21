public class SampleExceptionHandling {

	public static void main(String args[]) {
		SampleExceptionHandling s = new SampleExceptionHandling();
		s.A();
	}

	public void A() {
		try {
			B();
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}

	public void B() throws ArithmeticException {
		int i = 50 / 0;
		System.out.println(i);
	}

}
