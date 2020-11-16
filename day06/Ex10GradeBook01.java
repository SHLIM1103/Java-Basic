package day06;

import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

// 동적 할당을 이용하여 우리가 원하는 만큼의 학생을 관리할 수 있는 성적관리 프로그램 작성

public class Ex10GradeBook01 {
    private static int MAX_SIZE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showMenu(scanner);

        scanner.close();
    }

    private static void showMenu(Scanner scanner) {
        Student[] studentArray = new Student[0];

        while (true) {
            System.out.println("==============================");
            System.out.println("|           비트고등학교         |");
            System.out.println("|         성적관리 프로그램        |");
            System.out.println("==============================");
            System.out.println("|    (1)입력 (2)전체출력 (3)종료   |");
            System.out.println("==============================");

            int userChoice = ScannerUtil.nextInt(scanner, " > ", 1, 3);

            if (userChoice == 1) {
                // 입력을 담당하는 메소드 호출
                studentArray = insert(scanner, studentArray);

            } else if (userChoice == 2) {
                // 출력을 담당하는 메소드 호출
                studentArray = printAll(scanner, studentArray);

            } else if (userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private static Student[] insert(Scanner scanner, Student[] studentArray) {
        if (ArrayUtil.size(studentArray) < MAX_SIZE) {
            // 칸이 남았으므로 입력

            // 학생의 정보를 저장할 변수를 하나 만들자
            Student s = new Student();

            // 학생의 정보를 차례대로 넣어보자.
            System.out.print("번호: ");
            s.setId(scanner.nextInt());

            System.out.print("이름: ");
            s.setName(ScannerUtil.nextLine(scanner));

            s.setKorean(ScannerUtil.nextInt(scanner, "국어: ", 0, 100));
            s.setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 0, 100));
            s.setMath(ScannerUtil.nextInt(scanner, "수학: ", 0, 100));

            // 정보가 추가된 s를 배열에 추가해주자
            studentArray = ArrayUtil.add(studentArray, s);

        } else {
            // 칸이 없으므로 경고메시지만 출력
            System.out.println("※더이상 입력할 수 없습니다.※\n※관리명단의 목록이 꽉 찼습니다.※");
        }

        return studentArray;
    }

    private static Student[] printAll(Scanner scanner, Student[] studentArray) {
        // 만약 배열에 한명의 학생도 없으면 아무도 없다 만 출력해주자
        if (ArrayUtil.size(studentArray) == 0) {
            System.out.println("아직 입력된 학생이 없습니다.");
        } else {
            System.out.println("==========================================");
            for (int i = 0; i < studentArray.length; i++) {
                System.out.printf("%d. %s\n", i+1, studentArray[i].getName());
            }
            System.out.println("==========================================");
            int userChoice = ScannerUtil.nextInt(scanner, "출력할 학생의 번호를 선택해주세요(뒤로가기는 0): ", 0, studentArray.length) - 1;

            if (userChoice != -1) {
                // 개별보기하는 메소드를 호출한다.
                studentArray = selectOne(scanner, studentArray, userChoice);
            }

        }

        return studentArray;
    }

    // 객체를 개별보기하고, 혹시라도 수정/삭제 시에는 관련 메소드를 호출해주는 메소드
    private static Student[] selectOne(Scanner scanner, Student[] studentArray, int index) {

        // 먼저, 파라미터로 넘어온 studentArray에서 index를 사용하여 사용자가 선택한 객체를 출력하자
        Student s = studentArray[index];
        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어점수: %03d점 영어점수: %03d점 수학점수: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        
        System.out.printf("총점: %03d점 평균: %.2f점\n", s.calculateSum(), s.calculateAve());
        System.out.println("==========================================");
        int userChoice = ScannerUtil.nextInt(scanner, "(1)수정 (2)삭제 (3)뒤로가기", 1, 3);
        if (userChoice == 1) {
            // 수정하는 메소드 호출
            updateStudent(scanner, studentArray[index]);

            // 수정이 완료되고 나면 다시 개별보기로 돌아오게 만들어주자
            studentArray = selectOne(scanner, studentArray, index);

        } else if (userChoice == 2) {
            // 삭제하는 메소드 호출
            // 삭제 후에는 목록보기로 가서 삭제가 정상적으로 됐는지 보여준다.
            studentArray = deleteStudent(scanner, studentArray, index);
            studentArray = printAll(scanner, studentArray);
        }

        return studentArray;
    }


    // 수정하는 메소드
    private static void updateStudent(Scanner scanner, Student s) {
        System.out.println("==========================================");
        System.out.println("                   수정                    ");
        System.out.println("==========================================");
        System.out.println("번호: " + s.getId() + "번");
        System.out.println("이름: " + s.getName());

        s.setKorean(ScannerUtil.nextInt(scanner, "국어: ", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 0, 100));
        s.setMath(ScannerUtil.nextInt(scanner, "수학: ", 0, 100));
    }

    private static Student[] deleteStudent(Scanner scanner, Student[] studentArray, int index) {
        System.out.print("해당 학생을 정말 삭제하시겠습니까? y/n: ");
        String agree = ScannerUtil.nextLine(scanner);
        // 만약 사용자가 y를 누르면 삭제, 그 외에는 그냥 무시
        if(agree.equals("y")) {
            studentArray = ArrayUtil.removeByIndex(studentArray, index);
        }

        return studentArray ;
    }

}