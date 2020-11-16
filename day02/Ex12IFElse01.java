package day02;
// if-else
// if-else 구조란, 만약 if의 조건식이 false가 나오면 무조건 else가 실행이 된다.
// 예) 사용자로부터 입력을 받아서 홀수인지 짝수인지 출력하는 프로그램의 경우
//    2로 나누어서 나머지가 0이면 짝수, 그외엔 무조건 홀수가 된다.
// 혹은 "특정 조건을 만족했을 경우와 그 외의 모든 경우" 이렇게 두가지로 나뉠 때에도 if else 구조를 사용한다.

public class Ex12IFElse01 {
    public static void main(String[] args) {
        int number = 30 ;
        if(number < 0) {
            System.out.println("음수입니다.");
        }else {
            System.out.println("자연수입니다.");
        }
    }
}
