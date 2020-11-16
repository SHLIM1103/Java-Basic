package day02;
// 자바에서 콘솔에 출력하는 3가지 방법
// print  : () 안의 내용을 출력하고, 다음 출력 위치는 바로 오른쪽 칸이 된다. (빈칸/줄바꿈 없음) 
// println: print a line의 줄임말. () 안의 내용을 출력하고, 다음 출력 위치는 다음출 첫번째 칸이 된다.
// printf : print in format의 줄임말. () 안의 내용을 '형식'에 맞게 출력하고, 다음 출력 위치는 바로 오른쪽 칸이 된다. 

public class Ex04Print {
    public static void main(String[] args) {
        // 1. print()
        System.out.print("1. abc");
        System.out.print("2. DEF");
        
        // 2. println()
        System.out.println("3. ghi");
        System.out.println("4. JKL");
        
        // 3. printf()
        System.out.printf("5. mno");
        System.out.printf("6. PQR");
    }
}
