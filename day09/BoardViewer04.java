package day09;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import day07.Board;
import util.ScannerUtil;

// 배열 대신 ArrayList를 사용한
// 게시판 관리 프로그램
public class BoardViewer04 {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Board> list;
    private int no;

    // 생성자
    public BoardViewer04() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        no = 1;
    }

    // 메뉴 출력을 담당하는 showMenu() 메소드
    public void showMenu() {
        while (true) {
            System.out.println("게시판 관리 프로그램");
            String message = ("(1)새글 작성 (2)글 목록 보기 (3)종료하기\n>");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                addBoard();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    // 새글 작성 addBoard()
    private void addBoard() {
        Board b = new Board();

        b.setNo(no++);
        System.out.print("제목: ");
        b.setTitle(ScannerUtil.nextLine(scanner));
        System.out.print("작성자: ");
        b.setWriter(ScannerUtil.nextLine(scanner));
        System.out.print("내용: ");
        b.setBody(ScannerUtil.nextLine(scanner));

        b.setWrittenDate(Calendar.getInstance());
        b.setUpdateDate(Calendar.getInstance());

        list.add(b);
    }

    // 글목록 보기 printAll()
    private void printAll() {
        if (list.isEmpty()) {
            System.out.println("아직 작성된 글이 없습니다.");
        } else {
            // 향상된 for문, forEach 구조
            // 만약 우리가 배열, 어레이리스트 등의 집합의 요소를 하나씩 호출해야 하는 경우
            // 굳이 정식 for문을 적어주지 않고
            // "너희한테 하나씩 뽑아서 객체 a라고 부를게!" 라고 해줄 수 있다.
            // 이것을 forEach 구조 혹은 향상된 for문이라고 부른다.
            // 사용방법: ※ for(데이터타입 변수이름 : 리스트) ※
            // 0번부터 차례대로 변수이름이라는 임시변수로 만들어서 사용하는 것과 같다.

            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.printf("%d. %s\n", i + 1, list.get(i).getTitle());
            }

            String message = "상세보기할 글을 선택해주세요(0은 뒤로가기)\n>";
            int userChoice = ScannerUtil.nextInt(scanner, message, 0, list.size()) - 1;

            if (userChoice != -1) {
                printOne(userChoice);
            }
        }
    }

    // 글 읽기 printOne()
    private void printOne(int index) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        Board b = list.get(index);
        System.out.println("--------------------------");
        System.out.println("제목: " + b.getTitle());
        System.out.println("작성자: " + b.getWriter());
        System.out.println("작성날짜: " + sdf.format(b.getWrittenDate().getTime()));
        System.out.println("수정날짜: " + sdf.format(b.getUpdateDate().getTime()));
        System.out.println("--------------------------");
        System.out.println(b.getBody());
        System.out.println("--------------------------\n");

        String message = "(1)수정 (2)삭제 (3)목록으로 \n>";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if(userChoice == 1) {
            updateBoard(index);
            printOne(index);
            
        }else if(userChoice == 2) {
            deleteBoard(index);
            printAll();
        
        }else if(userChoice == 3) {
            printAll();
        }
    }

    // 글 수정 updateBoard()
    private void updateBoard(int index) {
        System.out.println("제목: ");
        list.get(index).setTitle(ScannerUtil.nextLine(scanner));
        
        System.out.println("내용: ");
        list.get(index).setBody(ScannerUtil.nextLine(scanner));
        
        list.get(index).setUpdateDate(Calendar.getInstance());
    }
    
    // 글 삭제 deleteBoard()
    private void deleteBoard(int index) {
        System.out.println("정말로 삭제하시겠습니까?");
        int agree = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오", 1, 2);
        if(agree == 1) {
            list.remove(index);
        }
    }
}
