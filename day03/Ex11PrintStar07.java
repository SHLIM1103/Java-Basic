package day03;
// 별찍기 예제 7번

import java.util.Scanner;
public class Ex11PrintStar07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 7번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();
        // 줄 i
        for(int i = 1 ; i <= userNumber ; i++) {
            //별 j
            for(int j = 1 ; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();           // 줄바꿈
        }

        // 거꾸로 줄i
        for(int i = 1 ; i <= userNumber-1 ; i++) {
            String star = new String();

            // 거꾸로 별j
            for(int j = i ; j < userNumber ; j++) {
                star += "*";
            }
            System.out.println(star);
        }

        scanner.close();
    }
}
