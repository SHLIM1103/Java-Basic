package day06;
// 구조체(Struct)

// 구조체란, 다양한 데이터타입을 우리가 필요한 하나의 커다란 데이터타입으로 만들어주는 것이다.

// 예) 학생이라는 구조체는, 그 안에 번호/이름/국영수 점수 등이 들어갈 수 있고
//    자동차라는 구조체는, 그 안에 번호판/차종/연식 등의 정보를 모아서 자동차 라는 자료형을 만들어 줄 수 있다.

// 단, 구조체는 2세대 언어까지에서만 사용되었다는 문제점이 있다.
// 하지만 자바에서도 구조체를 비슷하게 만들어줄 수 있다.

public class Ex03Struct {
    public static void main(String[] args) {
        // 우리가 미리 만들어놓은 Student 클래스는 하나의 자료형이 될 수 있다.
        // 그리고 그 안에 어떠한 데이터들을 가질지를 미리 규정시켜 놓으면,
        // Student 클래스 변수를 만들어서 그 안에 각기 다른 데이터들을 넣어줄 수 있다.
        // 즉, id, korean, english, math, name을 통째로 묶어서 하나의 Student 라는 데이터타입을 만들어주게 된 것이다.

        Student s = new Student(); // s의 데이터타입은 Student가 된다.
        s.setId(1);
        s.setKorean(100);
        s.setEnglish(95);
        s.setMath(85);
        s.setName("임소현");

        Student s2 = new Student();
        s2.setId(2);
        s2.setKorean(99);
        s2.setEnglish(94);
        s2.setMath(84);
        s2.setName("임소현2");

        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어점수: %03d점 영어점수: %03d점 수학점수: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        System.out.println("---------------------------------------");
        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어점수: %03d점 영어점수: %03d점 수학점수: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());

    }
}
