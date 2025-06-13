// 1. 클래스 정의 - 학생 클래스
class Student {
    // 속성(변수) - 학생의 특징들
    private String name;        // 이름
    private int age;           // 나이
    private String grade;      // 학년
    private int score;         // 점수
    
    // 생성자 - 학생 객체를 만들 때 사용
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.score = 0;
    }
    
    // 메소드(행동) - 학생이 할 수 있는 일들
    
    // 공부하기
    public void study(String subject) {
        System.out.println(name + "이(가) " + subject + "을(를) 공부하고 있습니다.");
        score += 10; // 공부하면 점수 증가
    }
    
    // 점수 확인하기
    public void checkScore() {
        System.out.println(name + "의 현재 점수: " + score + "점");
    }
    
    // 자기소개하기
    public void introduce() {
        System.out.println("안녕하세요! 저는 " + name + "입니다.");
        System.out.println("나이: " + age + "세, 학년: " + grade);
    }
    
    // 점수 얻기 (getter)
    public int getScore() {
        return score;
    }
    
    // 이름 얻기 (getter)
    public String getName() {
        return name;
    }
}

// 2. 상속 - 고등학생 클래스 (학생 클래스를 상속받음)
class HighSchoolStudent extends Student {
    private String club; // 동아리
    
    // 생성자
    public HighSchoolStudent(String name, int age, String grade, String club) {
        super(name, age, grade); // 부모 클래스의 생성자 호출
        this.club = club;
    }
    
    // 메소드 오버라이딩 - 부모의 메소드를 다시 정의
    @Override
    public void introduce() {
        super.introduce(); // 부모의 introduce() 호출
        System.out.println("동아리: " + club);
    }
    
    // 새로운 메소드 추가
    public void joinClubActivity() {
        System.out.println(getName() + "이(가) " + club + " 동아리 활동에 참여합니다!");
    }
}

// 3. 메인 클래스 - 프로그램 실행
public class OOP {
    public static void main(String[] args) {
        System.out.println("=== 객체지향 프로그래밍 예제 ===\n");
        
        // 1. 객체 생성 (인스턴스화)
        Student student1 = new Student("김민수", 14, "중학교 2학년");
        Student student2 = new Student("이영희", 15, "중학교 3학년");
        HighSchoolStudent student3 = new HighSchoolStudent("박철수", 17, "고등학교 2학년", "축구부");
        
        System.out.println("1. 캡슐화 - 객체의 속성과 메소드를 하나로 묶기");
        System.out.println("----------------------------------------");
        
        // 2. 캡슐화 - 객체의 데이터와 메소드를 하나로 묶음
        student1.introduce();
        student1.study("수학");
        student1.checkScore();
        System.out.println();
        
        student2.introduce();
        student2.study("영어");
        student2.study("과학");
        student2.checkScore();
        System.out.println();
        
        System.out.println("2. 상속 - 부모 클래스의 특성을 물려받기");
        System.out.println("----------------------------------------");
        
        // 3. 상속 - HighSchoolStudent가 Student를 상속받음
        student3.introduce(); // 오버라이딩된 메소드 호출
        student3.study("물리"); // 부모 클래스의 메소드 사용
        student3.joinClubActivity(); // 자식 클래스의 새로운 메소드
        student3.checkScore();
        System.out.println();
        
        System.out.println("3. 다형성 - 같은 메소드가 다르게 동작하기");
        System.out.println("----------------------------------------");
        
        // 4. 다형성 - 같은 타입의 참조변수로 다른 객체들을 다룸
        Student[] students = {student1, student2, student3};
        
        for (Student s : students) {
            s.introduce(); // 각각 다르게 동작 (다형성)
            System.out.println();
        }
        
        System.out.println("4. 추상화 - 공통된 특성을 뽑아내기");
        System.out.println("----------------------------------------");
        
        // 5. 추상화 - 모든 학생은 공부할 수 있다는 공통 특성
        System.out.println("모든 학생들이 공부합니다:");
        for (Student s : students) {
            s.study("국어");
        }
        
        System.out.println("\n최종 점수 현황:");
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getScore() + "점");
        }
        
        System.out.println("\n=== 객체지향의 4가지 특징을 모두 확인했습니다! ===");
        System.out.println("1. 캡슐화: 데이터와 메소드를 하나로 묶음");
        System.out.println("2. 상속: 부모 클래스의 특성을 자식이 물려받음");
        System.out.println("3. 다형성: 같은 메소드가 객체에 따라 다르게 동작");
        System.out.println("4. 추상화: 공통된 특성을 뽑아내어 클래스로 정의");
    }
}
