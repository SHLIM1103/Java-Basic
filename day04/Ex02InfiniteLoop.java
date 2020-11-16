package day04;
// 무한루프
// 무한루프란, 조건식에서 항상 참이 나와서 해당 루프가 종료되지 않고 프로그램을 강제 종료할 때까지 계속 돌아가는 반복문이다.

// 무한루프를 만드는 다양한 방법을 알아보자

public class Ex02InfiniteLoop {
    public static void main(String[] args) {

        System.out.println("1. for 반복문을 이용한 무한루프");
        // A. 제어변수의 값이 변화가 없으면
        System.out.println("A. for문의 제어변수 값을 고정");
        System.out.println("for(int i = 0 ; i < 1 ;)");
//        for(int i = 0; i < 1 ;) {
//            System.out.println("for 무한루프 1번");
//        }
        
        // B. 조건식이 항상 참이 나오면
        System.out.println("B. 항상 참인 for문의 조건");
        System.out.println("for(int i = 0 ; 0 < 1 ; i++)");
//        for(int i = 0 ; 0 < 1 ; i++) {
//            System.out.println("B. for 무한루프 2번. i의 현재값: " + i);
//        }
        
        // C. 빈 형태의 for문
        System.out.println("C. 빈 형태의 for문");
        System.out.println("for(;;)");
//        for(;;) {
//            System.out.println("이것도 돌아가지롱");
//        }
        
        System.out.println("2. while 반복문을 이용한 무한루프");
        
        System.out.println("A. 변화가 없는 변수를 조건식에");
        System.out.println("int number = 0 ; while(number < 5) {");
//        int number = 0 ;
//        while(number < 5) {
//            System.out.println("while 무한루프 1번");
//        }
        
        System.out.println("B. 항상 참이 나오는 조건식");
        System.out.println("while(0 < 1)");
//        while(0 < 1) {
//            System.out.println("while 무한루프 2번");
//        }
        
        // 조건식을 만들 필요가 없는 방법!!
        System.out.println("C. true");
        System.out.println("while(true)");
//        while(true) {
//            System.out.println("쉬운 방법!");
//        }        
        
    }
}