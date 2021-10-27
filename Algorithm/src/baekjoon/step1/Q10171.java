package baekjoon.step1;

public class Q10171 {

	public static void main(String[] args) {
		// 고양이 출력하기
		// 특수문자 입출력 유의할 것
		// 역슬래시(\)는 \\ 형태로 작성해주어야 '\' 형태로 출력된다.
		// 홑따옴표, 쌍따옴표 또한 마찬가지로 \' or \" 형태로 작성해주어야 원하는대로 출력된다.
		// 괄호나 일반 슬래시는 \ 를 붙이지 않아도 그대로 출력된다.

		// ver. 1
		System.out.println("\\    /\\");
		System.out.println(" )  ( \')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|");
		
		System.out.println();
		
		// ver. 2
		System.out.println("\\    /\\\n )  ( \')\n(  /  )\n \\(__)|");                
		
		
	}

}
