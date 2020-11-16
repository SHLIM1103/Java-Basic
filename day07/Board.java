package day07;

import java.util.Calendar;

//게시판관리 프로그램을 만들어라

//게시판에는 글번호, 제목, 내용, 작성자 4가지 정보가 필요하며
//글쓰기, 목록보기, 개별보기, 수정하기, 삭제하기 기능이 필요하다.

public class Board {
    private int no;
    private String title;
    private String body;
    private String writer; // 얘네가 필드가 됨

    private Calendar writtenDate;
    private Calendar updateDate;
    
    // 위 필드를 모두 private으로 바꿔서 캡슐화 진행
    // toString과 equals 메소드를 오버라이드하라

    // getter setter 이클립스 사용해서 자동으로 만들기
    // 소스 빈창에 마우스 오른쪽 클릭 -> source -> generate getters/setters 클릭
    // 단, 기존의 getter setter가 있는 경우 해당 필드에 대한 getter setter는 나오지 않는다.

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Calendar getWrittenDate() {
        return writtenDate;
    }
    
    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }
    
    public Calendar getUpdateDate() {
        return updateDate;
    }
    
    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    
    // toString 구현
    public String toString() {
        // 객체의 필드값을 출력하는 방법은 다양하다.
        return "no" + no
                + ", title" + title
                + ", body" + body
                + ", writer" + writer;
    }

    public boolean equals(Object o) {
        if (o instanceof Board) {
            Board b = (Board) o;
            if (no == b.no && title.equals(b.title)) {
                return true;
            }
        }
        return false;
    }

}