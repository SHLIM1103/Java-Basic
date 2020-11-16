package day02;
// 사용자로부터 번호, 이름, 국영수 점수를 입력받아서
// 번호: ##번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: ###점 평균: ##.##점
// 이 출력되는 프로그램을 작성하시오.

// 단, 사용자가 잘못된 점수를 입력하면 즉시
// "잘못 입력하셨습니다. 프로그램을 종료합니다." 가 출력되고
// 모든 점수를 올바르게 입력할 때에만 위의 정보가 출력되어야 함

import java.util.Scanner;
public class Ex18NestedIf02 {
    static final int SUBJECT_SIZE = 3 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호: ");
        int number = scanner.nextInt();
        System.out.print("이름: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("국어 점수: ");
        int korean = scanner.nextInt();
        if(korean >= 0 && korean <= 100) {
            System.out.print("영어 점수: ");
            int english = scanner.nextInt();

            if(english >= 0 && english <= 100) {
                System.out.print("수학 점수: ");
                int math = scanner.nextInt();

                if(math >= 0 && math <= 100) {
                    int sum = korean + english + math ;
                    double ave = sum / (double)SUBJECT_SIZE ;

                    System.out.printf("번호: %d번 이름: %s\n", number, name);
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                    System.out.printf("총점: %d점 평균: %.2f점\n", sum, ave);
                }else {
                    System.out.println("잘못된 점수입니다. 프로그램을 종료합니다.");
                }

            }else {
                System.out.println("잘못된 점수입니다. 프로그램을 종료합니다.");
            }

        }else {
            System.out.println("잘못된 점수입니다. 프로그램을 종료합니다.");
        }

        scanner.close();
    }
}