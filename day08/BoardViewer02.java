package day08;
// 우리가 게시판에 글을 쓸때는 글 번호가 자동으로 부여된다.

// 또한 우리가 글 10개를 쓰고, 도중에 하나를 지우더라도
// 새 글을 쓰면 글 번호는 11부터 부여된다.

// 데이터베이스가 있을 경우에 이렇게 글번호/학생번호
// 즉 고유 식별번호(=id)를 자동으로 관리해주지만,
// 우리는 데이터베이스가 없으므로
// 전역 변수를 사용하여 id를 클래스가 알아서 부여해주도록 만들자

import java.util.Scanner;

import day07.Board;
import util.BoardUtil;
import util.ScannerUtil;

public class BoardViewer02 {
    private Scanner scanner;
    private Board[] boardArray;
    // 글 번호를 보관할 전역 변수 no
    private int no = 1 ;

    // 생성자
    public BoardViewer02() {
        scanner = new Scanner(System.in);
        boardArray = new Board[0];
    }

    public void showMenu() {
        while (true) {
            System.out.println("게시판 관리 프로그램");
            String message = "(1)새글쓰기 (2)목록보기 (3)종료 \n > ";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                addBoard();

            } else if (userChoice == 2) {
                printList();

            } else if (userChoice == 3) {
                System.out.println("게시판 관리 프로그램을 종료합니다.");
                break;
            }
        }
    }

    private void addBoard() {
        // 정보를 담을 Board 객체를 하나 만들어 준다.
        Board b = new Board();

        b.setNo(no++);
        
        System.out.print("제목: ");
        b.setTitle(ScannerUtil.nextLine(scanner));

        System.out.print("작성자: ");
        b.setWriter(ScannerUtil.nextLine(scanner));

        System.out.print("내용: ");
        b.setBody(ScannerUtil.nextLine(scanner));

        boardArray = BoardUtil.add(boardArray, b);
    }

    private void printList() {
        if (boardArray.length == 0) {
            System.out.println("아직 작성된 게시글이 없습니다. 첫 글을 작성해보세요!");
        } else {
            for (int i = 0; i < boardArray.length; i++) {
                System.out.printf("%d. %s\n", i + 1, boardArray[i].getTitle());
            }

            String message = "상세보기할 글 번호를 입력해주세요(0은 뒤로가기) \n > ";
            int userChoice = ScannerUtil.nextInt(scanner, message, 0, boardArray.length) - 1;

            if (userChoice != -1) {
                selectOne(userChoice);
            }
        }
    }

    private void selectOne(int index) {
        Board b = boardArray[index];
        System.out.println("---------------------------------");
        System.out.println("제목: " + b.getTitle());
        System.out.println("글번호: " + b.getNo());
        System.out.println("작성자: " + b.getWriter());
        System.out.println("---------------------------------");
        System.out.println(b.getBody());
        System.out.println();

        String message = "--------------------------------- \n(1)수정 (2)삭제 (3)뒤로가기 \n >";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        if (userChoice == 1) {
            updateBoard(index);
            selectOne(index);
        } else if (userChoice == 2) {
            deleteBoard(index);
            printList();
        } else if (userChoice == 3) {
            printList();

        }

    }

    private void updateBoard(int index) {
        System.out.print("제목: ");
        boardArray[index].setTitle(ScannerUtil.nextLine(scanner));

        System.out.print("내용: ");
        boardArray[index].setBody(ScannerUtil.nextLine(scanner));
    }

    private void deleteBoard(int index) {
        System.out.println("정말 삭제하시겠습니까?");
        int agree = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오 \n > ", 1, 1);

        if (agree == 1) {
            boardArray = BoardUtil.removeByIndex(boardArray, index);
        }
    }
}
