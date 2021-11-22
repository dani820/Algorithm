package baekjoon.step1;

import java.util.Scanner;

public class Q1000 {
	public static void main(String[] args) {
		// Scanner 의 객체명으로 가장 많이 쓰이는 것은 in, scan, sc 이다.
		// 공개 소스의 경우 한 번에 이해하기 쉽도록 트렌드에 맞게 많이 쓰는 객체명을 쓰는 것이 좋다.
		
		Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
	        
        System.out.println(num1 + num2);
	}

}
