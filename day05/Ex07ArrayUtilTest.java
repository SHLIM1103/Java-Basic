package day05;

import util.ArrayUtil;

public class Ex07ArrayUtilTest {
    public static void main(String[] args) {

        // 배열을 초기화할 때 2가지 방법이 있는데,
        // 1. ※ int[] 배열이름 = new int[크기]; ※
        // 2. 각 인덱스마다 값을 넣어주는 방법

        // 2번의 방법은 즉석에서 배열을 만들어서, 그 배열로 초기화해라 라는 방법인데 아래 코드와 같다.
        int[] arr = { 5, 1, 2, 3, 0 };
        // 위의 코드는 int[] arr = new int[5];
        // arr[0] = 5;
        // arr[1] = 1 ;
        // ...
        // arr[4] = 0 ; 과 같은 의미를 가진다.
        // 단 이 방법의 단점은, 미리 값이 존재하지 않으면 사용할 수 없다는 것이다.

        // ArrayUtil.print() 테스트
        System.out.println("원래 배열:");
        ArrayUtil.print("intArray", arr);
        System.out.println();
        
        // ArrayUtil.sortByASC() 테스트
        System.out.println("오름차순:");
        ArrayUtil.sortByASC(arr);
        ArrayUtil.print("intArray", arr);
        System.out.println();

        // ArrayUtil.sortByDESC() 테스트
        System.out.println("내림차순:");
        ArrayUtil.sortByDESC(arr);
        ArrayUtil.print("intArray", arr);

    }
}