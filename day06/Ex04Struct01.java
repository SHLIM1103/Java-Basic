package day06;

import java.util.Scanner;

import util.ScannerUtil;

// Student 데이터타입에 직접 값을 넣고 출력하는 프로그램을 작성해보자.

public class Ex04Struct01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student s = new Student();

        System.out.print("번호: ");
        s.setId(scanner.nextInt());
        
        System.out.print("이름: ");
        s.setName(ScannerUtil.nextLine(scanner));
        
        s.setKorean(ScannerUtil.nextInt(scanner, "국어: ", 1, 100));
        
        s.setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 1, 100));
        
        s.setMath(ScannerUtil.nextInt(scanner, "수학: ", 1, 100));

        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어점수: %03d점 영어점수: %03d점 수학점수: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        
        System.out.printf("총점: %03d점 평균: %.2f점\n", s.calculateSum(), s.calculateAve());
        
        scanner.close();
    }
}
