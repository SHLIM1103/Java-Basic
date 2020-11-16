package day07;
// 게시판관리 프로그램을 만들어라

// 게시판에는 글번호, 제목, 내용, 작성자 4가지 정보가 필요하며
// 글쓰기, 목록보기, 개별보기, 수정하기, 삭제하기 기능이 필요하다.

import java.util.Scanner;

import util.BoardUtil;
import util.ScannerUtil;

public class Ex01Board {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 메뉴 보여주기
        showMenu(scanner);

        scanner.close();
    }

    // 입력하는 메뉴 생성하기
    private static void showMenu(Scanner scanner) {
        Board[] boardArray = new Board[0]; // 게시글을 관리하는 board배열 boardArray

        while (true) {
            System.out.println("================================================");
            System.out.println("                  게시판 관리 프로그램                ");
            System.out.println("            (1)글쓰기 (2)목록보기 (3)종료하기          ");
            System.out.println("================================================");

            int userChoice = ScannerUtil.nextInt(scanner, " > ", 1, 3);

            if (userChoice == 1) {
                // 게시글을 작성하고 배열에 담아서 return해주는 메소드를 실행해서
                // 그 결과값으로 boardArray를 덮어 씌운다.
                // (= 글 쓰는 메소드 호출)
                boardArray = insert(scanner, boardArray);

            } else if (userChoice == 2) {
                // 목록보기 후 글내용 보기를 들어가 글을 삭제 또는 수정할 수도 있으니, 그 배열을 return해주는 목록보기 메소드를 실행해
                // 그 결과 값으로 boardArray를 덮어 씌운다.
                // (= 목록보는 메소드 호출)
                boardArray = printList(scanner, boardArray);

            } else if (userChoice == 3) {
                System.out.println("게시판 관리 프로그램을 종료합니다! :D");
                break;
            }
        }
    }

    // 글 쓰는 메소드 생성하기 (파라미터로 받아온 배열에 새로운 글을 작성해서 담고 그대로 리턴해주는 addBoard()메소드)
    private static Board[] insert(Scanner scanner, Board[] boardArray) {
        // 게시글의 정보를 저장할 변수를 만들자
            Board b = new Board();

            // 게시판에 글을 차례로 넣어보자
            System.out.print("글 번호: ");
            b.setNo(scanner.nextInt());

            System.out.print("제목: ");
            b.setTitle(ScannerUtil.nextLine(scanner));
            
            System.out.print("내용: ");
            b.setBody(ScannerUtil.nextLine(scanner));

            System.out.print("작성자: ");
            b.setWriter(ScannerUtil.nextLine(scanner));

            // 정보가 추가된 b를 배열에 추가하자
            boardArray = BoardUtil.add(boardArray, b);

        return boardArray;
    }

    // 목록보는 메소드 생성하기
    private static Board[] printList(Scanner scanner, Board[] boardArray) {
        // 글 목록이 없으면 작성된 글이 없다만 출력
        if (boardArray.length == 0) {
            System.out.println("아직 작성된 글이 없습니다. 첫 글을 작성해보세요!");
        } else {
            // 글 목록에 간단하게 글번호, 제목, 작성자를 출력한다
            System.out.println("================================================");
            for (int i = 0; i < boardArray.length; i++) {
                System.out.printf("[No. %2d] %s (작성자: %s)\n", i + 1, boardArray[i].getTitle(), boardArray[i].getWriter());
            }
            System.out.println("================================================");
            int userChoice = ScannerUtil.nextInt(scanner, "글 번호를 입력하세요(뒤로가기는 0): ", 0, boardArray.length) - 1;

            if (userChoice != -1) {
                // 글 상세보기 메소드 호출
                boardArray = selectOne(scanner, boardArray, userChoice);
            }
        }

        return boardArray;
    }

    // 글 상세보기를 하고, 수정/삭제 시에는 관련 메소드를 호출하는 메소드 생성
    private static Board[] selectOne(Scanner scanner, Board[] boardArray, int index) {

        // 먼저, 파라미터로 넘어온 boardArray에서 index를 사용하여 사용자가 선택한 객체를 출력하자
        Board b = boardArray[index];
        System.out.printf("[No. %d] %s (작성자: %s)\n", b.getNo(), b.getTitle(), b.getWriter());
        System.out.println(b.getBody());
        System.out.println("----------------------------");

        int userChoice = ScannerUtil.nextInt(scanner, "(1)수정 (2)삭제 (3)목록보기 : ", 1, 3);
        
        if (userChoice == 1) {
            // 수정하는 메소드 호출
            update(scanner, b);
            // 수정이 완료되면 다시 글 상세보기로 돌아가게 만들자
            boardArray = selectOne(scanner, boardArray, index);

        } else if (userChoice == 2) {
            // 삭제하는 메소드 호출
            boardArray = delete(scanner, boardArray, index);
            // 삭제 후에는 목록보기로 돌아가자
            boardArray = printList(scanner, boardArray);
        
        }else if(userChoice == 3) {
            // 목록보기 메소드 호출
            boardArray = printList(scanner, boardArray);
        }

        return boardArray;
    }

    // 수정하는 메소드 생성
    private static void update(Scanner scanner, Board b) {
        System.out.println("================================================");
        System.out.println("                    작성글 수정                    ");
        System.out.println("================================================");
        System.out.println("No." + b.getNo());
        System.out.println("작성자: " + b.getWriter());

        System.out.print("수정할 제목을 입력하세요.");
        b.setTitle(ScannerUtil.nextLine(scanner));
        System.out.print("수정할 내용을 입력하세요.");
        b.setBody(ScannerUtil.nextLine(scanner));
        System.out.println("================================================");
    }

    // 삭제하는 메소드 생성
    private static Board[] delete(Scanner scanner, Board[] boardArray, int index) {
        System.out.println("해당 글을 정말 삭제하시겠습니까?");
        int agree = ScannerUtil.nextInt(scanner, "(1)예 (2)아니오", 1, 2);
        if (agree == 1) {
            // 1을 누르면 삭제, 그외에는 그냥 무시
            boardArray = BoardUtil.removeByIndex(boardArray, index);
        }

        return boardArray;
    }

}
