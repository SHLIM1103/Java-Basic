package day01;
// 연산자
// 연산자란 수학적 기호에 프로그래밍적 기능이 정의되어 있어서 우리가 특정 기호를 쓰면 내부적으로 해당 기능이 실행되는 것을 의미한다.
// 연산자는 산술/할당/비교/논리/비트 등 5가지로 분류할 수 있다.

public class Ex10Operator01 {
    public static void main(String[] args) {

        // 산술연산자: 간단한 사칙연산 및 나머지값을 구해주는 연산자

        int myNumber1 = 10 ;
        int myNumber2 = 15 ;

        System.out.println("myNumber1 + myNumber2 = " + (myNumber1 + myNumber2));
        System.out.println("myNumber1 - myNumber2 = " + (myNumber1 - myNumber2));
        System.out.println("myNumber1 * myNumber2 = " + (myNumber1 * myNumber2));
        System.out.println("myNumber1 / myNumber2 = " + (myNumber1 / myNumber2));
        // 나눗셈의 경우: 정수형 / 정수형 ==> 정수형으로 값이 나온다. 
        //            예를들어 10 / 15 의 경우 ==> 몫은 0, 나머지는 10 이다.
        //            그러므로 결과값은 몫인 '0'만 나오게 된다.
        System.out.println("myNumber1 % myNumber2 = " + (myNumber1 % myNumber2));

        // 하지만, 산술연산의 경우 한 쪽이 실수이면 결과값도 실수가 된다.
        System.out.println("myNumber1 + myNumber2 = " + ((double)myNumber1 + myNumber2));   // --> myNumber1: 실수로 형변환됨
        System.out.println("myNumber1 - myNumber2 = " + ((double)myNumber1 - myNumber2));
        System.out.println("myNumber1 * myNumber2 = " + ((double)myNumber1 * myNumber2));
        System.out.println("myNumber1 / myNumber2 = " + ((double)myNumber1 / myNumber2));
        System.out.println("myNumber1 % myNumber2 = " + ((double)myNumber1 % myNumber2));

        // 아래는 결과값이 어떻게 나올까?
        double result = myNumber1 / myNumber2 ;
        System.out.println("result의 현재값: " + result);
        // 위 코드는 0.0이 결과값으로 나오는데, myNumber1 / myNumber2 는 int / int 이기 때문에 몫만 온전하게 나온다.
        // 즉 0이란 결과값을 실수로 바꾸면 0.0이 되기 때문에 result = 0.0 으로 출력된다.

        // String이란 여러개의 문자를 모아둔 문자열을 관리하는 클래스이다.
        // 우리가 String 변수를 만드는 것은 '여러 개의 문자를 다루겠다' 라는 의미이다.
        // ""로 둘러쌓인 문자들은 String으로 인식된다.
        String str = new String();
        // 그렇다면 여러개의 문자에 + 연산자를 실행하면 어떤 결과가 나올까?
        // String + String ==> '2개의 문자열을 이어 붙이겠다' 라는 의미가 된다.
        str = "abc" ;
        String str2 = new String();
        str2 = "DEF" ;
        System.out.println(str + str2);

        // 만약 String + 다른 데이터타입의 경우에는 다른 데이터타입을 String으로 변환한 후
        // 변환된 String을 뒤에 이어 붙인다.
        System.out.println("123" + 456);        // 456은 int값 ==> string값으로 변환된 것

        // 증감연산자
        // 산술연산자 중에서 특이하게 ++ 혹은 --로 적는 경우가 있는데,
        // 이 때에는 현재 변수의 값을 1씩 증가시키거나 감소시키라는 의미가 된다.
        // 다만 ++/--가 변수의 앞에 붙는지 뒤에 붙는지 여부에 따라 의미가 달라지게 된다.
        System.out.println("myNumber1의 현재값: " + myNumber1);
        System.out.println("++myNumber1의 값: " + ++myNumber1);
        // 위 코드는 다음과 같은 순서를 가지게 된다.
        // 1. ++myNumber1 실행, myNumber1의 값이 10에서 11으로 변경된다.
        // 2. myNumber1의 값을 String으로 변환한다.
        // 3. "++myNumber1: " 뒤에 String으로 변환된 myNumber1의 값이 이어진다.
        // 4. System.out.println()이 3번의 결과값을 화면에 출력한다.
        System.out.println("myNumber1의 현재값: " + myNumber1);
        // 이렇게 ++/--가 앞에 붙을 경우 ==> 전위증가/전위감소 연산자 라고 한다.
        
        System.out.println("++myNumber1의 값: " + myNumber1++);
        // 위 코드는 다음과 같은 순서를 가지게 된다.
        // 1. myNumber1의 값을 String으로 변환한다.
        // 2. "myNumber1++: " 뒤에 String으로 변환된 myNumber1의 값이 이어진다.
        // 3. System.out.println()이 2번의 결과값을 화면에 출력한다.
        // 4. myNumber1++가 실행되서 myNumber1의 값이 11에서 12로 변경된다.
        System.out.println("myNumber1의 현재값: " + myNumber1);
        // 이렇게 ++/--가 뒤에 붙을 경우 ==> 후위증가/후위감소 연산자 라고 한다.
    }
}