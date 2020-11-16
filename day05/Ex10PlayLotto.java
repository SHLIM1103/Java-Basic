package day05;

import java.util.Random;
import java.util.Scanner;

import util.ArrayUtil;

// 로또 게임 해보기
// 사용자가 숫자를 선택해서, 컴퓨터가 만들어준 숫자들과 비교하여
// 6개 일치: 1등
// 5개 일치: 2등
// 4개 일치: 3등
// 3개 일치: 4등
// 이 출력되는 프로그램을 작성하시오.
// 단, 사용자가 숫자를 선택할 때에는 불가능한 번호나 중복된 번호는 입력할 수 없게 프로그램을 작성하시오.

public class Ex10PlayLotto {
    private static final int SIZE = 6;
    private static final int MAX = 45;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userLotto[] = new int[SIZE];
        for (int i = 0; i < userLotto.length; i++) {
            System.out.print("숫자: ");
            userLotto[i] = scanner.nextInt();
        }
        ArrayUtil.sortByASC(userLotto);

        int computerLotto[] = new int[SIZE];

        for (int i = 0; i < computerLotto.length; i++) {
            int computerNumber = random.nextInt(MAX) + 1;
            while (ArrayUtil.contains(computerLotto, computerNumber)) {
                computerNumber = random.nextInt(MAX) + 1;
            }
            computerLotto[i] = computerNumber;
        }
        ArrayUtil.sortByASC(computerLotto);

        int correct = 0;

        for (int i = 0; i < userLotto.length; i++) {
            for (int j = 0; j < computerLotto.length; j++) {
                if (userLotto[i] == computerLotto[j]) {
                    correct++;
                }
            }
        }
        
        System.out.printf("일치하는 숫자의 개수: " + correct);
        
        scanner.close();
    }
}
