package Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

/** 
 * @author Nidhi
 *a class for main function 
 */

public class MainClass {

		public static void printShape(Shape shape) {
			System.out.println(shape.getArea());
		}

		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int radius, side;
			System.out.println("Enter radius");
			radius = sc.nextInt();
			System.out.println("Enter side");
			side = sc.nextInt();
			Shape circleShape = new Circle(radius);
			Shape squareArea = new Square(side);
			System.out.println("area of circle is");
			printShape(circleShape);
			System.out.println("area of square is");
			printShape(squareArea);
			System.out.println("Execution through list");//Storing area of circle and square in List 
			List<Shape> shape = new ArrayList<Shape>();
			Shape CircleAgain = new Circle(radius);
			Shape SquareAgain = new Square(side);
			shape.add(CircleAgain);
			shape.add(SquareAgain);
			Iterator<Shape> itr = shape.iterator(); //To display each element of list
			while (itr.hasNext()) {
				Shape s1 = itr.next();
				s1.draw();
				printShape(s1);
			}
			sc.close();
		}

}

