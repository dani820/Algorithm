package programmers.level1;

public class Programmers1 {
	// 행렬의 덧셈 
	// 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
	// 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
	// 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
	
	    public int[][] solution(int[][] arr1, int[][] arr2) {
	        int[][] answer = {}; // answer 배열 객체 생성 
	        answer = arr1; // arr1 배열을 answer 객체에 담는다.(차후 연산을 위해)
	        
	        for(int i = 0; i < arr1.length; i++) {
	            for(int j = 0; j < arr1[0].length; j++) { // 어차피 행과 열의 크기가 같은 행렬을 더하는 것이기 때문에
	            										  // 열에 해당하는 j 는 arr1 배열의 0번째 값의 길이만큼만 for 문을 돌려주면 된다. 
	                answer[i][j] += arr2[i][j]; // arr1 배열을 대입한 answer 배열에 i,j 좌표를 넣어주고 arr2 도 마찬가지로 좌표 잡아주어 더할 수 있게 한다.
	            }
	        }
	        return answer;
	    }
}
