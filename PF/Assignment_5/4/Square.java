package Shape;

/**
 * @author Nidhi
 *Description: This program contains a class square to draw circle and calculate area of circle 
 */
	public class Square implements Shape{

			private int side;

			public Square(int side) 
				{
					this.side = side;
				}
			//To draw square
			public void draw()
				{
					System.out.print("This is square");
				}
			//to calculate area of Square
			public double getArea() {
				return (side * side);
			}
		}

	


