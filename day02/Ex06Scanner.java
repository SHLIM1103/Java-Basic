package day02;
// Scanner
// 자바에서 콘솔에서의 입력은 Scanner가 담당하게 된다.
// 단 Scanner는 클래스이고 우리 패키지에는 존재하지 않기 때문에 import라는 키워드를 이용해 불러와야 한다.

import java.util.Scanner ;
public class Ex06Scanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. 정수 입력받기
        // 정수를 입력받을 때에는 scanner의 nextInt() 메소드를 호출해준다.
        System.out.print("숫자: ");
        int number = scanner.nextInt() ;
        System.out.println("number의 현재값: " + number);

        // 2. 실수 입력받기
        // 실수를 입력받을 때에는 scanner의 nextDouble() 메소드를 호출해준다.
        System.out.print("실수: ");
        double myDouble = scanner.nextDouble() ;
        System.out.println("myDouble의 현재값: " + myDouble);

        // 3. 문자열(String) 입력받기
        // 문자열을 입력받을 때에는 scanner의 nextLine() 메소드를 호출해준다.
        // String 입력 시 주의사항:
        // nextInt(), nextDouble() 등 숫자를 입력하는 메소드 이후에는 nextLine()을 바로 사용할 수 없다.
        // 왜냐하면 우리가 키보드로 입력한 값은 버퍼메모리로 가는데, 우리가 입력이 끝났음을 알려주기 위해 엔터를 치면
        // nextInt(), nextDouble()은 엔터를 제외한 "숫자값"만 버퍼메모리에서 읽어서 없앤다.
        // 즉 nextInt() 를 실행해서 123\n 이라고 입력하면, nextInt()가 123만 가져가고 \n은 버퍼메모리에 남겨둔다.
        // 하지만 nextLine() 모든 문자를 가져오게 되는데, 버퍼메모리에 남아있던 \n을 보고 사용자가 입력을 끝냈다고 착각한다.
        // 이것이 scanner의 nextLine() 버그 이다.

        System.out.print("이름: ");
        // 스캐너 버그 해결을 위해 아래 코드 실행하여 버퍼메모리 초기화!
        scanner.nextLine();
        String name = scanner.nextLine() ;
        System.out.println("name의 현재값: " + name);
        System.out.println("★끝★");

        // Scanner와 같이 버퍼메모리를 만들어서 읽는 클래스의 경우,
        // close() 라는 메소드를 가장 마지막에 호출해서 버퍼메모리를 종료시켜 주는 것이 좋다.
        scanner.close();

    }
}