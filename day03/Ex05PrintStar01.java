package day03;
// 번호 하나당 클래스 하나가 나온다.
// 모든 별찍기는 사용자로부터 입력을 받아서 입력받은 수에 맞는 줄이 나온다.

// 별찍기 1번

import java.util.Scanner;
public class Ex05PrintStar01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 1번");
        System.out.println("---------------------");

        System.out.print("출력할 줄 수: ");
        int userNumber = scanner.nextInt();

        // i for문은 세로줄 수를 결정한다.
        // j for문은 해당 줄에 출력할 별의 개수 혹은 공백의 개수를 결정한다.
        for(int i = 1 ; i <= userNumber ; i++) {        // userNumber개의 줄 생성
            // j for문의 종료 조건식: j = i 일때 종료
            for(int j = 1 ; j <= i ; j++) {             // 행의 순서만큼 반복(1행이면 1, 2행이면 2...)
                System.out.print("*");                  // 별찍기를 위한 코드
            }
            System.out.println();                       // 줄바꿈을 위한 코드

        }

        scanner.close();
    }
}
