package programmers.level1;

// 종이접기(origami)
// 4 x 4 크기인 정사각형 종이가 1 x 1 크기인 격자 칸으로 나누어져 있습니다.
// 이 종이를 가로축 혹은 세로축에 평행한 격자 선을 따라 한 번 접었을 때, 만나는 격자 칸에 적힌 숫자의 합이 최대가 되도록 하려 합니다.
// 종이를 접을 때는 만나는 격자 칸이 정확히 일치하도록 해야 합니다.
// 종이는 점선 중 하나를 따라서 접을 수 있습니다. 이때, 붉은색 점선을 따라 종이를 접으면 36과 19가 적힌 칸이 정확히 만납니다. 두 숫자의 합은 55이며, 이때가 최댓값입니다.
// 4 x 4 크기인 정사각형 종이의 각 격자 칸에 적힌 숫자가 담긴 배열 grid가 매개변수로 주어질 때,
// 종이를 접었을 때 만나게 되는 격자 칸에 적힌 숫자의 합 중 최댓값을 return 하도록 solution 메소드를 작성했습니다.
// 각 격자칸에 적힌 수는 1 이상 100 이하인 자연수입니다.

class Solution5 {
    public int solution(int[][] grid) {
        int answer = 0; // 1. 리턴할 최대값 담을 변수
        for(int i = 0; i < 4; i++) // 2. 4*4 크기 만큼 for 문 돌리기
            for(int j = 0; j < 4; j++)
                for(int k = j + 1; k < 4; k += 2)
                	// 대칭을 생각하기*****
                	// 최대값을 answer에 넣으면서 비교하고 더 큰 수로 계속 대체되는 형태
                	// 최대값을 비교할 값들은 answer, 이웃하는 수 기준 접합 값 구하기, 대칭하고 있는 수 기준 접합 값 구하기
                	// 대칭성을 고려하여 좌표를 뒤집어준다.
                	// CATCH!!!!!
                    answer = Math.max(answer, Math.max(grid[i][j] + grid[i][k], grid[j][i] + grid[k][i]));
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. 아래에는 잘못된 부분이 없으니 위의 코드만 수정하세요.
    public static void main(String[] args) {
    	Solution5 sol = new Solution5();
        int[][] grid = {{1, 4, 16, 1}, {20, 5, 15, 8}, {6, 13, 36, 14}, {20, 7, 19, 15}};
        int ret = sol.solution(grid);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
        
       
    }
}