package day03;
// 별찍기 예제 3번


import java.util.Scanner;
public class Ex07PrintStar03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 3번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        for(int i = 1 ; i <= userNumber ; i++) {
            String star = new String();

            // 공백 j
            for(int j = i ; j <= userNumber-1 ; j++) {
                star += " " ;
            }

            // 별 j
            for(int j = 1 ; j <= i ; j++) {
                star += "*" ;
            }
            
            System.out.println(star);
        }

        scanner.close();
    }
}

//for(int i = 1 ; i <= userNumber ; i++) {
//
//    //공백 j
//    for(int j = i ; j <= userNumber-1 ; j++ ) {
//        System.out.print(" ");
//    }
//
//    //별 j
//    for(int j = 1 ; j <= i ; j ++) {
//        System.out.print("*");
//    } 
//    System.out.println();
//}