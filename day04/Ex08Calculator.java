package day04;
// 계산기의 기능을 구현해서 계산기를 만들어보자
import java.util.Scanner;
public class Ex08Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //우리가 메소드를 배우기 전이라면, 이 안에서 + - * / 등의 기능은 매번 적어주었겠지만,
        //이제는 메소드를 통해서 해당 기능을 분리해보자!

        System.out.println("add(3, 4): " + add(3, 4));
        // 위의 코드에서 add(3, 4)는 해당 메소드의 결과값을 우리가 어딘가에 담지 않고
        // 메소드 호출 자체를 하나의 변수 이름처럼 다루는 방법이다.
        
        System.out.println("subtract(5, 2): " + subtract(5, 2));
        System.out.println("multiply(4, 5): " + multiply(4, 5));
        System.out.println("divide(9, 4): " + divide(9, 4));
        scanner.close();
    }
    
    // int + int 를 하는 add 메소드 --> 리턴타입 int
    static int add(int a, int b) {
        // a+b를 result에 저장하고, result를 return 해주자
        int result = a + b ;
        return result ;
    }
    
    // - * / 를 직접 구현해보세용
    // 단, /는 두 숫자를 나눠서 실수가 나오게 만들어주세용
    // - : subtract
    // * : multiply
    // / : divide
    
    static int subtract(int a, int b) {
        return a - b ;
    }
    
    static int multiply(int a, int b) {
        return a * b ;
    }
   
    static double divide(int a, int b) {
        return a / b ;
    }
    
}