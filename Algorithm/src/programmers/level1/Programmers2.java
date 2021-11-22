package programmers.level1;

public class Programmers2 {
	// x만큼 간격이 있는 n개의 숫자
	// 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
	// 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
	// 제한 조건
	// x는 -10000000 이상, 10000000 이하인 정수입니다.
	// n은 1000 이하인 자연수입니다.
	
	class Solution {
	    public long[] solution(int x, int n) {
	        long[] answer = new long[n]; // answer 배열의 초기값을 넣어주기 위해 배열 초기화를 해준다.
	        answer[0] = x; // 0번째 값으로 x 를 넣어준다.
	        
	        for(int i = 1; i < n ; i++) { // answer 배열 0번째 값이 이미 들어가있으므로 i 는 1 부터 시작하고 숫자를 총 n 개 지 리스트이므로 조건식 최대값 n 으로 잡아준다.
	            answer[i] = answer[i-1] + x; // 1번째 값부터 넣어주는 식이기 때문에 이전 값에 x 만큼 더해준다.
	        }
	        
	        return answer;
	    }
	}
}
