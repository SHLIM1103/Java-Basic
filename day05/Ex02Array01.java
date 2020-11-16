package day05;
// 배열
// 배열이란, 똑같은 데이터타입을 지정한 크기만큼 모아두어서 한 번에 여러 개를 다룰 수 있게 하는 방법이다.
// 예를 들어, 같은 목적을 가진 int 변수 10개가 필요한 경우 변수 10개를 각각 만들기 보다는
// int 변수 10개가 모인 배열 변수 1개를 만드는 것이 효율적일 것이다.
// 그리고 각각을 배열 0번, 배열 1번 ... 배열 9번 이라고 지칭하면 각각의 공간을 호출할 수 있게 된다.

public class Ex02Array01 {
    public static void main(String[] args) {

        // 배열의 선언과 초기화
        // ※ 데이터타입[] 배열이름 = new 데이터타입[크기]; ※

        // int 5개가 모여있는 int배열 intArray 를 선언해보자.
        int[] intArray = new int[5];

        // index : 배열처럼 특정 데이터타입을 여러개 모아둔 변수를 다룰 때 각 공간의 번호를 의미
        //         인덱스는 항상 0 ~ (크기-1) 까지의 값을 가진다. (만약 잘못된 인덱스를 넘겨주면 에러 발생)
        //         ex) index가 음수이거나 크기 이상일 경우

        // 그렇다면 for문을 이용해서 배열의 내용을 모두 출력해보자.
        for(int i = 0 ; i < intArray.length ; i ++) {
            // ※ 배열이름.length ※ 는 해당 배열의 크기를 return 해준다.
            // 배열의 각 공간에 접근할 때에는 ※ 배열이름[인덱스] ※ 로 접근 가능
            // 배열을 선언할 때의 크기나, 배열의 각 공간을 접근할 때의 index에는 변수가 들어갈 수도 있다.
            System.out.printf("intArray[%d]: %d\n", i, intArray[i]);
        }

        // 잘못된 index일 때에는 아래와 같은 에러가 발생한다.
        // ArrayIndexOutOfBoundsException  ---> 배열의 인덱스가 범위를 벗어났음
        // System.out.println("intArray[-1]: " + intArray[-1]);    // -1은 index의 크기를 벗어났으므로 에러 발생
        // System.out.println("intArray[100]: " + intArray[100]);  // 100은 index의 크기를 벗어났으므로 에러 발생
        
        // 배열 중 기본형 데이터타입의 배열일 때에는 모든 칸이 0으로 초기화 된다.
        // 배열 중 참조형 데이터타입의 배열일 때에는 모든 칸이 null로 초기화 된다.
        
        // ※ 배열이름[인덱스] ※ 는 하나의 변수와 같다고 볼 수 있기에 해당 공간에 값을 입력하거나 저장된 값을 불러올 수 있다.
        intArray[0] = 15 ;
        System.out.println("intArray[0]: " + intArray[0]);
        
    }
}
