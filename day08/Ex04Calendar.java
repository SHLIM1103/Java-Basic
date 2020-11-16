package day08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import util.ScannerUtil;

// Calendar 클래스
// 자바는 시간을 표시하거나 시간을 설정하는 클래스가 다양하게 있다.

// 기존에는 Date 혹은 DateTime 정도만 사용했지만,
// 자바 측에는 해당 클래스들이 "Deprecated" 즉, 구식이 되었으므로
// 시간을 표시하거나 설정할 때는 Calendar를,
// 시간의 차이를 계산할 때는 Chronicle을 사용하는 것을 권장하고 있다!

// Calendar의 경우에는, 1970년 1월 1일부터 지금까지(혹은 사용자가 설정한 시간까지)를 1/1000초 단위로 계산한다.
// 그것을 기반으로 해서 여러 가지 값으로 보여주거나,
// DateFormat이라는 것을 사용하여 원하는 양식으로 출력해 줄 수도 있다!

public class Ex04Calendar {
    public static void main(String[] args) {
        // Calendar 클래스의 초기화는 아래와 같이 한다.
        Calendar cal = Calendar.getInstance();
        System.out.println("cal: " + cal);

        // 캘린더에서 각 필드의 값을 알고 싶다면 ※ get(Calendar.필드이름) ※ 으로 알 수 있다.
        System.out.println("cal.get(Calendar.DATE): " + cal.get(Calendar.DATE) + "일");
        // 대표적으로 사용하는 것은 Calendar.DATE, Calendar.MONTH 등이 있다.

        // Calendar 객체에 시간을 직접 넣어줄 때에는 set() 메소드를 호출한다.
        // set() 메소드는 아래와 같이 4가지 방법이 가능하다.
        // 1. 특정 필드에 값을 직접 저장
        // 2. 연 월 일에 해당하는 값을 저장
        // 3. 연 월 일 시 분에 해당하는 값을 저장
        // 4. 연 월 일 시 분 초에 해당하는 값을 저장

        System.out.println("set 1번: 필드에 값 저장");
        System.out.println("저장 전 cal.get(Calendar.DATE): " + cal.get(Calendar.DATE) + "일");
        cal.set(Calendar.DATE, 25);
        System.out.println("저장 후 cal.get(Calendar.DATE): " + cal.get(Calendar.DATE) + "일");

        System.out.println("set 2번: 연 월 일 저장");
        cal = Calendar.getInstance();
        System.out.printf("저장 전: %d년 %d월 %d일\n", 
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,
                cal.get(Calendar.DATE));

        cal.set(2009, 4, 27);
        System.out.printf("저장 후: %d년 %d월 %d일\n", 
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,
                cal.get(Calendar.DATE));


        // 시간을 보기 좋게 출력하기 위해서는,
        // DateFormat 혹은 SimpleDateFormat 클래스 객체를 통해서 포맷을 지정해야 한다.
        // 포맷의 경우
        // 년: y  
        // 월: M  
        // 일: d
        // 시: 12시간은 h, 24시간은 H
        // 분: m
        // 초: s 를 사용하여 직접 지정해준다.
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        
        // DateFormat의 경우, 1/1000초 단위를 우리가 지정한 String 양식으로 바꿔주는 역할도 하지만
        // 우리가 입력한 String이 지정한 양식과 일치하면 1/1000초로 바꾸는 역할도 한다.
        
        System.out.println("sdf 적용 전: " + cal.getTime());
        System.out.println("sdf 적용 후: " + sdf.format(cal.getTime()));
       
        sdf = new SimpleDateFormat("y-M-d H:m:s");
        System.out.println("sdf 적용 전: " + cal.getTime());
        System.out.println("sdf 적용 후: " + sdf.format(cal.getTime()));
        
        // sdf를 이용하여 Calendar 객체를 만들어보기
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("년: ");
        int year = ScannerUtil.nextInt(scanner);
        System.out.print("월: ");
        int month = ScannerUtil.nextInt(scanner);
        System.out.print("일: ");
        int date = ScannerUtil.nextInt(scanner);
        System.out.print("시: ");
        int hour = ScannerUtil.nextInt(scanner);
        System.out.print("분: ");
        int minute = ScannerUtil.nextInt(scanner);
        System.out.print("초: ");
        int second = ScannerUtil.nextInt(scanner);
        
        // 입력받은 연 월 일 시 분 초로 String을 만들어보자
        String temp = year + "-" + month + "-" + date + " " + hour + ":"+ minute + ":" + second ;
        System.out.println("사용자가 입력한 값을 String: " + temp);
        
        // 만들어진 String을 sdf의 parse를 이용하여 캘린더로 바꿔보자
        // 단, 시간이 잘못됐거나 바꿀 수 없는 경우가 존재하기 때문에 try/catch라는 것을 통해 감싸주어야 한다.
        
        // try/catch 구조란, 혹시라도 발생할 수 있는 심각한 오류에 대비하여
        // 그 오류가 날 수 있는 코드를 try에서 실행하고
        // 만약 오류가 발생한다면 catch가 해결하는 형태의 코드이다.
        
        try {
            // sdf가 변환한 temp를 cal에 저장
            // 만약, 사용자가 정확하지 않은 값을 입력했을 때 cal 객체의 셋팅에 따라 결과가 나타난다.
            // 1. lenient 모드(자비로운 모드)
            //    만약 잘못된 시간 형식이면 융통성있게 시간을 환산해준다.
            //    예를들어 월을 25월로 입력한다면 알아서 2년 1개월로 환산하여
            //    년에 2년 더하고 1월로 설정한다.
            
            cal.setTime(sdf.parse(temp));
            System.out.println(cal.getTime());
            
            // 2. strice 모드(엄격한 모드)
            //    잘못된 시간은 전부 변환하지 않는다. (에러발생!)
            sdf.setLenient(false);
            cal.setTime(sdf.parse(temp));
            System.out.println(cal.getTime());
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        
        scanner.close();
       
    }
}
