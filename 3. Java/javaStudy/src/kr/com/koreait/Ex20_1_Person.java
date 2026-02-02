package kr.com.koreait;

public class Ex20_1_Person {
	private int age;
	private String name;
	private String addr;
	private boolean isStudent;
	
	
	// Setter
	// - 반환 타입은 일반적으로 void
	// - 메서드명 : set필드명 
	public void setAge(int age) {
//		if(age < 0) {
//			return;
//		}
		this.age = age;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setIsStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	
	
	
	// Getter
	// - 메서드명 : get필드명
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public boolean getIsStudent() {
		return isStudent;
	}
	
	
	
	
	
}
