package doit.chap01;

import java.util.Scanner;

class Max3 {

	// 최대값을 여러 번 반복해서 구하는 경우 메소드로 처리하면 편리 
	static int max3(int a, int b, int c) {
		int max = a;
		if(b > max)
			max = b;
		if(c > max)
			max = c;
		
		return max;
	}
	
	static int max4(int a, int b, int c, int d) {
		int max = a;
		if(b > max) 
			max = b;
		if(c > max)
			max = c;
		if(d > max)
			max = d;
		
		return max;
	}
	
	static int min3(int a, int b, int c) {
		int min = a;
		if(b < min) 
			min = b;
		if(c < min)
			min = c;
		
		return min;
	}
	
	static int min4(int a, int b, int c, int d) {
		int min = a;
		
		if(b < min)
			min = b;
		if(c < min)
			min = c;
		if(d < min)
			min = d;
		
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println("max3(3,2,1) = " + max3(3,2,1));
		System.out.println("max3(3,2,2) = " + max3(3,2,2));
		System.out.println("max3(3,1,2) = " + max3(3,1,2));
		System.out.println("max3(3,2,3) = " + max3(3,2,3));
		System.out.println("max3(2,1,3) = " + max3(2,1,3));
		System.out.println();
		System.out.println("max4(2,1,5,8) = " + max4(2,1,5,8));
		System.out.println("max4(2,1,0,2) = " + max4(2,1,0,2));
		System.out.println("max4(2,1,6,5) = " + max4(2,1,6,5));
		System.out.println();
		System.out.println("min3(2,1,5) = " + min3(2,1,5));
		System.out.println("min3(2,1,0) = " + min3(2,1,0));
		System.out.println("min3(2,1,6) = " + min3(2,1,6));
		System.out.println();
		System.out.println("min4(2,4,5,5) = " + min4(2,4,5,5));
		System.out.println("min4(2,1,9,8) = " + min4(2,1,9,8));
		System.out.println("min4(4,9,6,3) = " + min4(4,9,6,3));
		
	}

}
