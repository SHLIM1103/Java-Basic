package day04;
// 가위바위보 게임
// 메뉴: (1)플레이 (2)전적보기 (3)종료
// 1. 플레이 시에는 사용자가 가위 바위 보 중에 하나를 고르게 한다.
//    단, 1은 가위/ 2는 바위/ 3은 보
//    만약 잘못된 값을 입력하면 다시 입력하게 한다.
//    컴퓨터도 마찬가지로 1 ~ 3 사이의 난수를 만들어서
//    사용자의 입력값과 비교하여 사용자 기준으로 승리, 무승부, 패배 3가지 중 하나를 기록한다.
// 2. 전적보기 시에는 ##전 ##승 ##무 ##패 (승률: ##.##퍼센트) 식으로 출력한다.
//    단, 아무런 플레이 기록도 없을 경우 "아직 플레이한 기록이 없습니다" 를 출력한다.

import java.util.Scanner;
import java.util.Random;

public class Ex06RSPGame {
    static final int MAX = 3 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random() ;

        int win = 0 ;
        int lose = 0 ;
        int draw = 0 ;

        while(true) {
            System.out.println("★가위바위보 게임★");
            System.out.println("(1)플레이 (2)전적보기 (3)종료");
            System.out.print(" > ");
            int choice = scanner.nextInt();

            if(choice == 1) {
                int computer = random.nextInt(MAX) + 1 ;

                System.out.print("(1)가위 (2)바위 (3)보 : ");
                int user = scanner.nextInt();
                while(user > 3 || user < 1) {
                    System.out.println("잘못 선택하셨습니다.");
                    System.out.print("(1)가위 (2)바위 (3)보 : \n");
                    user = scanner.nextInt();                    
                }
                // 승-무승부-패배는 다음과 같은 로직을 가진다.
                // 1. 사용자의 숫자와 컴퓨터의 숫자가 같음 = 무승부
                // 2. 그외
                //      A. 사용자가 1을 선택하는 경우: 컴퓨터가 2면 패배 그외는 승리
                //      B. 사용자가 2를 선택하는 경우: 컴퓨터가 3이면 패배 그외는 승리
                //      C. 사용자가 3을 선택하는 경우: 컴퓨터가 1이면 패배 그외는 승리

                String computerRSP = rspSetter(computer);
                String userRSP = rspSetter(user);

                System.out.println("컴퓨터의 선택: " + computerRSP + " / 사용자의 선택: " + userRSP);
                
                if(user == computer) {
                    System.out.println("무승부입니다.");
                    draw ++ ;
                }else {
                    if(user == 1) {
                        if(computer == 2) {
                            System.out.println("졌습니다 ㅠㅠ");
                            lose ++ ;
                        }else {
                            System.out.println("이겼습니다 !");
                            win ++ ;
                        }
                    }else if(user == 2) {
                        if(computer == 3) {
                            System.out.println("졌습니다 ㅠㅠ");
                            lose ++ ;
                        }else {
                            System.out.println("이겼습니다 !");
                            win ++ ;
                        }
                    }else {
                        if(computer == 1) {
                            System.out.println("졌습니다 ㅠㅠ");
                            lose ++ ;
                        }else {
                            System.out.println("이겼습니다 !");
                            win ++ ;                            
                        }
                    }
                }

            }else if(choice == 2) {
                int total = win + lose + draw ;
                if(total == 0) {
                    System.out.println("아직 플레이한 기록이 없습니다.");
                }else {
                    System.out.printf("현재 전적: %03d전 %03d승 %03d무 %03d패\n", total, win, draw, lose);
                }

            }else if(choice == 3) {
                System.out.println("플레이를 종료합니다 !");
                break ;                

            }else {
                System.out.println("잘못 선택하셨습니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }
    
    static String rspSetter(int value) {
        switch(value) {
        case 1:
            return "가위" ;
            
        case 2:
            return "바위" ;
            
        case 3: 
            return "보" ;
          
        default:
            return "" ;

        }
    }
    
}
