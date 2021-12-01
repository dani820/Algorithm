package programmers.level1;

// board game
// A 게임은 4x4 격자 모양의 보드의 가장 왼쪽 위에서 가장 오른쪽 아래로 말을 이동시키면서 각 구역에 있는 코인을 획득하는 게임입니다. 
// 이때, 말은 오른쪽 또는 아래쪽으로만 이동할 수 있습니다.***
// 각 구역에서 획득할 수 있는 코인 양을 담은 2차원 배열 board가 매개변수로 주어질 때, 
// 최대로 획득할 수 있는 코인의 양을 return 하도록 solution 메소드를 작성했습니다.***
class Solution6 {
    public int solution(int[][] board) {
        int answer = 0;

        int[][] coins = new int[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(i == 0 && j == 0)
                    coins[i][j] = board[i][j]; // 시작 좌표이기 때문에 값 그대로 담는다.
                else if(i == 0 && j != 0)
                    coins[i][j] = board[i][j] + coins[i][j-1]; // 오른쪽으로 이동했을 경우 board 배열에서 이동 전 *왼쪽* 값과 현재 좌표 값 더해서 coins 배열에 넣기
                else if(i != 0 && j == 0)
                    coins[i][j] = board[i][j] + coins[i-1][j]; // 아래로 이동했을 경우 board 배열에서 이동 전 *위쪽* 값과 현재 좌표 값 더해서 coins 배열에 넣기
                else
                    coins[i][j] = board[i][j] + Math.max(coins[i][j-1], coins[i-1][j]); // 대각선으로 이동했을 때 수행할 구문으로 최대로 획득할 수 있는 코인 양을 구하는 것이기 때문에
                																		// 현좌표 위, 왼쪽 값을 비교하여 최대값을 구하고 더해 나간다.
            }
        }

        answer = coins[3][3]; // 해당 배열에는 최대로 획득할 수 있는 코인의 양이 담겨있다.
        return answer; // answer 에 담아 리턴
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. 아래에는 잘못된 부분이 없으니 위의 코드만 수정하세요.
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        int[][] board = {{6, 7, 1, 2}, {3, 5, 3, 9}, {6, 4, 5, 2}, {7, 3, 2, 6}};
        int ret = sol.solution(board);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}