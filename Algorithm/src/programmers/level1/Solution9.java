package programmers.level1;
// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

// blooming

class Solution9 {
	 public int solution(int[] arr, int K) {
	        // 여기에 코드를 작성해주세요.
	        Arrays.sort(arr); // 1. 배열 오름차순 정렬
	        int answer = arr[arr.length-1]; // 2. 배열에서 가장 큰 수로 초기화
	        int checkLen = arr.length-K; // 3. for문 돌릴 횟수 ex) 6-4 = 0,1,2 총 3회
	        
	        for(int i = 0; i <= checkLen; i++) { // 4. point는 <= 임
	            if(answer > arr[i+(K-1)]-arr[i]) // 가장 큰 수 - 가장 작은 수 가 최대 원소 값보다 작으면
	                answer = arr[i+(K-1)] - arr[i]; // answer 변수에 해당 조건을 대입, 비교를 통해 가장 최소 차이의 수 최종 반환
	        }
	        
	        return answer;
	        
	    }

	    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	    public static void main(String[] args) {
	    	Solution9 sol = new Solution9();
	        int[] arr = {9, 11, 9, 6, 4, 19};
	        int K = 4;
	        int ret = sol.solution(arr, K);

	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("solution 메소드의 반환 값은 " + ret + "입니다.");
	    }
}