package day02;
// 사용자로부터 번호 이름 국어 영어 수학 을 차례대로 입력받아서
// 번호: ### 이름: ###
// 국어: 080점 영어: 079점 수학: 080점
// 총점: 239점 평균 79.67점
// 이렇게 출력되도록 프로그램을 작성해보세요.

import java.util.Scanner ;
public class Ex07GradeBook {
    static final int SUBJECT_SIZE = 3 ;     // 소프트코딩을 위한 매직 넘버
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("번호: ");
        int number = scanner.nextInt();

        System.out.print("이름: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("국어 점수: ");
        int korean = scanner.nextInt();

        System.out.print("영어 점수: ");
        int english = scanner.nextInt();

        System.out.print("수학 점수: ");
        int math = scanner.nextInt();

        //총점
        int sum = korean + english + math ;
        //평균
        // double ave = sum / 3.0 ;

        // 매직넘버(마술의 숫자)
        // 매직넘버란 소스코드 중간에 갑자기 튀어나오는 정수, 실수, 문자열을 의미한다.
        // 매직넘버는 간단한 프로그램을 짤 때에는 유용하지만, 해당 프로그램을 유지보수 및 업그레이드할 때에는
        // 하드코딩이 되므로 코드의 변경을 어렵게 만든다.

        // 하드코딩 vs 소프트코딩
        // 하드코딩 : '경직된 코딩' ---> 변경이 어려운 코드를 만드는 것
        //          장점) 코드를 쉽게 만들수 있고 굳이 변수명과 상수명을 안만들어도 된다.
        //          단점) 경직되어 있으므로 코드 변경이 오히려 어렵다.
        // 소프트코딩: '유연한 코딩' ---> 변경이 쉬운 코드를 만드는 것
        //          장점) 처음 만들 때 어렵다.
        //          단점) 유지보수 및 업그레이드가 쉬워진다.

        // 위의 double ave = sum / 3.0 ; 을 소프트코딩 ---> double ave = sum / (double)과목수  
        double ave = sum / (double)SUBJECT_SIZE ;

        // 정보 출력
        System.out.printf("번호: %d번 이름: %s\n", number, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %.2f점\n", sum, ave);

        scanner.close();

    }    
}