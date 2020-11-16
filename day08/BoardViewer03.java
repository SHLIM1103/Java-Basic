package day08;
// 글을 작성하거나 수정할 때 날짜가 자동으로 입력되는 버전


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import day07.Board;
import util.BoardUtil;
import util.ScannerUtil;

public class BoardViewer03 { 
    private Scanner scanner;
    private Board[] boardArray;
    private int no = 1 ;

    public BoardViewer03() {
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
        
        // 글 작성일과 수정일을 저장한다.
        b.setWrittenDate(Calendar.getInstance());
        b.setUpdateDate(Calendar.getInstance());
        
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
        SimpleDateFormat sdf = new SimpleDateFormat("yy년 M월 d일 H시 m분 s초");
        System.out.println("제목: " + b.getTitle());
        System.out.println("글번호: " + b.getNo());
        System.out.println("작성자: " + b.getWriter());
        System.out.println("작성일: " + sdf.format(b.getWrittenDate().getTime()));
        System.out.println("수정일: " + sdf.format(b.getUpdateDate().getTime()));
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
        boardArray[index].setUpdateDate(Calendar.getInstance());
    }

    private void deleteBoard(int index) {
        System.out.println("정말 삭제하시겠습니까?");
        int agree = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오 \n > ", 1, 2);

        if (agree == 1) {
            boardArray = BoardUtil.removeByIndex(boardArray, index);
        }
    }
}
