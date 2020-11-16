package day05;
// 사용자로부터 국영수 점수를 입력받아 1~3회차의 점수와 총점 평균을 출력하는 프로그램을 작성하시오
// 결과는 아래와 같이 나온다.

import java.util.Scanner;
import util.ScannerUtil;

// 27번 임소현
// ---1번 시험---
// 국어: 080점 영어: 080점 수학: 079점
// 총점: 239점 평균: 79.66점
// ------------
// ---2번 시험---
// ...
// ------------
// ---3번 시험---
// ...
// ------------

// 과목별로 배열을 만드는게 아니라, 시험별로 배열을 만들어서 컨트롤하는 프로그램
// 아래 코드들은 나머지는 생략했고... 1번 시험결과만 출력된다.

public class Ex05Array03B_Answer {
    private static final int SCORE_MAX = 100 ;
    private static final int SIZE = 3 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = new int[SIZE];
        int[] secondArray = new int[SIZE];
        int[] thirdArray = new int[SIZE];

//        int id = 0 ;
//        String name = new String();

//        System.out.print("번호: ");
//        id = scanner.nextInt();
//
//        System.out.print("이름: ");
//        name = ScannerUtil.nextLine(scanner);

        // 1회차시험 2회차시험 3회차시험 --> 매번 새로 입력해야 함...
        System.out.println("---1번 시험---");
        firstArray[0] = ScannerUtil.nextInt(scanner, "국어: ", 0, SCORE_MAX);
        firstArray[1] = ScannerUtil.nextInt(scanner, "영어: ", 0, SCORE_MAX);
        firstArray[2] = ScannerUtil.nextInt(scanner, "수학: ", 0, SCORE_MAX);

        System.out.println("---2번 시험---");
        secondArray[0] = ScannerUtil.nextInt(scanner, "국어: ", 0, SCORE_MAX);
        secondArray[1] = ScannerUtil.nextInt(scanner, "영어: ", 0, SCORE_MAX);
        secondArray[2] = ScannerUtil.nextInt(scanner, "수학: ", 0, SCORE_MAX);

        System.out.println("---3번 시험---");
        thirdArray[0] = ScannerUtil.nextInt(scanner, "국어: ", 0, SCORE_MAX);
        thirdArray[1] = ScannerUtil.nextInt(scanner, "영어: ", 0, SCORE_MAX);
        thirdArray[2] = ScannerUtil.nextInt(scanner, "수학: ", 0, SCORE_MAX);

        // 1번 시험만 출력해보면!        
        int korean = firstArray[0] ;
        int english = firstArray[1] ;
        int math = firstArray[2] ;

        int sum = korean + english + math ;
        double ave = sum / (double)SIZE ;

        System.out.println("---1번 시험---");
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %.2f점\n", sum, ave);
        System.out.println("------------");

                
        scanner.close();
    }
}
