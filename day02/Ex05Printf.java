package day02;
// printf
// printf는 출력할 내용에 % 문자를 사용하여 우리가 원하는 내용을 특정 형식으로 출력한다.

// 공백문자
// 공백문자란 특수한 공백을 넣는데 사용되는 문자이다.
// 주로 ※\ + 알파벳※ 으로 이루어져 있으며 두 글자지만 하나의 문자로 취급된다.
// \t : 스페이스 4개 분량의 탭 공백
// \n : 다음 줄을 뜻하는 개행문자
public class Ex05Printf {
    public static void main(String[] args) {
        // 1. 10진법 정수('d'ecimal)
        int number = 34 ;
        System.out.println("-----1. 10진법 정수-----");
            // A. 10진법 정수를 그대로 출력해라
            System.out.printf("1-A. %d\n", number);
            // B. 10진법 정수를 오른쪽정렬 5자리로 출력해라
            System.out.printf("1-B. %5d\n", number);
            // C. 10진법 정수를 왼쪽정렬 5자리로 출력해라
            System.out.printf("1-C. %-5d(끝)\n", number);
            // D. 10진법 정수를 오른쪽정렬 5자리로 출력하고, 왼쪽 빈자리는 0으로 채워라
            System.out.printf("1-D. %05d\n", number);

        // 2. 8진법 정수('o'ctal)
        System.out.println("-----2. 8진법 정수-----");
            // A. 8진법 정수를 그대로 출력해라
            System.out.printf("2-A. %o\n", number);
            // B. 8진법 정수를 오른쪽정렬 5자리로 출력해라
            System.out.printf("2-B. %5o\n", number);
            // C. 8진법 정수를 왼쪽정렬 5자리로 출력해라
            System.out.printf("2-C. %-5o(끝)\n", number);
            // D. 8진법 정수를 오른쪽정렬 5자리로 출력하고, 왼쪽 빈자리는 0으로 채워라
            System.out.printf("2-D. %05o\n", number);

        // 3. 16진법 정수(he'x'adecimal)
        //    16진법은 각 자리가 0~15까지 16개의 숫자로 이루어져 있고, 각 자리가 16의 제곱으로 이루어진 숫자체계이다.
        //    10~15는 A~F로 표시된다. 
        number = 30 ;
        System.out.println("-----3. 16진법 정수-----");
            // A. 16진법 정수를 그대로 표시하고, 알파벳이 있으면 소문자로 표시해라
            System.out.printf("3-A. %x\n", number);
            // B. 16진법 정수를 그대로 표시하고, 알파벳이 있으면 대문자로 표시해라
            System.out.printf("3-B. %X\n", number);
            // C. 16진법 정수를 오른쪽정렬 5자리로 표시하고, 알파벳이 있으면 소문자로 표시해라
            System.out.printf("3-C. %5x\n", number);
            // D. 16진법 정수를 오른쪽정렬 5자리로 표시하고, 알파벳이 있으면 대문자로 표시해라
            System.out.printf("3-D. %5X\n", number);
            // E. 16진법 정수를 왼쪽정렬 5자리로 표시하고, 알파벳이 있으면 소문자로 표시해라
            System.out.printf("3-E. %-5x(끝)\n", number);
            // F. 16진법 정수를 왼쪽정렬 5자리로 표시하고, 알파벳이 있으면 대문자로 표시해라
            System.out.printf("3-F. %-5X(끝)\n", number);
            // G. 16진법 정수를 오른쪽정렬 5자리로 표시하고 왼쪽 빈자리에는 0으로 채우고 알파벳은 대문자로 표시해라
            System.out.printf("3-G. %05X\n", number);

        // 4. 실수('f'loat)
        //    비록 표기는 f이지만 double과 float 모두 들어올 수 있다.
        double myDouble = 1234.5678 ;
            // A. 실수를 그대로 표시해라
            System.out.printf("4-A. %f\n", myDouble);
            // B. 실수를 오른쪽정렬 12자리로 표시해라
            System.out.printf("4-B. %12f\n", myDouble);     // ---> 소수점도 한자리를 차지함
            // C. 실수를 왼쪽정렬 12자리로 표시해라
            System.out.printf("4-C. %-12f(끝)\n", myDouble);
            // D. 실수를 소수점 2번째자리까지 표시해라 
            System.out.printf("4-D. %.2f\n", myDouble);
            // E. 실수를 오른쪽정렬 12자리로 표시하고, 소수점은 3번째 자리까지 표시해라
            System.out.printf("4-E. %12.3f\n",myDouble);
            // F. 실수를 왼쪽정렬 10자리로 표시하고, 소수점은 1번째 자리까지 표시해라
            System.out.printf("4-F. %-10.1f(끝)\n", myDouble);
            // G. 실수를 오른쪽정렬 12자리로 표시하고, 소수점은 2번째 자리까지 표시하고, 왼쪽 빈자리는 0으로 채워라
            System.out.printf("4-G. %012.2f\n", myDouble);
            
        // 5. 과학표기법(자연로그 'e')
        System.out.println("-----5. 과학표기법-----");
            // A. 실수를 과학표기법으로 표시해라
            System.out.printf("5-A. %e\n", myDouble);
        
        // 6. 문자열('S'trint)
        System.out.println("-----6. 문자열-----");
        String string1 = new String("abcDEFghi");
            // A. 문자열을 그대로 표시해라
            System.out.printf("6-A. %s\n", string1);
            // B. 문자열을 표시하되, 알파벳 소문자가 있으면 대문자로 바꾸어 표시해라
            System.out.printf("6-B. %S\n", string1);
            
        // printf 주의점:
        // 1. 우리가 자릿수를 지정할 경우, 출력할 내용이 더 길면 자릿수 지정은 무시된다.
        System.out.printf("%3d\n", 1234567);        // 출력하는 내용이 7자리이므로 3자리 지정은 무시
        // 2. 만약 잘못된 % 문자를 쓰면 에러가 난다.
        // System.out.printf("%z\n", 12345678);
        // 3. %와 맞지 않는 형식의 데이터가 넘어오면 에러가 난다.
        // System.out.printf("%d\n", 123.456);
        // 4. 만약 % 문자가 나온 횟수보다 뒤의 값들이 더 많은 경우는 에러가 나지는 않지만,
        //    반대로 % 문자가 더 많이 나오면 에러가 난다.
        System.out.printf("%d %f %s\n", 1, 2.34, "abc", 4, 5.67);
        //System.out.printf("%d %f %s %d %f %s\n", 1, 2.34, "abc");
    }
}