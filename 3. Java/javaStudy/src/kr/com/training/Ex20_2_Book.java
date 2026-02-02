package kr.com.training;

public class Ex20_2_Book {
	
	// 책 빌리는 메서드 (borrowBook)
	// - 매개변수는1은 자료형 : Ex20_2_BookInfo
	// - 매개변수 2는 자료형 : int
	//  	> 빌릴 책의 수 
	//	- Ex20_2_BookInfo의 bookCount 값을 빌릴 책의 수 만큼 뺍니다.
	// 	- "책을 0권 빌렸습니다." 출력 
	public void borrowBook(Ex20_2_Bookinfo bookInfo, int borrowCount) {
		int currentBook = bookInfo.getBookCount();
		
		bookInfo.setBookCount(currentBook - borrowCount);
		
		System.out.println("책이 " + bookInfo.getBookCount() + "권 남았습니다");
	}
	
	
	// 책을 반납하는 메서드 (returnBook)
	// - 매개변수 1은 자료형 : Ex20_2_BookInfo
	// - 매개변수 2는 자료형 : int
	//		> 반납할 책의 수
	//	-Ex20_2_BookInfo의 bookCount 값을 반납할 책의 수 만큼 더합니다.
	// 	- " 책을 0권 반납했습니다. " 출력
	
	public void returnBook(Ex20_2_Bookinfo bookInfo, int returnCount) {
		int currentBook = bookInfo.getBookCount(); // 현재 책의 수 
		
		bookInfo.setBookCount(currentBook + returnCount);
		
		System.out.println("책이 " + bookInfo.getBookCount() + "권 남았습니다");
		
		
	}
	
	
	
	// 현재 도서관에 남은 책의 수를 출력하는 메서드 (showBoockCount)
	// - 매개변수 1은 자료형 : Ex20_2_BookInfo
	// - 현재 남은 책의 수는 Ex20_2_BookInfo의 bookCount 입니다.
	// - "현재 도서관에는 0권의 책이 있습니다." 출력 
	
	public void showBookCount(Ex20_2_Bookinfo bookInfo) {
		System.out.println("현재 도서관에는 " + bookInfo.getBookCount() + "권 만큼 책이 남아있습니다");
	}
	
	
	
	
	
	
	
	
	
	

}
