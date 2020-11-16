package day06;

import java.util.Scanner;

import util.ScannerUtil;

// 구조체를 배열로 만드는 것 역시 가능하다.
// 기존 기본형 데이터타입 배열처럼 ※ 데이터타입[] 배열이름 = new 데이터타입[크기] ; ※ 로 선언하여
// 각 칸을 초기화하면 사용 가능하다.

public class Ex05StructArray01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] studentArray = new Student[5];
        // 단 기본형 데이터타입이 아닌 배열의 경우,
        // 각 요소를 매번 초기화해주어야 정상적으로 사용 가능하다.

        // 만약 각 요소를 초기화하지 않으면 NullPointerException 에러 발생
        // studentArray[0].id = 1 ;

        // 각 요소를 초기화하는 for문
        for (int i = 0; i < studentArray.length; i++) {
            studentArray[i] = new Student();
        }

        // new : 참조형 데이터타입에 대한 공간을 확보하기 위한 키워드
        // 클래스형 변수의 경우 > 변수 = new 클래스이름() ; 으로 초기화
        // 배열의 경우 > 배열이름 = new 데이터타입[크기] ; 로 초기화
        // 참조형 배열의 경우 > 배열 초기화 이후에 각 요소에 대한 초기화를 해주어야 정상 작동 가능

        // for문을 이용해서 각 칸의 정보를 넣고 또 다른 for문을 이용해서 각 칸의 정보를 출력해보세요.
        for (int i = 0; i < studentArray.length; i++) {
            System.out.print("번호: ");
            studentArray[i].setId(scanner.nextInt());

            System.out.print("이름: ");
            studentArray[i].setName(ScannerUtil.nextLine(scanner));

            studentArray[i].setKorean(ScannerUtil.nextInt(scanner, "국어: ", 0, 100));

            studentArray[i].setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 0, 100));

            studentArray[i].setMath(ScannerUtil.nextInt(scanner, "수학: ", 0, 100));
        }

        for (int i = 0; i < studentArray.length; i++) {

            System.out.printf("번호: %d, 이름: %s\n", studentArray[i].getId(), studentArray[i].getName());
            System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", studentArray[i].getKorean(),
                    studentArray[i].getEnglish(), studentArray[i].getMath());

            int sum = studentArray[i].getKorean() + studentArray[i].getEnglish() + studentArray[i].getMath();
            double ave = sum / 3.0;
            System.out.printf("총점: %d점, 평균: %.2f점\n", sum, ave);
          
        }
    }
}