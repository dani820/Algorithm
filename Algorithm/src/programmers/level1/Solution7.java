package programmers.level1;

// Card Shuffle
// 1부터 n까지 숫자가 적힌 카드 뭉치를 다음 규칙에 따라 카드 뭉치를 섞었을 때, 아래에서부터 k번째에 있는 카드에 적힌 숫자를 알아내려합니다.
// 카드 뭉치 가장 아래에는 1이 쓰여있으며, 위로 갈수록 숫자가 커집니다. 카드 뭉치를 섞는 규칙은 다음과 같습니다.
// 1. 카드 뭉치를 정확히 반으로 나눕니다.
// 2. 두 개로 나뉜 카드 뭉치를 교차로 섞어서 카드 뭉치 하나를 만듭니다. 이때, 항상 1이 적힌 카드가 있는 뭉치를 아래로 놓고 섞습니다.
// 3. 위 과정을 반복합니다.
// 처음에 가장 위에 있는 카드에 적힌 숫자 n, 섞는 횟수 mix, 알고 싶은 카드의 위치 k가 solution 메소드의 매개변수로 주어집니다.
// n은 10 이상 50 이하인 짝수입니다.
// 카드는 0회 이상 10회 이하로 섞습니다.
// k는 1 이상 n 이하인 자연수입니다.
// 아래에서 k번째에 있는 카드에 적힌 숫자를 return 해주세요.

class Solution7 {
    public int solution(int n, int mix, int k) {
        int answer = 0; // 1. 아래에서부터 k번째에 있는 숫자 담을 변수 초기화

        int[] card = new int[n]; // 2. n까지 숫자가 적힌 카드를 섞는 것이므로 n만큼의 길이 배열 선언
        for(int i = 0; i < n; i++) // 3. n값만큼 for문 돌려서 card 배열에 1부터 넣기
            card[i] = i+1;

        while((mix--) != 0) { // 4. mix 는 카드 섞은 횟수. 0이 아닐 때까지 반복
            int[] cardA = new int[n/2]; // 5. cardA와 cardB는 card 배열의 값들을 정확히 반씩 나누어 담을 것이기 때문에 배열 길이를 n/2 로 지정
            int[] cardB = new int[n/2];

            for(int i = 0; i < n; i++) { // 6. for문 이용하여 card 배열에 있는 값을 cardA 혹은 cardB 로 옮기기
                if(i < n/2)
                    cardA[i] = card[i]; // 7. n 이 6일 경우, i가 0, 1, 2 일 때 card 배열의 값을 cardA 로 옮기기(cardA 에 무조건 1 포함 - card 배열 절반 나눴을 때 앞부분)
                else
                	// CATCH!!!!!!
                    cardB[i-(n/2)] = card[i]; // 8. n 이 6일 경우, i가 3, 4, 5 일 때 card 배열의 값을 cardB 로 옮기기(card 배열 절반 나눴을 때 뒷부분)
                							  // cardB[i] 면 i 값을 대입했을 때 배열 길이 이상의 인덱스 값이므로 아웃오브바운드이기 때문에 cardB[i-(n/2)] 로 바꿔주어야 한다.
            }

            for(int i = 0; i < n; i++) { // 9. for 문 이용하여 cardA 와 cardB 배열 섞기(반 나눈 것을 합치는 것이므로 범위는 n까지가 된다.)
                if(i % 2 == 0) // 10. 홀짝 구분 조건식을 이용하여 cardA, cardB 배열에 담긴 것을 교차로 하나씩 섞는다.
                    card[i] = cardA[i/2]; // 홀수번째(인덱스 0부터), cardA 를 먼저 담기 때문에 항상 1이 맨 아래에 위치
                else
                    card[i] = cardB[i/2]; // 짝수번째(인덱스 1부터)
            }
        }

        answer = card[k-1]; // card 배열에서 k 번째 원소를 알고 싶은 것이기 때문에 k-1 을 하면 원하는 값을 알 수 있다.

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. 아래에는 잘못된 부분이 없으니 위의 코드만 수정하세요.
    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        int n = 6;
        int mix = 3;
        int k = 3;
        int ret = sol.solution(n, mix, k);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
    }
}