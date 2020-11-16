package day03;
// 별찍기 예제 9번

import java.util.Scanner;
public class Ex13PrintStar09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 9번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();


        // 위 삼각형 
        for(int i = 1 ; i <= userNumber ; i++) {
            String star = new String() ;

            // 공백 j
            for(int j = i ; j <= userNumber-1 ; j++) {
                star += " " ;
            }

            // 별 j
            for(int j = 1 ; j <= (2*i-1) ; j++) {
                star += "*" ;
            }

            System.out.println(star);
        }

        // 아래 삼각형 
        for(int i = userNumber-1 ; i >= 1 ; i--) {
            String star = new String() ;

            // 공백 j
            for(int j = 1 ; j <= userNumber-i ; j++) {
                star += " " ;
            }

            // 별 j
            for(int j = 1 ; j <= (2*i-1) ; j++) {
                star += "*" ;
            }

            System.out.println(star);
        }

        scanner.close();
    }
}
