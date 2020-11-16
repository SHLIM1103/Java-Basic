package day03;

import java.util.Scanner;
public class Ex12PrintStar08_AnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("별찍기 8번");
        System.out.println("---------------------");

        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();

        for(int i = 1 ; i <= 2 * userNumber -1 ; i++) {
            String star = new String();
            
            if(i < userNumber) {
                // 윗부분을 담당하는 if문
                // userNumber = 5 일때 ---> i가 1,2,3,4일때 여기로 들어온다.

                // 공백을 담당하는 j for문
                for(int j = 1 ; j <= userNumber - i ; j++) {
                    star += " " ;
                }
                
                // 별을 담당하는 j for문
                for(int j = 1 ; j <= i ; j++) {
                    star += "*" ;
                }

            }else {
                // 아랫부분을 담당하는 if문
                // userNumber = 5 일때 ---> i가 5,6,7,8,9일때 여기로 들어온다.
                
                // 이렇게 되면, 우리가 기존에 사용한 j for문의 방식이 변경되어야 한다.
                // 기존 j for문은 1 2 3 4 5를 기준으로 했기 때문이다.
                // 하지만 더 좋은 방법이 있다. 바로 새로운 변수를 만드는 것이다.
                int lowerI = i - userNumber + 1 ;
                
                // 공백을 담당하는 j for문
                for(int j = 1 ; j <= lowerI - 1 ; j++) {            // i 자리에 lowerI를 넣었음
                    star += " ";
                }
                
                // 별을 담당하는 j for문
                for(int j = lowerI ; j <= userNumber ; j++) {
                    star += "*" ;
                }
            }
            
            System.out.println(star);
        }
        
        scanner.close();
    }
}
