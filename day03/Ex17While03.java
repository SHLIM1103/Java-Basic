package day03;
// 사용자로부터 점수를 입력받아서
// 90 이상 : A
// 80 ~ 89 : B
// 70 ~ 79 : C
// 60 ~ 69 : D
// 그외 : F 가 출력되는 프로그램을 작성하시오.
// 단, 사용자가 올바르지 않은 점수를 입력하면 올바른 점수가 들어올때까지 계속 입력을 받으시오.

import java.util.Scanner;
public class Ex17While03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("점수를 입력하세요: ");
        int score = scanner.nextInt();

        while(score < 0 || score > 100) {       // true가 나오는 동안 반복
            System.out.print("잘못된 점수입니다. 다시 입력하세요: ");
            score = scanner.nextInt();
        }

        // false가 나오면 아래 코드 실행
        if(score >= 90) {
            System.out.println("등급: A");
        }else if(score >= 80) {
            System.out.println("등급: B");
        }else if(score >= 70) {
            System.out.println("등급: C");
        }else if(score >= 60) {
            System.out.println("등급: D");
        }else {
            System.out.println("등급: F");
        }

        scanner.close();
    }
}
