// DecimalFormat example

import java.util.Scanner;
import java.text.DecimalFormat;

public class CircleArea {
	public static void main(String[] args) {
		double radius, circumference, area;
		
		Scanner myScan = new Scanner(System.in);
		
		System.out.print("Enter the radius of the circle: ");
		radius = myScan.nextDouble();
		
		area = Math.PI * Math.pow(radius, 2);
		circumference = 2 * Math.PI * radius;
		
		DecimalFormat DForm = new DecimalFormat("0.###");
		
		System.out.println("The area of the circle is: " + DForm.format(area));
		System.out.println("The circumference of the circle is: " + DForm.format(circumference));		
	}
}
