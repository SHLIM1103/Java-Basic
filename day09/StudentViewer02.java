package day09;
// 학생관리 프로그램을 ArrayList를 사용하여 작성하시오

import java.util.ArrayList;
import java.util.Scanner;

import day06.Student;
import util.ScannerUtil;

// 배열대신 ArrayList를 사용한 성적관리 프로그램
public class StudentViewer02 {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> list;
    private int id = 1;

    // 생성자
    public StudentViewer02() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
    }

    // 메뉴출력을 담당하는 showMenu()
    public void showMenu() {
        while (true) {
            System.out.println("============성적관리 프로그램===========");
            int userChoice = ScannerUtil.nextInt(scanner, "(1)성적 입력하기 (2)학생목록 보기 (3)종료하기\n > ", 1, 3);

            if (userChoice == 1) {
                addStudent();

            } else if (userChoice == 2) {
                printAll();

            } else if (userChoice == 3) {
                System.out.println("성적관리 프로그램을 종료합니다.");
                break;
            }
        }
    }

    // 성적입력하는 addStudent()
    private void addStudent() {
        Student s = new Student();

        s.setId(id++);

        System.out.print("이름: ");
        s.setName(ScannerUtil.nextLine(scanner));

        s.setKorean(ScannerUtil.nextInt(scanner, "국어 점수: ", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scanner, "영어 점수: ", 0, 100));
        s.setMath(ScannerUtil.nextInt(scanner, "수학 점수: ", 0, 100));

        list.add(s);
    }

    // 학생목록 보는 printAll()
    private void printAll() {
        System.out.println("===================================");
        if (list.isEmpty()) {
            System.out.println("아직 입력된 성적이 없습니다.");
        } else {
            for (int i = 0; i <= list.size() - 1; i++) {
                System.out.printf("%d번 %s\n", i + 1, list.get(i).getName());
            }
            System.out.println("===================================");
            int userChoice = ScannerUtil.nextInt(scanner, "성적을 출력할 학생의 번호를 입력하세요(0은 뒤로가기) \n > ", 0, list.size()) - 1;
            if (userChoice != -1) {
                printOne(userChoice);
            }
        }
    }

    // 선택한 학생 성적출력 printOne
    private void printOne(int index) {
        Student s = list.get(index);
        System.out.println("===================================");
        s.printInfo();
        System.out.println("===================================");

        int userChoice = ScannerUtil.nextInt(scanner, "(1)수정 (2)삭제 (3)학생목록 보기 \n > ", 1, 3);
        if (userChoice == 1) {
            updateScore(index);

        } else if (userChoice == 2) {
            deleteScore(index);
            printAll();

        } else if (userChoice == 3) {
            printAll();
        }
    }

    // 성적수정 updateScore()
    private void updateScore(int index) {
        list.get(index).setKorean(ScannerUtil.nextInt(scanner, "국어 점수: ", 0, 100));
        list.get(index).setEnglish(ScannerUtil.nextInt(scanner, "영어 점수: ", 0, 100));
        list.get(index).setMath(ScannerUtil.nextInt(scanner, "수학 점수: ", 0, 100));

        printOne(index);
    }

    // 성적삭제 deleteScore()
    private void deleteScore(int index) {
        System.out.println("정말 삭제하시겠습니까?");
        int userChoice = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오\n > ", 1, 2);

        if (userChoice == 1) {
            list.remove(index);

        }
    }

}
