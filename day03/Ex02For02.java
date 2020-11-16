package day03;
// for문의 다양한 예제

import java.util.Scanner;
public class Ex02For02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 1부터 사용자가 입력한 숫자를 한줄씩 출력하는 for문 작성
        System.out.print("1. 숫자: ");
        int number = scanner.nextInt();
        for(int i = 1 ; i <= number ; i++) 
            System.out.println(i);

        // 2. 1부터 사용자가 새로 입력한 숫자까지의 합을 구하는 for문 작성
        //    이 문제 같은 경우에는, 합을 보관한 변수가 밖에 선언 및 초기화 되어야 for문이 반복되더라도 그 값이 남아있게 된다.

        int sum = 0 ;   // 합을 보관한 변수가 밖에 선언 및 초기화
        System.out.print("2. 합을 구할 숫자: ");
        number = scanner.nextInt();

        for(int i = 1 ; i <= number ; i++) {
            sum += i ;
        }
        System.out.printf("1부터 %d까지의 합: %d\n", number, sum);

        // 3. 1부터 사용자가 입력한 숫자까지의 홀수들만 출력하는 for문 작성
        System.out.print("3. 숫자: ");
        number = scanner.nextInt();

        for(int i = 1 ; i <= number ; i++) {
            if(i % 2 == 1) {
                System.out.println(i);
            }
        }

        // 4. 1부터 사용자가 입력한 숫자까지의 곱을 출력하는 for문 작성
        //    20억 이상의 값이 나오면 오버플로우가 발생하므로, 사용자가 14보다 큰 수를 입력하면 경고메시지가 출력되도록 작성  
        System.out.print("4. 곱을 구할 숫자: ");
        number = scanner.nextInt();

        if(number <= 14) {
            int mul = 1;
            for(int i = 1 ; i <= number ; i++) {
                mul *= i ;
            } 
            System.out.printf("%d까지의 곱: %d", number, mul);

        }else {
            System.out.println("※ 경고! 오버플로우가 발생하므로 계산할 수 없습니다 ※");
        }

        scanner.close();
    }
}