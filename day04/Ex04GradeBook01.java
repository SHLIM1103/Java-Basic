package day04;
// 사용자로부터 id, 이름, 국어, 영어, 수학 점수를 받아서 
//번호: ### 이름: ###
//국어: 0##점 영어: 0##점 수학: 0##점
//총점: ###점 평균: ##.##점
//형식으로 출력하는 프로그램을 작성하시오.
//단, 국영수 점수는 사용자가 잘못된 점수를 입력하면 올바른 점수가 들어올 때까지 다시 입력받으시오.
// 또한 처음으로 프로그램을 시작할때 사용자가 입력, 출력, 종료를 선택하여 사용자가 원하는 만큼 입출력 할 수 있게 프로그램을 작성하시오.

import java.util.Scanner;
public class Ex04GradeBook01 {
    static final int SIZE = 3 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id = 0 ;
        String name = new String();

        // korean, english, math의 경우 한번이라도 입력되면 0 ~ 100 사이의 값이 들어가게 된다.
        // 그렇다면 우리가 처음 선언과 초기화를 할 때 불가능한 점수로 초기화를 하고,
        // 혹시라도 사용자가 아무런 데이터도 입력하지 않고 출력을 누를 시에 해당 점수가 올바르지 않은지 체크해서
        // 올바르지 않을 시에는 "아직 입력된 정보가 없습니다" 라고 경고메시지를 출력할 수 있다.
        int korean = -1 ;
        int english = 0 ;
        int math = 0 ;

        while(true) {
            System.out.println("-------------------");
            System.out.println(" [ 성적 관리 프로그램 ]");
            System.out.println("-------------------");

            System.out.println("(1)입력 (2)출력 (3)종료");
            System.out.print("> ");
            int choice = scanner.nextInt();

            if(choice == 1) {
                System.out.print("번호: ");
                id = scanner.nextInt();

                scanner.nextLine();
                System.out.print("이름: ");
                name = scanner.nextLine();

                System.out.print("국어 점수: ");
                korean = scanner.nextInt();
                while(korean < 0 || korean > 100) {
                    System.out.println("잘못된 점수입니다. 다시 입력하세요.");
                    System.out.print("국어 점수: ");
                    korean = scanner.nextInt();
                }

                System.out.print("영어 점수: ");
                english = scanner.nextInt();
                while(english < 0 || english > 100) {
                    System.out.println("잘못된 점수입니다. 다시 입력하세요.");
                    System.out.print("영어 점수: ");
                    english = scanner.nextInt();  
                }

                System.out.print("수학 점수: ");
                math = scanner.nextInt();
                while(math < 0 || math > 100) {
                    System.out.println("잘못된 점수입니다. 다시 입력하세요.");
                    System.out.print("수학 점수: ");
                    math = scanner.nextInt();  
                }

            }else if(choice == 2) {
                // 만약 국어 점수가 -1이면 아직 아무 정보도 입력되지 않은 상태이므로,
                // 경고메시지만 출력하고 그 외에는 정상적으로 정보를 출력하도록 한다.
                if(korean == -1) {
                    System.out.println("아직 입력된 정보가 없습니다.");   
                }else {
                    // 정보가 입력된 상태이므로, 정보를 출력하는 코드 실행
                    int sum = korean + english + math ;
                    double ave = sum / (double)SIZE ;

                    System.out.printf("번호: %d번 이름: %s 님\n", id, name);
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                    System.out.printf("총점: %03d점 평균: %.2f점\n", sum, ave);
                }

            }else if(choice == 3) {
                //종료
                System.out.println("프로그램을 종료합니다.");
                break;

            }else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        scanner.close();
    }
}
