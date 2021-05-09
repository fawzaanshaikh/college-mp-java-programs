package com.mitadt.practice;

import java.util.Scanner;

public class Circle {
	
	private int radius;
	
	private Circle(int radius) {
		this.radius = radius;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the radius of the circle : ");
		int radius = sc.nextInt();
		
		Circle c = new Circle(radius);
		
		final double PI = 3.141;
		
		System.out.println("The circumference of the circle is " + (2 * c.radius * PI));
		System.out.println("The area of the circle is " + (c.radius * c.radius * PI));
		
		sc.close();
	}

}
