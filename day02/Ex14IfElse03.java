package day02;
// 사용자로부터 이름, 국어, 영어, 수학 점수를 입력받아서
// 총점이 210점 이상이고, 모든 점수가 60점 이상이면
// "### 학생은 합격입니다" 출력, 그외에는 모두 "### 학생은 불합격입니다" 출력되는 프로그램을 작성하시오

import java.util.Scanner;
public class Ex14IfElse03 {
    static final int SUM_STANDARD = 210 ;
    static final int INDIVIDUAL_STANDARD = 60 ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("국어 점수: ");
        int korean = scanner.nextInt();

        System.out.print("영어 점수: ");
        int english = scanner.nextInt();

        System.out.print("수학 점수: ");
        int math = scanner.nextInt();

        int sum = korean + english + math ;

        if(sum >= SUM_STANDARD && korean >= INDIVIDUAL_STANDARD && english >= INDIVIDUAL_STANDARD && math >= INDIVIDUAL_STANDARD) {
            System.out.printf("%s 학생은 합격입니다.", name);
        }else {
            System.out.printf("%s 학생은 불합격입니다.", name);
        }

        scanner.close();
    }
}