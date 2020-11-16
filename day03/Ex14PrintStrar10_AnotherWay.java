package day03;
// 별찍기 예제 10번 (미완성)

import java.util.Scanner;
public class Ex14PrintStrar10_AnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 10번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        // 윗 줄
        for(int i = 1 ; i <= userNumber ; i++) {
            String star = new String();

            // 별 j
            for(int j = i ; j <= userNumber ; j++) {
                star += "*" ;
            }
            // 공백 : 1일때0 2일때1 3일때3 4일때5 5일때7 ...
            for(int j = 2 ; j <= 2*i-1 ; j++) {
                star += " ";
            }
            // 별
//            for(int j = ) {
//            
//            } 
//            
//            System.out.println(star);    
//
//
        }  
        
        scanner.close();
    }
}


