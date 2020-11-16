package day03;
// while반복문
// for반복문의 경우, 변수를 쓰기는 하지만 우리가 i가 얼마이고 변수보다 크거나 작거나 하는 동안 반복하라고 설정가능. 즉 횟수가 명확하다.

// 반면 while반복문은 조건이 true가 나오는 동안 반복이므로 횟수가 명확하지 않다.

public class Ex15While01 {
    public static void main(String[] args) {

        for(int i = 0 ; i < 3 ; i++) {
            System.out.println("(for)i의 현재값: " + i);
        }
        System.out.println("---------------------");
        // 위의 for문을 while로 표현하면 아래와 같다.
        int i = 0 ;
        while(i < 3) {
            System.out.println("(while)i의 현재값: " + i);
            i ++ ;
        }
        
    }
}
