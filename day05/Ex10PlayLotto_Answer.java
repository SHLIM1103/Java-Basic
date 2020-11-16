package day05;

import java.util.Random;
import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

// 로또 게임 해보기
// 사용자가 숫자를 선택해서, 컴퓨터가 만들어준 숫자들과 비교하여
// 6개 일치: 1등
// 5개 일치: 2등
// 4개 일치: 3등
// 3개 일치: 4등
// 이 출력되는 프로그램을 작성하시오.
// 단, 사용자가 숫자를 선택할 때에는 불가능한 번호나 중복된 번호는 입력할 수 없게 프로그램을 작성하시오.

public class Ex10PlayLotto_Answer {
    private static final int SIZE = 6;
    private static final int MAX = 45;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userLotto[] = new int[SIZE]; // 사용자가 입력한 숫자를 저장할 배열
        int computerLotto[] = new int[SIZE]; // 컴퓨터가 생성한 난수를 저장할 배열

        for (int i = 0; i < userLotto.length; i++) {
            int userNumber = ScannerUtil.nextInt(scanner, "1 ~ 45 범위의 숫자: ", 1, MAX); // 사용자가 1~45 내의 값 입력
            while (ArrayUtil.contains(userLotto, userNumber)) {// 해당 숫자가 배열에 존재하면 다시 입력하도록 한다.
                System.out.println("중복된 숫자입니다 !");
                userNumber = ScannerUtil.nextInt(scanner, "1 ~ 45 범위의 숫자: ", 1, MAX);
            }
            userLotto[i] = userNumber;
        }
        ArrayUtil.sortByASC(userLotto); // 사용자가 입력한 수 오름차순 정렬

        for (int i = 0; i < computerLotto.length; i++) { // i 인덱스에 컴퓨터가 생성한 난수 배정
            int computerNumber = random.nextInt(MAX) + 1;
            while (ArrayUtil.contains(computerLotto, computerNumber)) { // 중복 검사
                computerNumber = random.nextInt(MAX) + 1; // 중복 안되면 다음 숫자 검사
            }

            computerLotto[i] = computerNumber; // 컴퓨터가 생성한 난수가 중복되지 않는다면 인덱스 i에 해당 숫자 저장
        }
        ArrayUtil.sortByASC(computerLotto); // 컴퓨터가 생성한 난수 오름차순 정렬
        

        // 점수 계산하기
        // 점수를 계산할 때 주의할 점은, 컴퓨터가 고른 숫자와 사용자가 고른 숫자가 같은 게 있더라도 같은 인덱스에 있는지는 장담할 수 없다.
        // 즉, userLotto[i] == computerNumber[i] 마다 점수를 올려서 계산하면 부정확한 값을 얻을 가능성이 크다.
        // 그렇다면 어떻게 해야 정확하게 점수를 계산할 수 있을까? 
        // ArrayUtil.contains를 사용하여, contains(computerLotto, userLotto[i])가 true가 나올 때마다
        // 점수를 1점씩 올리면 된다. 왜냐하면 사용자 숫자의 위치는 모르겠지만 컴퓨터 숫자 배열에 존재하는 것이므로
        // 몇개가 일치하는지를 확인할 수 있다.

        int score = 0 ;
        for (int i = 0 ; i < userLotto.length ; i++) {
            if(ArrayUtil.contains(computerLotto, userLotto[i])) {
                score ++ ;
            }
        }
        
        // 결과 출력
        // 컴퓨터 숫자와 사용자 숫자를 출력해주고 score에 따른 결과를 출력해준다.
        System.out.println("=======컴퓨터 숫자=======");
        ArrayUtil.print("computerLotto", computerLotto);
        System.out.println("======================");
        System.out.println("=======사용자 숫자=======");
        ArrayUtil.print("userLotto", userLotto);
        System.out.println("======================");
        System.out.println("맞춘 개수: " + score);
        System.out.println("등수: " + (SIZE - score +1) + "등");

        scanner.close();
    }
}
