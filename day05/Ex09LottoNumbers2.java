package day05;

import java.util.Random;

import util.ArrayUtil;

// 로또번호 제작기 2번
// 중복체크를 다르게 해보자

public class Ex09LottoNumbers2 {
    private static final int SIZE = 6;
    private static final int MAX = 45;

    public static void main(String[] args) {

        Random random = new Random();

        int[] lotto = new int[SIZE];

        // 이번에 사용할 방법은
        // 랜덤 숫자를 곧장 넣고 나중에 중복인 값들을 찾는 것이 아니라,
        // 랜덤 숫자를 하나 생성하고 만약 그 숫자가 배열에 이미 존재하면 다시 랜덤숫자를 만드는 것을 반복해서
        // 배열에 존재하지 않는 랜덤숫자가 나오면 그제서야 i에 해당하는 숫자를 넣는 방법이다.

        for (int i = 0; i < lotto.length; i++) {
            int randomNumber = random.nextInt(MAX) + 1;
            while (ArrayUtil.contains(lotto, randomNumber)) {
                randomNumber = random.nextInt(MAX) + 1;
            }
            lotto[i] = randomNumber;
        }

        // 중복제거 버전 1은 무슨 숫자가 나왔든 간에, 다 채워놓고 중복인 곳을 찾아서 다시 난수를 입력하는 방식
        // 중복제거 버전 2는 먼저 해당 숫자가 배열에 존재하는지 확인해서, 존재하지 않을 때에만 배열에 추가하는 방식

        System.out.println("=====중복제거 ver. 2=====");
        ArrayUtil.sortByASC(lotto);
        ArrayUtil.print("lotto", lotto);
        System.out.println("=======================");

    }
}
