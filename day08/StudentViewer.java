package day08;
// 학생뷰어를 필드안의 스캐너와 배열을 활용하여 StudentViewer 만들어보자

import java.util.Scanner;

import day06.Student;
import util.ArrayUtil;
import util.ScannerUtil;

public class StudentViewer {
    // 입력을 담당할 Scanner 필드
    private Scanner scanner;
    // 학생목록을 저장하고 관리할 Student 배열
    private Student[] studentArray;

    // 생성자를 사용하여 필드를 초기화
    public StudentViewer() {
        scanner = new Scanner(System.in);
        studentArray = new Student[0];
    }

    // 메뉴를 출력하는 showMenu 메소드
    public void showMenu() {
        while (true) {
            System.out.println("=====================================================");
            System.out.println("※비트고등학교 성적관리 프로그램※");
            int userChoice = ScannerUtil.nextInt(scanner, "(1)성적 입력하기 (2)성적 확인하기 (3)종료하기 \n > ", 1, 3);
            System.out.println("=====================================================");

            if (userChoice == 1) {
                // 학생 정보와 성적 입력하는 메소드 호출
                addStudent();

            } else if (userChoice == 2) {
                // 학생 리스트를 불러오는 메소드 호출
                printList();

            } else if (userChoice == 3) {
                // 프로그램 종료
                System.out.println("성적관리 프로그램을 종료합니다");
                break;
            }
        }
    }

    // 학생 정보와 성적을 입력하는 addStudent 메소드
    private void addStudent() {
        Student s = new Student();

        System.out.print("번호: ");
        s.setId(scanner.nextInt());

        System.out.print("이름: ");
        s.setName(ScannerUtil.nextLine(scanner));

        s.setKorean(ScannerUtil.nextInt(scanner, "국어 점수: ", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scanner, "영어 점수: ", 0, 100));
        s.setMath(ScannerUtil.nextInt(scanner, "수학 점수: ", 0, 100));

        studentArray = ArrayUtil.add(studentArray, s);
    }

    // 학생 리스트를 불러오는 printList 메소드
    private void printList() {
        if (studentArray.length == 0) {
            System.out.println("아직 입력된 성적이 없습니다.");
        } else {
            for (int i = 0; i < studentArray.length; i++) {
                System.out.printf("(no. %d) %02d %s\n", i + 1, studentArray[i].getId(), studentArray[i].getName());
            }
            System.out.println("-----------------------------------------------------");

            // 사용자로부터 뒤로가기를 할지, 상세 성적보기를 할지 입력받는다
            int userChoice = ScannerUtil.nextInt(scanner, "조회할 학생의 순번을 입력해주세요(뒤로가기는 0): \n > ", 0, studentArray.length) - 1;

            if (userChoice != -1) {
                // 상세 성적보는 메소드 호출
                selectOne(userChoice);
            }
        }

    }

    // 상세 성적보는 메소드 selectOne()
    private void selectOne(int i) {

        Student s = studentArray[i];
        System.out.println("=====================================================");
        System.out.printf("%02d번 %s 학생의 성적보기\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        System.out.printf("총점: %03d점 평균: %.2f점\n", s.calculateSum(), s.calculateAve());
        System.out.println("=====================================================");

        // 사용자로부터 선택을 받아, 수정/삭제/뒤로가기 중 하나를 실행한다
        int userChoice = ScannerUtil.nextInt(scanner, "(1)성적 수정하기 (2)삭제하기 (3)학생목록으로 돌아가기\n > ", 1, 3);
        System.out.println("=====================================================");
        if (userChoice == 1) {
            // 성적 수정하는 메소드 호출
            update(i);

            // 수정후 다시 글보기 메소드 호출
            selectOne(i);

        } else if (userChoice == 2) {
            // 성적 삭제하는 메소드 호출
            delete(i);
            // 삭제후 목록보는 메소드 호출
            printList();

        } else if (userChoice == 3) {
            // 목록보는 메소드 호출
            printList();
            
        }
    }

    // 성적 수정하는 메소드 update()
    private void update(int index) {
        Student s = studentArray[index];
        System.out.printf("%s 학생의 성적을 수정하는 페이지입니다.\n", s.getName());

        studentArray[index].setKorean(ScannerUtil.nextInt(scanner, "수정할 국어 성적을 입력해 주세요: ", 0, 100));
        studentArray[index].setEnglish(ScannerUtil.nextInt(scanner, "수정할 영어 성적을 입력해 주세요: ", 0, 100));
        studentArray[index].setMath(ScannerUtil.nextInt(scanner, "수정할 수학 성적을 입력해 주세요: ", 0, 100));
    }

    // 성적 삭제하는 메소드 delete()
    private void delete(int index) {
        System.out.print("정말 삭제하시겠습니까?");
        int agree = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오", 1, 2);

        if (agree == 1) {
            studentArray = ArrayUtil.removeByIndex(studentArray, index);
        }
    }
}