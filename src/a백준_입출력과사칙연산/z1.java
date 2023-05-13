package a백준_입출력과사칙연산;

import java.util.Random;

public class z1 {
	
		public static void main(String[] args) {
	        Random random = new Random();
	        int A = random.nextInt(100);
	        int B = random.nextInt(100);
	        System.out.println("A: " + A);
	        System.out.println("B: " + B);
	        System.out.println("A - B: " + (A - B));
	    }
	}