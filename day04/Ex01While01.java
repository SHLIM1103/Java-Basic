package day04;
// 사용자로부터 번호 이름 국어 영어 수학 점수를 입력받아서
// 번호: ### 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##wja
// 총점: ###점 평균: ##.##점
// 형식으로 출력하는 프로그램을 작성하시오.
// 단, 국영수 점수는 사용자가 잘못된 점수를 입력하면 올바른 점수가 들어올 때까지 다시 입력받으시오.


import java.util.Scanner;

public class Ex01While01 {
    final static int SIZE = 3 ; 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("번호: ");
        int number = scanner.nextInt();

        scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("국어 점수: ");
        int korean = scanner.nextInt();

        while(korean < 0 || korean > 100) {
            System.out.println("잘못된 점수입니다. 다시 입력하세요.");
            System.out.print("국어 점수: ");
            korean = scanner.nextInt();
        }

        System.out.print("영어 점수: ");
        int english = scanner.nextInt();
        while(english < 0 || english > 100) {
            System.out.println("잘못된 점수입니다. 다시 입력하세요.");
            System.out.print("영어 점수: ");
            english = scanner.nextInt();  
        }

        System.out.print("수학 점수: ");
        int math = scanner.nextInt();
        while(math < 0 || math > 100) {
            System.out.println("잘못된 점수입니다. 다시 입력하세요.");
            System.out.print("수학 점수: ");
            math = scanner.nextInt();  
        }
        
        int sum = korean + english + math ;
        double ave = sum / (double)SIZE ;

        System.out.printf("번호: %d번 이름: %s 님\n", number, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %d점 평균: %.2f점\n", sum, ave);

        scanner.close();

    }
}