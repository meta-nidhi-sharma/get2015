package Shape;

/**
 * @author Nidhi
 *Description: This program contains a class Circle to draw circle and calculate area of circle 
 */
public class Circle implements Shape {

		private int radius;

		public Circle(int radius)
			{
				this.radius = radius;
			}
		// to draw circle
		public void draw()
			{
				System.out.println("This is circle");
			}

		//to calculate area of circle
		public double getArea()
			{
				return (3.14 * radius * radius);
			}

}
