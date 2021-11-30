package programmers.level1;

// Up and down
class Solution3 {
    public int solution(int K, int[] numbers, String[] UpDown) {
        int left = 1; // 5. numbers 배열의 원소는 1 이상 K 이하인 자연수이므로 최소값인 left 값을 1로 선정
        int right = K; // 6. 최대값 right 에 K 대입
        
        // 7. 참가자가 말한 숫자 배열과 출제자가 응답한 업다운 배열 비교하기
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if(UpDown[i].equals("UP")) // 8. 출제자가 UP 이라고 했을 경우 최소값인 left 값 지정
                left = (left > num) ? left : num; // 9. 삼항연산자 사용하여 값 대입
            										// 이 때 참가자가 말한 자연수는 처음 말했던 수보다 더 작은 값을 말하는 경우도 있음
            			 							// 이를 감안하여 연속 UP 이나 DOWN 일 경우 앞뒤 값을 비교해서 값을 넣어주어야함!!!!!
            										// 
            else if(UpDown[i].equals("DOWN")) // 10. UP 과 같은 방식으로 삼항연산자 사용하여 최대값 대입
                right = (right > num) ? num : right;
            else if(UpDown[i].equals("RIGHT")) // 11. 정답일 경우 1을 리턴
                return 1;
        }
        return (right - left)-1; // 12. 정답이 아닌 경우 정답일 수 있는 숫자 개수를 리턴
        						 // -1 해주는 이유는 정확한 개수를 구하기 위함
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int K1 = 10; // 1. 출제자가 정한 숫자는 10
        int[] numbers1 = {4, 9, 6}; // 2. 참가자가 말한 숫자 배열
        String[] UpDown1 = {new String("UP"), new String("DOWN"), new String("UP")}; // 3. 출제자가 말하는 up, down 배열로 참가자가 말한 숫자 배열과 길이 동일
        int ret1 = sol.solution(K1, numbers1, UpDown1); // 4. 위에서 선언한 값들을 모두 담아 정답이 될 수 있는 숫자 개수 혹은 정답일 경우 1을 리턴하는 메소드 호출
        												// 13. 리턴값 변수 담아 sysout 으로 출력
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int K2 = 10;
        int[] numbers2 = {2, 1, 6};
        String[] UpDown2 = {new String("UP"), new String("UP"), new String("DOWN")};
        int ret2 = sol.solution(K2, numbers2, UpDown2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

        int K3 = 100;
        int[] numbers3 = {97, 98};
        String[] UpDown3 = {new String("UP"), new String("RIGHT")};
        int ret3 = sol.solution(K3, numbers3, UpDown3);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret3 + " 입니다.");
    }
}