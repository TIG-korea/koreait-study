package kr.com.koreait;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.sqlite.SQLiteException;

public class Ex30_Main {
	private static final String DB_PATH = "app.db";

	public static void main(String[] args) {
		Ex30_1_UserDao dao = new Ex30_1_UserDao(DB_PATH);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n=== SQLite CRUD ===");
			System.out.println("(1) 유저 추가");
			System.out.println("(2) 전체 유저 조회");
			System.out.println("(3) 특정 유저 조회");
			System.out.println("(4) 유저 수정");
			System.out.println("(5) 유저 삭제");
			System.out.println("(0) 종료");
			System.out.print("번호 선택: ");
			String in = sc.nextLine().trim();

			try {
				switch (in) {
				case "1" -> create(sc, dao);
				case "2" -> list(dao);
				case "3" -> find(sc, dao);
				case "4" -> update(sc, dao);
				case "5" -> delete(sc, dao);
				case "0" -> {
					System.out.println("프로그램이 종료되었습니다.");
					return;
				}
				default -> System.out.println("올바른 번호를 입력하세요.");
				}
			} catch (SQLiteException e) {
				if (e.getMessage() != null && e.getMessage().contains("UNIQUE")) {
					System.out.println("[에러] 이메일이 중복됩니다. 다른 값을 사용하세요.");
				} else {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void create(Scanner sc, Ex30_1_UserDao dao) throws SQLException {
		System.out.println("이름 : ");
		String name = sc.nextLine();

		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("이메일(중복 불가) : ");
		String email = sc.nextLine();

		dao.insert(new Ex30_1_User(name, age, email));
		System.out.println("사용자 추가 완료!");

	}

	public static void list(Ex30_1_UserDao dao) throws SQLException {
		List<Ex30_1_User> list = dao.findAll();

		for (Ex30_1_User user : list) {
			System.out.println("아이디 :" + user.getId());
			System.out.println("이름 :" + user.getName());
			System.out.println("나이 :" + user.getAge());
			System.out.println("이메일 :" + user.getEmail());
			System.out.println("-------------------------");
		}
	}

	public static void find(Scanner sc, Ex30_1_UserDao dao) throws SQLException {
		System.out.println("검색할 아이디 :");
		int id = sc.nextInt();
		sc.nextLine();

		Ex30_1_User user = dao.find(id);

		System.out.println("아이디 :" + user.getId());
		System.out.println("이름 :" + user.getName());
		System.out.println("나이 :" + user.getAge());
		System.out.println("이메일 :" + user.getEmail());
	}

	public static void update(Scanner sc, Ex30_1_UserDao dao) throws SQLException {
		System.out.println("수정할 아이디 : ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("새 이름 : ");
		String name = sc.nextLine();

		System.out.println("새 나이: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("새 이메일 : ");
		String email = sc.nextLine();

		int result = dao.update(new Ex30_1_User(id, name, age, email));
		System.out.println(result > 0 ? "수정완료" : "해당하는 아이디가 없습니다.");
	}

	public static void delete(Scanner sc, Ex30_1_UserDao dao) throws SQLException {
		System.out.println("삭제할 아이디 :");
		int id = sc.nextInt();
		sc.nextLine();

		int result = dao.delete(id);
		System.out.println(result > 0 ? "삭제완료" : "해당하는 아이디가 없습니다");
		// 삭제할 ID를 받고 삭제 진행
		// dao.delete()결과가 0보다 크면 "삭제 완료" 출력
		// 0보다 크지 않다면 "해당하는 아이디가 없습니다.

	}

}
