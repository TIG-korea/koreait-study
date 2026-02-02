package kr.com.training;

public class Ex20_Main {

	public static void main(String[] args) {
		
		
		// getter / setter를 사용하는 경우
		// - 객체 생성 후에도 자유롭게 데이터 변경 가능
		// - 필요한 필드만 setter 값을 넣을 수 있음
		// 		> 초기값 이후 값을 변경할 필요가 없다면 setter 안만들면 됨 
		Ex20_1_Animal dog = new Ex20_1_Animal(); // 기본 생성자 호출
		dog.setName("흰둥이");
		dog.setAge(1);
		dog.eat();        // 출력 
		
		
		// 생성자로만 필드를 초기화 하는 경우
		// - 데이터가 불변 (객체 생성 후 값이 변하지 않음)
		Ex20_1_Animal cat = new Ex20_1_Animal("나비",3);
		cat.eat();
	
	
		System.out.println(dog.getAge());
		System.out.println(cat.getName());
		
		
		Ex20_2_Bookinfo bookInfo = new Ex20_2_Bookinfo(); // 도서관 정보 객체
		bookInfo.setBookCount(100); // 초기에 100권이 있다
		
		Ex20_2_Book book = new Ex20_2_Book(); // 도서관 객체 
		
		//				도서관 정보, 빌릴 책의 수
		book.borrowBook(bookInfo, 3);
		book.returnBook(bookInfo, 1);
		book.showBookCount(bookInfo);
		
		System.out.println("=============================");
		
		Ex20_3_MemberInfo memberInfo = new Ex20_3_MemberInfo();
		memberInfo.setName("짱구");
		memberInfo.setAge(5);
		memberInfo.setAddr("인천");
		memberInfo.setIsStudent(false);
		
		
		Ex20_3_Member member = new Ex20_3_Member();
		member.itroduce(memberInfo);
		
		
		Ex20_3_Member run = new Ex20_3_Member();
		run.run(memberInfo);
		

	}

	
}
