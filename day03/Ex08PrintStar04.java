package day03;
// 별찍기 예제 4

import java.util.Scanner;
public class Ex08PrintStar04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 4번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        for(int i = 1 ; i <= userNumber ; i++) {
            String star = new String() ;
            
            // 공백 j : i번째 줄에는 i-1개의 공백이 있음
            for(int j = 1 ; j <= i-1 ; j++) {
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
