package programmers.level1;

// extends
class Solution4 {
    class Job {
        public int salary;

        public Job() {
            this.salary = 0;
        }

        public int getSalary() {
            return salary;
        }
    }

    // 8. Job 클래스를 상속받은 PartTimeJob 클래스
    // 객체 생성 시 매개변수가 있는 생성자를 통해 workHour, payPerHour 값 지정됨
    class PartTimeJob extends Job {
        public int workHour, payPerHour;

        public PartTimeJob(int workHour, int payPerHour) {
            this.workHour = workHour;
            this.payPerHour = payPerHour;
        }

        // 10. Job 에서 상속받은 메소드를 재정의하여 사용
        public int getSalary() {
            salary = workHour * payPerHour;
            if(workHour >= 40)
                salary += (payPerHour * 8);

            return salary;
        }
    }

    // 13. Job 클래스를 상속받은 SalesJob 클래스
    // 객체 생성 시 매개변수가 있는 생성자를 통해 salesResult, payPerSale 값 지정됨
    class SalesJob extends Job {
        public int salesResult, payPerSale;

        public SalesJob(int salesResult, int payPerSale) {
            this.salesResult = salesResult;
            this.payPerSale = payPerSale;
        }

        // 15. Job 에서 상속받은 메소드를 재정의하여 사용
        public int getSalary() {
            if(salesResult > 20)
                salary = salesResult * payPerSale * 3;
            else if(salesResult > 10)
                salary = salesResult * payPerSale * 2;
            else
                salary = salesResult * payPerSale;

            return salary;
        }
    }

    // 4. 급여 총합 구하는 메소드
    public int solution(int[][] partTimeJobs, int[][] salesJobs) {
        int answer = 0; // 5. 리턴할 총합 변수 초기화

        // 6. 2차원 배열 for 문 돌려 시간당 급여 계산하기
        for(int i = 0; i < partTimeJobs.length; i++) {
            PartTimeJob partTimeJob = new PartTimeJob(partTimeJobs[i][0], partTimeJobs[i][1]); // 7. PartTimeJob 타입의 partTimeJob 객체 생성
            answer += partTimeJob.getSalary(); // 9. getSalary() 메소드를 호출하여 급여 계산하고 누적하여 총합 구함
        }

        // 11. 2차원 배열 for 문 돌려 판매실적당 급여 계산하기
        for(int i = 0; i < salesJobs.length; i++) {
            SalesJob salesJob = new SalesJob(salesJobs[i][0], salesJobs[i][1]); // 12. SalesJob 타입의 salesJob 객체 생성
            answer += salesJob.getSalary(); // 14. getSalary() 메소드를 호출하여 급여 계산하고 누적하여 총합 구함 (answer 는 전역변수이므로 아르바이트 급여 누적된 상태)
        }

        return answer; // 16. 아르바이트 급여와 판매사원 급여 합계 리턴
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        int[][] partTimeJobs = {{10, 5000}, {43, 6800}, {5, 12800}}; // 1. 아르바이트 한 시간과 시간 당 급여 2차원 배열
        int[][] salesJobs = {{3, 18000}, {12, 8500}}; // 2. 판매 실적과 판매실적 당 급여 2차원 배열
        int ret = sol.solution(partTimeJobs, salesJobs); // 3. 각 2차원 배열들을 매개변수로 하여 급여 합계 구하는 메소드 호출
        												 // 17. 총 급여 합계 리턴받아 ret 변수에 저장하고 sysout 으로 출력
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}