public class Book {
    // 필드 (멤버 변수)
    private String title;
    private String author;
    private int pages;
    private double price;
    
    // 기본 생성자
    public Book() {
        this.title = "제목 없음";
        this.author = "저자 미상";
        this.pages = 0;
        this.price = 0.0;
    }
    
    // 매개변수가 있는 생성자
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }
    
    // Getter 메소드들
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPages() {
        return pages;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setter 메소드들
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setPages(int pages) {
        if (pages >= 0) {
            this.pages = pages;
        }
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
    
    // 책 정보를 출력하는 메소드
    public void displayInfo() {
        System.out.println("=== 책 정보 ===");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("페이지 수: " + pages + "페이지");
        System.out.println("가격: " + price + "원");
        System.out.println();
    }
    
    // 할인된 가격을 계산하는 메소드
    public double getDiscountedPrice(double discountRate) {
        if (discountRate >= 0 && discountRate <= 100) {
            return price * (100 - discountRate) / 100;
        }
        return price;
    }
    
    // 책의 두께를 판단하는 메소드
    public String getBookThickness() {
        if (pages < 100) {
            return "얇은 책";
        } else if (pages < 300) {
            return "보통 책";
        } else {
            return "두꺼운 책";
        }
    }
    
    // main() 함수 - 프로그램 실행 진입점
    public static void main(String[] args) {
        System.out.println("=== Book 클래스 테스트 ===\n");
        
        // 1. 기본 생성자로 객체 생성
        Book book1 = new Book();
        System.out.println("1. 기본 생성자로 생성된 책:");
        book1.displayInfo();
        
        // 2. 매개변수 생성자로 객체 생성
        Book book2 = new Book("자바의 정석", "남궁성", 1000, 35000);
        System.out.println("2. 매개변수 생성자로 생성된 책:");
        book2.displayInfo();
        
        // 3. Setter 메소드를 사용하여 book1 정보 수정
        book1.setTitle("스프링 부트 입문");
        book1.setAuthor("김영한");
        book1.setPages(450);
        book1.setPrice(28000);
        
        System.out.println("3. Setter로 정보를 수정한 book1:");
        book1.displayInfo();
        
        // 4. Getter 메소드 사용 예제
        System.out.println("4. Getter 메소드 사용:");
        System.out.println("book2의 제목: " + book2.getTitle());
        System.out.println("book2의 저자: " + book2.getAuthor());
        System.out.println("book2의 페이지 수: " + book2.getPages());
        System.out.println("book2의 가격: " + book2.getPrice() + "원\n");
        
        // 5. 할인 가격 계산 메소드 사용
        System.out.println("5. 할인 가격 계산:");
        double discountedPrice1 = book1.getDiscountedPrice(10); // 10% 할인
        double discountedPrice2 = book2.getDiscountedPrice(20); // 20% 할인
        
        System.out.println(book1.getTitle() + " 10% 할인가: " + discountedPrice1 + "원");
        System.out.println(book2.getTitle() + " 20% 할인가: " + discountedPrice2 + "원\n");
        
        // 6. 책 두께 판단 메소드 사용
        System.out.println("6. 책 두께 판단:");
        System.out.println(book1.getTitle() + "은(는) " + book1.getBookThickness());
        System.out.println(book2.getTitle() + "은(는) " + book2.getBookThickness() + "\n");
        
        // 7. 여러 책 객체 배열로 관리
        System.out.println("7. 여러 책 객체 배열로 관리:");
        Book[] books = {
            new Book("파이썬 기초", "홍길동", 250, 22000),
            new Book("웹 개발 입문", "이순신", 380, 30000),
            new Book("데이터베이스", "김유신", 520, 40000)
        };
        
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + "번째 책:");
            books[i].displayInfo();
        }
        
        // 8. 향상된 for문 사용
        System.out.println("8. 모든 책의 할인가 (15% 할인):");
        for (Book book : books) {
            double discounted = book.getDiscountedPrice(15);
            System.out.println(book.getTitle() + ": " + discounted + "원");
        }
    }
}