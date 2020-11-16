package day06;

import java.util.Random;

// 가변배열
// 가변배열이란, 다차원 배열 중 각 배열의 길이가 제각각 다른 형태인 배열이다.
// 예) int[][] intArray = new int[3][] 인 경우,
//    intArray[0] = new int[3] ;
//    intArray[1] = new int[4] ;
//    intArray[2] = new int[1] ;
// 위와 같이 만드는 것이다.

public class Ex01Array01 {
    private static final int MAX_SIZE = 5 ;
    public static void main(String[] args) {
        int[][] intArray = new int[3][];
        // intArray는 int배열 3개를 모아둔 2차원 배열이다.
        // 즉 int배열이기만 하면, 각각의 크기는 얼마가 되어도 괜찮은 것이다.

        Random random = new Random();
        for(int i = 0 ; i < intArray.length ; i++) {
            intArray[i] = new int[random.nextInt(MAX_SIZE) +1];
        }
        
        System.out.println("intArray 각 배열의 크기");
        System.out.println("intArray[0].length: " + intArray[0].length);
        System.out.println("intArray[1].length: " + intArray[1].length);
        System.out.println("intArray[2].length: " + intArray[2].length);
        
    }
}
