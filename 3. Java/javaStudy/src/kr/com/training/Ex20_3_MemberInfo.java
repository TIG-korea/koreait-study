package kr.com.training;

public class Ex20_3_MemberInfo {
	
	//private 변수 name,age,addr,isStudent를 가집니다.
	//isStudent 는 boolean,
	// getter / setter 
	private String name;
	private int age;
	private String addr;
	private boolean IsStudent;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setIsStudent(boolean isStudent) {
		this.IsStudent = isStudent;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
	public boolean getIsStudent() {
		return IsStudent;
	}
	
	

}
