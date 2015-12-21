package CustomExceptionExample;

public class SampleExceptionHandling {

	public static void main(String args[]) {
		SampleExceptionHandling s = new SampleExceptionHandling();
		s.A();
	}

	public void A() {

		int age = 13;
		if (age < 18) {
			try {
				throw new CustomException(
						"Exception occured in B : Arithmetic Excetion");
			} catch (CustomException e) {

				System.out.println(e);
			}
		}
	}
}
