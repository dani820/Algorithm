package programmers.level1;

public class Programmers10 {
	// 짝수와 홀수
	// 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
	// 제한 조건
	// num은 int 범위의 정수입니다.
	// 0은 짝수입니다.
	
	 public long solution(long n) {
	        long answer = 0;
	        String num = String.valueOf(n);
	        char temp;
	        
	        for(int i = 0; i < num.length(); i++) {
	            if(num.charAt(i) < num.charAt(i+1)) {
	            	char what = num.charAt(i);
	            	char what2 = num.charAt(i+1);
	            	
	                temp = what;
	                what = num.charAt(i+1);
	                what2 = temp;    
	            }
	            answer = Long.parseLong(num);
	        }
	        return answer;
	    }
}
