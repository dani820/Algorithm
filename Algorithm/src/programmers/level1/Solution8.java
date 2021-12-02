package programmers.level1;
// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

// blooming

class Solution8 {
	public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0; // 모든 꽃을 피우는데 걸리는 일수
        int num = garden.length; // 매개변수로 받은 현 정원의 길이를 num 에 저장
        int[][] nGarden = new int[num][num]; // 현 정원의 길이와 동일한 2차원 배열 nGarden 생성
        
        boolean loop = true; // while 문 동작에 필요한 boolean 형 객체 생성
        
        while(loop) {
            loop = false; // true 여야 while 문 동작. for문이 한 차례 돌면 while 문 종료
            
            // garden 배열을 nGarden 에 복사하면서 꽃 피우기
            for(int i = 0; i < num; i++) {
                for(int j = 0; j < num; j++) {
                    if(garden[i][j] == 1) { // 원소가 1이면 꽃 피우기(0을 1로 바꾸기)
                        nGarden[i][j] = 1; // 동일한 좌표 값으로 nGarden 에 우선 복사
                        
                        if(i-1 >= 0 && garden[i-1][j] == 0) 
                            nGarden[i-1][j] = 1; // 상
                        if(i+1 < num && garden[i+1][j] == 0)
                            nGarden[i+1][j] = 1; // 하
                        if(j-1 >= 0 && garden[i][j-1] == 0)
                            nGarden[i][j-1] = 1; // 좌
                        if(j+1 < num && garden[i][j+1] == 0)
                            nGarden[i][j+1] = 1; // 우
                        
                        // 상하좌우 동작 수행 후
                    }else {
                        loop = true; // garden[i][j] 원소가 0이면 계속해서 루프를 돌 수 있도록 loop를 true 로 바꿔준다.
                    }    
                }
            }
            if(loop) { // for 문이 끝났을 때 loop 값에 따라 실행 여부 정해짐
                       // if문 조건식은 loop == true 임.
                       // 값의 변동 전혀 없었다면 while문 첫 시작처럼 loop 값은 false로 유지되고 해당 if문을 실행하지 않음
                       // 그러나 만약 원소 값이 0인 즉, 꽃 피워야 할 원소 0이 남아있을 때
                       // loop 값은 true 가 되기 때문에 if 문 실행되고 날짜 증가한다.
                
                answer++; // 하루 증가

                // for 문 이용하여 nGarden 에 새로 저장한 꽃 피운 정원을
                // arraycopy 메소드로 현 정원인 garden 배열에 deep copy 하여 상태를 저장하고
                // 모든 원소가 0에서 1로 바뀔 때까지 변경 상태를 저장하며 동작할 수 있도록 한다.
                for(int k = 0; k < num; k++) {
                    System.arraycopy(nGarden[k], 0, garden[k], 0, num);
                }
            }
        }
        
        
        return answer;
    }
    
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
    	Solution8 sol = new Solution8();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        
    }
}