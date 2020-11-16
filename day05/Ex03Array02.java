package day05;
// 사용자로부터 점수 3개를 입력받아서 그 3개의 총점, 평균을 보여주는 프로그램

import java.util.Scanner;

import util.ScannerUtil;

public class Ex03Array02 {
    private static final int SIZE = 3 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] scoreArray = new int[SIZE] ;      // 배열만들기

        for(int i = 0 ; i < scoreArray.length ; i++) {
            scoreArray[i] = ScannerUtil.nextInt(scanner, (i+1)+"번 시험점수: ", 1, 100);      // 배열 칸에 숫자 넣어주기                    
        }

        int sum = 0 ;                                           // 합을 저장할 sum 변수
        for(int i = 0 ; i < scoreArray.length ; i++) {
            sum += scoreArray[i];
        }

        double ave = sum / (double)SIZE ;
        System.out.printf("총점: %03d점 평균: %.2f점\n", sum, ave);
        
        
        scanner.close();
    }
}
