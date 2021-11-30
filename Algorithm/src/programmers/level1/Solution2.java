package programmers.level1;

// 지그재그 부분 수열 
class Solution2 {
    final int INC = 0; // '증가'를 뜻하는 상수
    final int DEC = 1; // '감소'를 뜻하는 상수
    
    // 12. 지그재그 수열이 가장 긴 것의 길이를 담은 배열 만드는 메소드
    int[] func_a(int[] arr) {
        int length = arr.length; // 13. 매개변수로 받은 증감 배열 길이를 length 변수에 대입
        int[] ret = new int[length]; // 14. 증감 배열의 길이만큼 ret 배열 생성
        ret[0] = 1; // 15. 첫 번째 숫자의 길이는 1로 초기화 
        for(int i = 1; i < length; i++) {
            if(arr[i] != arr[i-1]) // 16. 현재 숫자가 이전 숫자와 같지 않으면 길이 배열 ret[i] 에 이전 숫자 + 1 한 값을 대입
                ret[i] = ret[i-1] + 1;
            else
                ret[i] = 2; // 17. 현재 숫자가 이전 숫자와 같으면 최대길이인 2를 대입
        }
        return ret; // 18. 지그재그 수열 길이를 담은 배열 리턴
    }

    // 3. 증가, 감소 확인용 배열 만드는 메소드
    int[] func_b(int[] arr) {
        int length = arr.length; // 4. 매개변수 S 배열의 길이를 length 변수에 대입한다.
        int[] ret = new int[length]; // 5. S 배열의 길이와 동일한 int 배열 ret 을 생성한다.
        ret[0] = -1; // 6. 배열의 첫 번째 숫자는 증가도 감소도 하지 않았다는 의미에서 -1 로 표시한다.
        
        // 7. 배열 길이만큼 for 문을 돌려서 증가, 감소 상수 이용하여 생성하기
        // i 가 1부터 시작하는 이유는 이미 배열의 첫 번째 숫자를 지정했기 때문.
        for(int i = 1; i < length; i++) {
            if(arr[i] > arr[i-1]) // 8. arr[1] 값이 이전 숫자인 arr[0] 보다 크면 증감배열 ret[1] 에 증가 상수 INC 값 대입 
                ret[i] = INC;
            else if(arr[i] < arr[i-1]) // 9. arr[1] 값이 이전 숫자인 arr[0] 보다 작으면 증감배열 ret[1] 에 감소 상수 DEC 값 대입
                ret[i] = DEC;
        }
        return ret; // 10. 증감 배열 완성하여 리턴
    }
    
    // 20. 매개변수로 받은 배열 안에서 최댓값 구하는 메소드
    int func_c(int[] arr) {
        int length = arr.length; // 21. 배열 길이 length 변수에 대입하기 
        int ret = 0; // 22. 최댓값 담을 ret 변수 초기화
        for(int i = 0; i < length; i++)
            if(ret < arr[i]) // 23. 배열 길이만큼 for문 돌려서 ret 에 길이값 담아가며 제일 큰 수 나올 때까지 값 비교
                ret = arr[i];
        if(ret == 2) // 24. 길이가 3 이상인 부분 수열들만 골라야 하므로 최댓값이 2면 0을 리턴하도록 한다.
            return 0;
        return ret; // 25. 최댓값 리턴
    }

    public int solution(int[] S) {
        int[] check = func_b(S); // 2. 증가, 감소 확인용 배열 만들기
        int[] dp = func_a(check); // 11. 완성된 증감 배열을 매개변수로 지그재그 수열 중 가장 긴 것의 길이를 담은 배열 만들기
        int answer = func_c(dp); // 19. 지그재그 수열 길이를 담은 배열을 매개변수로 최댓값 구하는 메소드 호출
        return answer; // 26. 최댓값 리턴
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] S1 = {2, 5, 7, 3, 4, 6, 1, 8, 9};
        int ret1 = sol.solution(S1); // 1. S1 배열을 매개변수로 solution 메소드 호출
        							 // 27. 최댓값 ret1 에 담아 sysout 으로 출력

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] S2 = {4, 3, 2, 1, 10, 6, 9, 7, 8};
        int ret2 = sol.solution(S2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

        int[] S3 = {1, 2, 3, 4, 5};
        int ret3 = sol.solution(S3);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret3 + " 입니다.");
    }
}