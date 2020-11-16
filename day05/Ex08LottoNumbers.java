package day05;

import java.util.Random;

import util.ArrayUtil;

// 로또번호 생성기

public class Ex08LottoNumbers {
    private static final int SIZE = 6;
    private static final int MAX = 45;

    public static void main(String[] args) {
        Random random = new Random();

        // 배열을 선언해보자
        int[] lotto = new int[SIZE];

        // 배열의 각 인덱스에 랜덤을 이용한 난수를 넣어보자
        for(int i = 0 ; i < lotto.length ; i++) {
            lotto[i] = random.nextInt(MAX) + 1 ;
        }
        
        // 오름차순 정렬
        ArrayUtil.sortByASC(lotto);
        
        // 인덱스에 난수가 채워진 배열을 출력해보자
        ArrayUtil.print("lotto", lotto);
        
        System.out.println();
        
        // 위 코드에서의 문제점은 중복제거가 되지 않았다는 것이다.
        // 중복제거는 두 가지의 방법이 있다.
        //  1. 일단 숫자를 모두 채워놓고, 중복인 인덱스에 새로운 숫자 넣기
        System.out.println("1. 먼저 채워놓고 중복인 곳 다시 넣기");
        // 중복이란 인덱스(위치)가 다르지만 배열 내 해당 인덱스들의 값이 같은 것이다.
        // ex) 38 8 19 16 16 8 ---> 1번과 5번 인덱스는, 인덱스가 다르지만 배열[인덱스]의 값이 같으므로 중복
        // 따라서 우리는 2중 for문을 이용해서 i와 j가 다르지만
        // lotto[i]와 lotto[j]의 값이 같을 때에는 lotto[i]에 새로운 값을 넣어주고
        // 해당 값이 중복인지 여부를 다시 체크하게 할 것이다.
        for(int i = 0 ; i < lotto.length ; i++) {
            for(int j = 0 ; j < lotto.length ; j++) {
                // if를 통해서 i와 j가 다르지만 lotto[i]와 lotto[j]가 같으면
                // i에 새로운 숫자를 넣고 j를 -1로 초기화해서 0번 인덱스부터 다시 체크하게 만들어주자
                if(i != j && lotto[i] == lotto[j]) {
                    int oldNumber = lotto[i] ;
                    lotto[i] = random.nextInt(MAX) + 1 ;
                    int newNumber = lotto[i] ;
                    System.out.printf("lotto[%d]에 있던 %d를 %d로 바꿈\n", i, oldNumber, newNumber);
                    j = -1 ;        // j를 -1로 초기화해서 0으로(=j++) 만들어 다시 체크할 수 있게 함
                }
            }
        }
        
        // 중복제거가 됐는지 출력
        System.out.println("======중복제거 후======");
        ArrayUtil.print("lotto", lotto);
        System.out.println("=====================");
                
        
        // 중복제거된 배열을 정렬한다.
        ArrayUtil.sortByASC(lotto);
        System.out.println("=========정렬 후=======");
        ArrayUtil.print("lotto", lotto);
        System.out.println("=====================");
        
    }
}