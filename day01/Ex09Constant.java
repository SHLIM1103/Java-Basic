package day01;
// 상수(Constant)
// 상수는 한번 값이 초기화되면 더이상 바꿀 수 없게 된다.
// 상수는 우리가 제일 앞에 final 이라는 키워드를 붙여서 만들어준다.

public class Ex09Constant {
    public static void main(String[] args) {
        int myNumber = 30 ;
        System.out.println("myNumber의 현재값: " + myNumber);

        final int MY_NUMBER = 20 ;
        System.out.println("MY_NUMBER의 현재값: " + myNumber);

        myNumber = 40 ; 
        System.out.println("myNumber의 현재값: " + myNumber);
        // myNumber는 변수이기 때문에 20에서 40으로 다시 초기화하면 값이 바뀌지만,
        // MY_NUMBER는 상수이기 때문에 값을 다시 설정해줘도 바뀌지 않는다.
        // MY_NUMBER = 25 ;    // <== 오류 발생

        // 상수는 우리가 하드코딩을 피하기 위해서 적극적으로 사용해야 한다.        
    }
}