package day03;
// 별찍기 예제 8번

import java.util.Scanner;
public class Ex12PrintStar08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 8번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        // 위 5줄
        for(int i = 1 ; i <= userNumber ; i++) {
            String star = new String();

            // 공백 j
            for(int j = i ; j <= userNumber ; j++) {
                star += " ";                
            }

            // 별 j
            for(int j = 1 ; j <= i ; j++) {
                star += "*" ;
            }

            System.out.println(star);
        }

        // 아래 4줄
        for(int i = 2 ; i <= userNumber ; i++) {
            String star = new String();

            // 공백 j
            for(int j = 1 ; j <= i ; j++) {
                star += " " ;
            }

            // 별 j
            for(int j = i ; j <= userNumber ; j++) {
                star += "*" ;
            }

            System.out.println(star);
        }

        scanner.close();
    }    
}
