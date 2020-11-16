package day08;
// 게시판 관리 프로그램

// 단, 메인 메소드는 여기가 아닌 BoardEx 라는 곳에 만들고,
// 여기에는 게시판 관리 프로그램에서 필요한 메소드들을 모두 모아놓고
// showMenu()가 호출되면 메소드들도 호출돼서
// 우리가 BoardEx의 메인에서는
// BoardViewer viewer = new BoardViewer();
// viewer.showMenu();
// 만 실행시켜도 되게 만들어보자.

import java.util.Scanner;

import day07.Board;
import util.BoardUtil;
import util.ScannerUtil;

public class BoardViewer {
    private Scanner scanner;
    private Board[] boardArray;

    public BoardViewer() {
        scanner = new Scanner(System.in);
        boardArray = new Board[0];
    }

    // 메뉴를 보여주는 showMenu 메소드
    public void showMenu() {
        while (true) {
            System.out.println("게시판 관리 프로그램");
            String message = "(1)새글쓰기 (2)목록보기 (3)종료 \n > ";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                // 새글을 쓰는 메소드 호출
                addBoard();

            } else if (userChoice == 2) {
                // 목록을 보는 메소드 호출
                printList();

            } else if (userChoice == 3) {
                System.out.println("게시판 관리 프로그램을 종료합니다.");
                break;
            }
        }

    }

    // 사용자가 게시글을 입력하고, 해당 글을 배열에 추가해주는 addBoard 메소드
    // 이제는 우리가 어떤 메소드를 사용할 때, 반드시 해당 클래스의 객체를 만들어서 사용하기 때문에
    // 더이상 static 키워드는 붙이지 않는다.
    private void addBoard() {
        // 정보를 담을 Board 객체를 하나 만들어 준다.
        Board b = new Board();

        System.out.print("제목: ");
        b.setTitle(ScannerUtil.nextLine(scanner));

        System.out.print("번호: ");
        b.setNo(scanner.nextInt());

        System.out.print("작성자: ");
        b.setWriter(ScannerUtil.nextLine(scanner));

        System.out.print("내용: ");
        b.setBody(ScannerUtil.nextLine(scanner));

        boardArray = BoardUtil.add(boardArray, b);
    }

    // 글의 목록을 출력하는 printList() 메소드
    private void printList() {
        // 만약 작성된 게시글이 없을 경우에는 메시지를 출력하고, 있을 때에만 목록을 출력해준다.
        if (boardArray.length == 0) {
            System.out.println("아직 작성된 게시글이 없습니다. 첫 글을 작성해보세요!");
        } else {
            for (int i = 0; i < boardArray.length; i++) {
                System.out.printf("%d. %s\n", i+1, boardArray[i].getTitle());
            }
            
            // 사용자로부터 뒤로가기를 할지, 글을 선택해 상세보기를 할지 입력받는다.
            String message = "상세보기할 글 번호를 입력해주세요(0은 뒤로가기) \n > ";
            int userChoice = ScannerUtil.nextInt(scanner, message, 0, boardArray.length) -1 ;

            if (userChoice != -1) {
                // 사용자가 선택한 글을 보는 메소드 호출
                selectOne(userChoice);
               
            }
        }
    }

    // 사용자가 선택한 번호의 글을 출력하고 수정, 삭제, 뒤로가기 등의 메시지를 호출할 selectOne() 메소드
    private void selectOne(int index) {
        // 출력을 할 수 있게 임시로 Board 객체를 만들어 boardArray[index]로 초기화해주자
        Board b = boardArray[index];
        System.out.println("---------------------------------");
        System.out.println("제목: " + b.getTitle());
        System.out.println("글번호: " + b.getNo());
        System.out.println("작성자: " + b.getWriter());
        System.out.println("---------------------------------");
        System.out.println(b.getBody());
        System.out.println();

        // 사용자로부터 선택을 받아 수정, 삭제, 뒤로가기 중 하나를 실행한다.
        String message = "--------------------------------- \n(1)수정 (2)삭제 (3)뒤로가기 \n >";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        if (userChoice == 1) {
            // 수정하는 메소드 호출
            updateBoard(index);
            // 수정 완료 후에는 해당글 상세보기를 다시 출력한다.
            selectOne(index);

        } else if (userChoice == 2) {
            // 삭제하는 메소드 호출
            deleteBoard(index);
            // 삭제 후에는 글목록 보기
            printList();
            
        } else if (userChoice == 3) {
            // 목록보는 메소드 호출
            printList();

        }

    }

    // 글 수정하는 updateBoard 메소드
    private void updateBoard(int index) {
        System.out.print("제목: ");
        boardArray[index].setTitle(ScannerUtil.nextLine(scanner));

        System.out.print("내용: ");
        boardArray[index].setBody(ScannerUtil.nextLine(scanner));
    }

    private void deleteBoard(int index) {
        System.out.println("정말 삭제하시겠습니까?");
        int agree = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오 \n > ", 1, 1);
        
        if(agree == 1) {
            boardArray = BoardUtil.removeByIndex(boardArray, index);
        }
    }
}
