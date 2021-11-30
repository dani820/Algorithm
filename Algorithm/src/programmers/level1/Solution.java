package programmers.level1;

import java.util.*;
import java.util.ArrayList;

// 스택으로 큐 구현
class Solution {
    Integer func_a(ArrayList<Integer> stack) {
    	// 11. remove(index) 메소드를 이용하여 pop한 값을 리턴(item)한다.
    	// stack.size() - 1 == 3-1 이므로 배열의 2번째, 즉 제일 마지막으로 push된 값을 리턴한다.
        Integer item = stack.remove(stack.size() - 1);
        return item;
    }

    void func_b(ArrayList<Integer> stack1, ArrayList<Integer> stack2) {
        while(!func_c(stack1)) { // 9. stack1 에 아무것도 남지 않을 때까지 stack2 에 push 해주어야 하므로 
        				  // 배열 길이 체크하는 func_c 함수 호출하여 true 를 리턴할 때까지 실행되도록 한다.
            Integer item = func_a(stack1); // 10. 배열에서 값을 pop 하는 메소드인 func_a 를 호출, stack1 을 매개변수로 전달한다.
            stack2.add(item); // 12. func_a 에서 리턴한 값을 stack2 에 push 한다. (stack1 에서 마지막으로 push 되었던 값부터 차례대로 pop 하여 stack2 에 push)
            				  // stack1 길이가 0이 되면 해당 작업이 종료된다.
        }
    }

    boolean func_c(ArrayList<Integer> stack) {
    	// 7. return 값이 있는 boolean 형 메소드는 return 에 작성한 조건식에 일치하는 값이 true 가 된다.
    	// 따라서 해당 메소드는 stack 의 길이가 0 일 때 true 를 반환한다.
        return (stack.size() == 0);  
    }

    public int solution(ArrayList<Integer> stack1, ArrayList<Integer> stack2) {
        if(func_c(stack2)) { // 6. stack2 의 길이 확인하기(stack2 길이가 0이면 true 일 때 if 문 안의 코드가 실행된다.)
            func_b(stack1, stack2); // 8. stack2 가 비어있으므로 stack1 의 값을 pop 해서 push 해주어야 한다.
        }
        Integer answer = (int)func_a(stack2); // 13. 마지막으로 stack2 에서 pop한 값을 리턴하기 위해 func_a 함수를 사용한다.
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.    
    public static void main(String[] args) {
        Solution sol = new Solution(); // 1. Solution 클래스 타입의 sol 객체 생성

        ArrayList<Integer> stack1_1 = new ArrayList<Integer>(); // 2. Integer 타입의 stack1_1 이라는 이름의 ArrayList 객체 생성
        ArrayList<Integer> stack2_1 = new ArrayList<Integer>(); // 3. Integer 타입의 stack2_1 이라는 이름의 ArrayList 객체 생성
        stack1_1.add(1);
        stack1_1.add(2);
        stack2_1.add(3);
        stack2_1.add(4); // 4. stack1_1 과 stack2_1 배열에 각각 값 넣어주기
        int ret1 = sol.solution(stack1_1, stack2_1); // 5. solution 메소드 호출하여 stack1_1 과 stack2_1 로 구현한 큐에서 pop 한 값 return 하기
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다."); // 14. stack2 에서 pop 한 리턴 값을 출력한다.


        ArrayList<Integer> stack1_2 = new ArrayList<Integer>();
        ArrayList<Integer> stack2_2 = new ArrayList<Integer>();
        stack1_2.add(1);
        stack1_2.add(2);
        stack1_2.add(3);
        int ret2 = sol.solution(stack1_2, stack2_2);
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
