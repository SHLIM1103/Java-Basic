package day01;
// 할당연산자
// 할당연산자는 그 뒤에 나오는 값을 연산하여 앞의 변수 혹은 상수에 할당한다.

// =, +=, -+, *=, /=, %=
public class Ex11Operator02 {
    public static void main(String[] args) {
        
        int number ;

        // 1. 뒤의 값 5를 앞의 공간 number에 할당(=대입)해라
        number = 5 ;
        System.out.println("number의 현재값: " + number);
        
        // 2. 뒤의 값 3을 앞의 공간 number 현재값에 더한 후에 그 결과값을 다시 number에 할당(=대입)해라
        number += 3 ;
        System.out.println("number의 현재값: " + number);
        
        // 3. 뒤의 값 2를 앞의 공간 number 현재값에 뺀 후에 그 결과값을 다시 number에 할당(=대입)해라
        number -= 2 ;
        System.out.println("number의 현재값: " + number);
        
        // 4. 뒤의 값 3을 앞의 공간 number 현재값에 곱한 후에 그 결과값을 다시 number에 할당(=대입)해라
        number *= 3 ;
        System.out.println("number의 현재값: " + number);
        
        // 5. 뒤의 값 4를 앞의 공간 number 현재값에 나눈 후에 그 "몫"을 다시 number에 할당(=대입)해라 
        number /= 4 ;
        System.out.println("number의 현재값: " + number);
        
        // 6. 뒤의 값 5를 앞의 공간 number 현재값에 나눈 후에 그 "나머지"를 다시 number에 할당(=대입)해라
        number %= 5 ;
        System.out.println("number의 현재값: " + number);
        
    }
}
