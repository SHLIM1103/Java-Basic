package day02;
// 사용자로부터 성별 나이 신체등급을 입력받아
// 현역, 공익, 면제, 그리고 의무가 없습니다가 출력되는 프로그램을 작성하시오.
// 1~3 : 현역 / 4: 공익 / 그외: 면제
// tip)
// 여성인 경우는 나이조차도 입력받을 필요 없음!!
// 남자인 경우는 나이가 해당되지 않으면 입력받을 필요 없음!!

import java.util.Scanner;
public class Ex17NestedIf01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. 여성 2. 남성 : ");
        int sex = scanner.nextInt();

        if(sex == 2) {
            //성별이 남성이므로 나이를 입력받는다
            System.out.print("나이: ");
            int age = scanner.nextInt();

            if(age >= 18) {
                // 18세 이상이면 성인이므로 신체등급을 입력받는다.
                System.out.print("신체등급: ");
                int grade = scanner.nextInt();

                if(grade >= 1 && grade <= 3) {
                    System.out.println("현역");
                }else if(grade == 4) {
                    System.out.println("공익");
                }else {
                    System.out.println("면제");
                }

            }else {
                // 미성년자이므로 메시지만 출력해준다.
                System.out.println("미성년입니다.");
            }

        }else {
            // 성별이 여성이므로 나이조차도 입력받지 않고 해당없음으로 출력
            System.out.println("병역의무 없음");
        }

        scanner.close();
    }
}