package day06;

//2. 가장 앞에 있던 값을 지우고 그 다음 인덱스부터는 하나씩 당겨서 가장 뒷칸에 넣는 방법

// 만약 모든 칸이 다 차있을 경우,

// 0번 칸에 1번
// 1번 칸에 2번
// 2번 칸에 3번
// 이렇게 한 칸씩 당기고 3번 칸에 새로운 학생의 정보를 입력하도록 만들어보자

import java.util.Scanner;

import util.ScannerUtil;

public class Ex08StaticArray02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] studentArray = new Student[4];

        while (true) {
            System.out.println("(1)입력 (2)출력 (3)종료");
            int userChoice = ScannerUtil.nextInt(scanner, " > ", 1, 3);

            if (userChoice == 1) {
                int index = -1;
                for (int i = 0; i < studentArray.length; i++) {
                    if (studentArray[i] == null) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    // 빈칸이 존재하므로 해당 index칸에 학생 정보 입력
                    studentArray[index] = new Student();

                    System.out.print("번호: ");
                    studentArray[index].setId(scanner.nextInt());

                    System.out.print("이름: ");
                    studentArray[index].setName(ScannerUtil.nextLine(scanner));

                    studentArray[index].setKorean(ScannerUtil.nextInt(scanner, "국어: ", 0, 100));

                    studentArray[index].setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 0, 100));

                    studentArray[index].setMath(ScannerUtil.nextInt(scanner, "수학: ", 0, 100));

                } else {
                    // 모든 칸이 꽉 찼으므로 1칸씩 당겨주고 3번 칸에 새로운 학생 정보 입력
                    for (int i = 1; i < studentArray.length; i++) {
                        studentArray[i - 1] = studentArray[i];
                    }
                    index = 3;
                    studentArray[index] = new Student();
                    // 위의 for문에서 studentArray[i - 1] = studentArray[i]; 을 통해
                    // i-1번 칸에 i번째 칸의 "주소값"을 덮어씌웠다.
                    // 만약 위의 studentArray[index] = new Student(); 가 없다면 (= 초기화를 안한다면)
                    // 3번칸이 초기화되지 않은 것이므로 2,3번 칸 모두 똑같은 주소를 가리키고 있어서
                    // 3번칸을 "새로 입력"하는 것이 아니라 똑같은 위치의 정보를 "수정"하는 것이 되어서
                    // 2,3번 모두 같은 값이 출력되게 된다.
                    
                    System.out.print("번호: ");
                    studentArray[index].setId(scanner.nextInt());

                    System.out.print("이름: ");
                    studentArray[index].setName(ScannerUtil.nextLine(scanner));

                    studentArray[index].setKorean(ScannerUtil.nextInt(scanner, "국어: ", 0, 100));

                    studentArray[index].setEnglish(ScannerUtil.nextInt(scanner, "영어: ", 0, 100));

                    studentArray[index].setMath(ScannerUtil.nextInt(scanner, "수학: ", 0, 100));
                }

            } else if (userChoice == 2) {
                for (int i = 0; i < studentArray.length; i++) {
                    if (studentArray[i] != null) {
                        System.out.printf("번호: %d, 이름: %s\n", studentArray[i].getId(), studentArray[i].getName());
                        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", studentArray[i].getKorean(),
                                studentArray[i].getEnglish(), studentArray[i].getMath());

                        int sum = studentArray[i].getKorean() + studentArray[i].getEnglish() + studentArray[i].getMath();
                        double ave = sum / 3.0;
                        System.out.printf("총점: %d점, 평균: %.2f점\n", sum, ave);
                        System.out.println();
                    }
                }

            } else if (userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }

        scanner.close();
    }
}
