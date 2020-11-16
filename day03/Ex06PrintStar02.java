package day03;
// 별찍기 예제 2번


import java.util.Scanner;
public class Ex06PrintStar02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("---------------------");
        System.out.println("별찍기 2번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();
        
        for(int i = 1 ; i <= userNumber ; i++) {
            // 별은 하나씩 감소. 1일때 5, 2일때 4, 3일때 3, 4일때 4, 5일때 1 
            String star = new String();
            
            for(int j = i ; j <= userNumber ; j++) {
                star += "*" ;
            }
            
            System.out.println(star);
        }
                
        scanner.close();
    }
}

//public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//
//    System.out.println("---------------------");
//    System.out.println("별찍기 2번");
//    System.out.println("---------------------");
//
//    System.out.print("숫자: ");
//    int userNumber = scanner.nextInt();
//
//    for(int i = 0 ; i <= userNumber ; i++) {
//        for(int j = i ; j <= userNumber-1 ; j++) {
//            System.out.print("*");
//        }
//        System.out.println();

