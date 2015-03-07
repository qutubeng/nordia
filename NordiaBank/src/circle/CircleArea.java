package circle;

/*
 * Qutub Uddin Ahmed
 * Problem:
 * 2. Write a function that will calculate the area of a circle
 */

public class CircleArea {
	
	private static double calculateCircleArea(double radious) {
		
		double circleArea = Math.PI * Math.pow(radious,2);
		return circleArea;
	}

	public static void main(String[] args) {
		System.out.println(calculateCircleArea(5));
	}
}

//jh
