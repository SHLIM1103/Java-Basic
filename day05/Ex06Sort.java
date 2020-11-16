package day05;
// 정렬

// 배열에서 우리가 정렬하는 코드를 구현해보자

// 정렬 : 어떤 기준에 따라 모여있는 것들의 순서를 맞춰주는 것
// 만약 int 배열을 정렬한다고 하면, 두가지 선택이 있다.
// 1. 작은 값 -> 큰 값 순서 : 오름차순 정렬
// 2. 큰 값 -> 작은 값 순서 : 내림차순 정렬

public class Ex06Sort {
    public static void main(String[] args) {

        int[] intArray = new int[5];
        intArray[0] = 14;
        intArray[1] = 22;
        intArray[2] = 7;
        intArray[3] = 128;
        intArray[4] = 2;

        // 지금의 배열은 14 22 7 128 2
        System.out.println("==============정렬전================");
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("intArray[%d]: %d\n", i, intArray[i]);
        }

        // i : 0
        // intArray[i] : 14
        // intArray[i+1] : 22
        // 14와 22를 비교, 22가 더 크므로 i++
        // i : 1
        // intArray[1] : 22
        // intArray[2] : 7
        // 22와 7을 비교, 22가 더 크므로 두 숫자 자리 바꿔줌
        // 배열은 14 7 22 128 2 가 됨, i++
        // ...
        // i : 3
        // intArray[3] : 128
        // intArray[4] : 2
        // 128이 더 크므로 두 숫자 자리 바꿔줌
        // 배열은 14 7 22 2 128 이 됨, i++
        // i : 4
        // intArray[4] : 128
        // intArray[5] : 에러 발생!! ---> for문의 범위는 intArray.length -1 로 설정해야 한다.

        // 따라서, 정렬의 경우 for문은 ---> for(int i = 0 ; i < array.length - 1 ; i++) 처럼 되어야 한다.
        // 또한, for문의 반복할 내용이 끝나면 i++이 실행되므로,
        // 우리가 만약 i번째와 i+1번째의 값을 서로 바꿨으면 다시 0번부터 검사하기 위해서는
        // i를 -1로 초기화해야 i++을 통해서 i가 0이 되어 처음부터 검사할 수 있다.

        // 오름차순 정렬하면 2 7 14 22 128 순이 되어야 한다.
        // 오름차순 정렬일때, 만약 i 번 인덱스가 i+1번 인덱스보다 크면 순서를 바꾸어 주어야 하고 다시 맨처음부터 검사해야 한다.

        for (int i = 0; i < intArray.length - 1; i++) {

            // 기준 숫자
            int number1 = intArray[i];
            // 그 다음 인덱스에 있는 숫자
            int number2 = intArray[i + 1];
            if (number1 > number2) {
                // 현재 숫자가 다음 숫자보다 크므로, 두 숫자의 위치를 바꿔준다!

                // 프로그래밍에서 2개의 값을 바꾸어 줄때에는, 반드시 임시변수에 a의 값을 저장하고,
                // a에 b의 값을 넣은 뒤 b에 임시변수의 값을 넣는 순으로 진행해야 한다.
                int tmp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = tmp;
                i = -1; // i++ 이 실행되고 나면 i = 0이 되므로 처음부터 다시 검사하게 됨.
            }
        }
        System.out.println("===========오름차순 정렬 후===========");
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("intArray[%d]: %d\n", i, intArray[i]);
        }

        // 내림차순 정렬하면 128 22 14 7 2 순이 되어야 한다.
        for (int i = 0; i < intArray.length - 1; i++) {

            // 기준 숫자
            int number1 = intArray[i];
            // 그 다음 인덱스에 있는 숫자
            int number2 = intArray[i + 1];
            if (number1 < number2) {
                // 현재 숫자가 다음 숫자보다 작으므로, 두 숫자의 위치를 바꿔준다!

                // 프로그래밍에서 2개의 값을 바꾸어 줄때에는, 반드시 임시변수에 a의 값을 저장하고,
                // a에 b의 값을 넣은 뒤 b에 임시변수의 값을 넣는 순으로 진행해야 한다.
                int tmp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = tmp;
                i = -1; // i++ 이 실행되고 나면 i = 0이 되므로 처음부터 다시 검사하게 됨.
            }
        }
        System.out.println("===========내림차순 정렬 후===========");
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("intArray[%d]: %d\n", i, intArray[i]);
        }
        System.out.println("=================================");

    }
}
