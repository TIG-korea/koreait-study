package kr.com.training;

import java.util.Scanner;
//	<Game 클래스>
		public class Game {
			static Scanner sc = new Scanner(System.in);	

			public static void main(String[] args) {
				startGame(); // 게임 시작
			}
			
			public static void startGame() {
				Warlod warlod = new Warlod();
				CharacterAbility ablilty = new CharacterAbility();
				// Scanner 객체 생성
				// Warlod 객체 생성
				// CharacterAbility 객체 생성
				
				do { // 게임 시작
					System.out.println("게임 메뉴를 선택해주세요.");
					System.out.println("1. 사냥 시작");
					System.out.println("2. 인벤토리-포션");
					System.out.println("3. 스텟");
					System.out.println("4. 케릭터 정보 확인");
					System.out.println("0. 종료");
					System.out.print("메뉴 선택 : ");
					// 스캐너로 입력 받기
					int menu = sc.nextInt();
					System.out.println("================");
					if(menu == 1) {
						huntMenu(); // 사냥 시작
					} else if(menu == 2) {
						setPorsion(); // 인벤토리-포션
					} else if(menu == 3) {
						setStatus(); // 스텟
					} else if(menu == 4) {
						getCharInfo(); // 케릭터 정보 확인
					} else if(menu == 0) {
						System.out.println("게임을 종료합니다."); // 종료
						break;
					} else {
						System.out.println("올바른 메뉴를 선택해주세요.");
						System.out.println("================");
					}
				} while(true);
			}
			
			public static boolean huntMenu() {
				// MonsterAbility 객체 생성
				MonsterAbility monsterability = new MonsterAbility();
				
				do {
					System.out.println("공격을 선택해주세요.");
					System.out.println("1. 기본 공격");
					System.out.println("2. 힘 스킬 사용");
					System.out.println("3. 민첩 스킬 사용");
					System.out.println("4. 지력 스킬 사용");
					System.out.println("0. 처음으로 돌아가기");
					System.out.print("메뉴 선택 : ");
					// 스캐너로 입력 받기
					System.out.println("================");
					int selectAttack = sc.nextInt();
					if(selectAttack == 1) {
//						기본 공격 선택 시 : attack 메서드 호출
					} else if(selectAttack == 2) {
//						힘 스킬 선택 시 : strSkill 메서드 호출
					} else if(selectAttack == 3) {
//						민첩 스킬 선택 시 : dexSkill 메서드 호출
					} else if(selectAttack == 4) {
//						지력 스킬 선택 시 : knowledgeSkill 메서드 호출
					} else if(selectAttack == 0) {
						// 처음으로 돌아가기
						System.out.println("처음 메뉴로 돌아갑니다.");
						System.out.println("================");
						return true;
					} else {
						System.out.println("================");
						System.out.println("올바른 메뉴를 선택해주세요.");
					}
					System.out.println("================");

				} while(true);
			}
			

			public static boolean setPorsion() {
				do {
					System.out.println("인벤토리-포션");
					System.out.println("1. 체력 포션");
					System.out.println("2. 마나 포션"); 
					System.out.println("3. 포션 목록");
					System.out.println("0. 처음으로 돌아가기");
					System.out.print("사용할 포션을 선택하세요: ");
					// 스캐너로 입력 받기
					int selectPorsion = sc.nextInt();
					System.out.println("================");

					if(selectPorsion == 1) {
//				         > 소지중 체력 포션이 1개 이상일 경우
//			             => "체력 포션을 사용했습니다." 출력
//			             => 소지중 체력 포션 1개 감소			    
//			             => 체력 60 회복
//			             => "포션 사용 후 현재 체력 : OO"
//			         > 소지중 체력 포션이 0개 일 경우
//			             => "인벤토리 체력 포션이 없습니다." 출력 
					} else if(selectPorsion == 2) {
//				         > 소지중 마력 포션이 1개 이상일 경우
//			             => "마력 포션을 사용했습니다." 출력
//			             => 소지중 체력 포션 1개 감소			    
//			             => 마력 60 회복
//			             => "포션 사용 후 현재 마력 : OO"
//			         > 소지중 마력 포션이 0개 일 경우
//			             => "인벤토리 마력 포션이 없습니다." 출력 
					} else if(selectPorsion == 3) {
//				         > "소지중인 체력 포션은 OO개 입니다." 출력
//				         > "소지중인 마력 포션은 OO개 입니다." 출력 
					} else if(selectPorsion == 0) {
						// 처음으로 돌아가기
						System.out.println("처음 메뉴로 돌아갑니다.");
						System.out.println("================");
						return true;
					} else {
						System.out.println("올바른 메뉴를 선택해주세요.");
					}
					System.out.println("================");
				} while(true);
			}
			
			public static boolean setStatus() {
				// 레벨업 할때마다 스텟(unusedStatus) 5가 생김
				// 현재 레벨 확인 후 여유분의 스텟을 추가하는 코드 작성
				// * ability의 setter/getter를 이용
				do {
					System.out.println("사용할 스텟을 입력해주세요.");
					System.out.println("1. 힘+5");
					System.out.println("2. 민첩+5");
					System.out.println("3. 지력+5");
					System.out.println("0. 처음으로 돌아가기");
					System.out.print("사용할 스텟 : ");
					int selectStatus = sc.nextInt();
					System.out.println("================");

					if(selectStatus == 1) {
//			          > 사용 가능한 잔여 스텟(unusedStatus)이 있을 경우
//		                => "힘이 5 증가되었습니다." 출력
//		                => 힘 5 증가
//		                => 잔여 스텟 5 감소
//		                => "증가된 후 힘 : OO" 출력 
//		            > 사용 가능한 잔여 스텟(unsedStatus)이 없을 경우
//		                => "사용 가능한 스텟이 없습니다." 출력
						}
					 else if(selectStatus == 2) {
//			          > 사용 가능한 잔여 스텟(unusedStatus)이 있을 경우
//		                => "민첩이 5 증가되었습니다." 출력
//		                => 민첩 5 증가
//		                => 잔여 스텟 5 감소
//		                => "증가된 후 민첩 : OO" 출력 
//		            > 사용 가능한 잔여 스텟(unsedStatus)이 없을 경우
//		                => "사용 가능한 스텟이 없습니다." 출력
					} else if(selectStatus == 3) {
//			          > 사용 가능한 잔여 스텟(unusedStatus)이 있을 경우
//		                => "지력이 5 증가되었습니다." 출력
//		                => 지력 5 증가
//		                => 잔여 스텟 5 감소
//		                => "증가된 후 지력 : OO" 출력
//		            > 사용 가능한 잔여 스텟(unsedStatus)이 없을 경우
//		                => "사용 가능한 스텟이 없습니다." 출력
					
					} else if(selectStatus == 0) {
						// 처음으로 돌아가기
						System.out.println("처음 메뉴로 돌아갑니다.");
						System.out.println("================");
						return true;
					} else {
						System.out.println("올바른 메뉴를 선택해주세요.");
					}
					System.out.println("================");

				} while(true);
			}
			
			public static boolean getCharInfo() {
//		        - 현재 가진 정보들을 전체 출력
//					> "========케릭터 정보========"
//		        	> "체력 : OO"
//		        	> "마나 : OO"
//		        	> "힘 : OO "
//		        	> "민첩 : OO"
//		        	> "지력 : OO"
//		        	> "현재 레벨 : OO"
//		        	> "현재 경험치 : OO"
//		        	> "사용 가능 스텟 : OO" 
				System.out.println("================");
				return true;
			}
	

//		========================================================================

//		<CharacterAbility 클래스>
//		  1. 힘(str), 민첩(dex), 지력(knowledge)
//		     - 기본값 : 0
//		  2. 레벨(level)
//		     - 기본값 : 1
//		  3. 경험치(experience)
//		     - 기본값 : 0
//		     - 특징 : 경험치가 100 이상이 될 경우 레벨이 1 증가하고 경험치는 0으로 초기화됩니다.
//		  4. 체력(hp), 마력(mp)
//		     - 기본값 : 100
//		     - 특징 : 레벨업을 해도 회복되지 않습니다.
//		                  포션을 사용해도 최대 100까지만 회복됩니다.
//		  5. 잔여 스텟(unusedStatus)
//		     - 기본값 : 0
//		     - 특징 : 레벨업을 하면 5가 추가됩니다.
//		  6. 소지중인 체력 포션(hpPortionCount), 마력 포션(hpPortionCount)
//		     - 기본값 : 10
//
//		========================================================================
//
//		<MonsterAbility 클래스>
//		  1. 데미지(damage)
//		     - 기본값 : 5
//		  2. 체력(hp)
//		     - 기본값: 100
//		  3. getter/setter 작성
//
//		========================================================================
//
//		<Caracter 인터페이스>
//		  1. 기본 공격 attack 추상 메서드를 가집니다.
//		  2. 힘 스킬 strSkill 추상 메서드를 가집니다.
//		  3. 민첩 스킬 dexSkill 추상 메서드를 가집니다.
//		  4. 지력 스킬 knowledgeSkill 추상 메서드를 가집니다.
//
//		========================================================================
//
//		<Warlord 클래스, Character 인터페이스를 상속받음>
//		  1. 워로드는 객체 생성 시 기본 스탯을 갖습니다.
//		    - 힘 30
//		    - 덱스 17
//		    - 지력 10
//
//		  2. 기본 공격 attack 메서드
//		    * 참고 : 케릭터가 먼저 공격하고, 그 다음 몬스터가 공격을 합니다.
//		               즉, 서로 한 번씩 돌아가며 공격합니다.
//
//		    ------- 케릭터 공격 차례
//		    - 마력이 6 미만이라면 기본 공격 사용 불가 ("마력이 부족해 공격할 수 없습니다" 출력)
//		    - "몬스터가 OO의 피해를 입었습니다!" 출력    
//		    - 몬스터가 케릭터 힘*1.3 만큼의 체력이 깍입니다.
//		    - 케릭터의 마력 6 감소
//		    
//		    ------- 케릭터 공격 차례(몬스터 처치 시)
//		    - 몬스터의 체력이 0 이하라면 "몬스터 사냥을 성공하셨습니다" 출력
//		    - 케릭터의 경험치 13 증가
//
//		    ------- 몬스터 공격
//		    - "몬스터가 공격했습니다!" 출력    
//		    - "케릭터가 OO의 피해를 입었습니다!" 출력
//		    - 몬스터 데미지 만큼 케릭터의 체력이 감소합니다.
//
//		    ------- 몬스터 공격(케릭터 사망 시)
//		    > 케릭터의 체력과 마력이 70으로 회복됩니다.
//		    > 경험치가 30 감소합니다.
//
//
//		  3. 힘 스킬 strSkill 메서드
//		    * 참고 : 케릭터가 먼저 공격하고, 그 다음 몬스터가 공격을 합니다.
//		               즉, 서로 한 번씩 돌아가며 공격합니다.
//
//		    ------- 케릭터 공격 차례
//		    - 마력이 15 미만이라면 스킬 사용 불가 ("마력이 부족해 스킬을 사용할 수 없습니다." 출력)
//		    - "몬스터가 힘 스킬로 인해 OO의 피해를 입었습니다!" 출력
//		    - 몬스터가 힘*1.8 만큼의 체력이 깍입니다.
//		    - 케릭터의 마력 15 감소
//
//		   ------- 케릭터 공격 차례(몬스터 처치 시)
//		    - 몬스터의 체력이 0 이하라면 "몬스터 사냥을 성공하셨습니다" 출력
//		    - 케릭터의 경험치 13 증가
//
//		    ------- 몬스터 공격
//		    - "몬스터가 공격했습니다!" 출력    
//		    - "케릭터가 OO의 피해를 입었습니다!" 출력
//		    - 몬스터 데미지 만큼 케릭터의 체력이 감소합니다.
//
//		    ------- 몬스터 공격(케릭터 사망 시)
//		    > 케릭터의 체력과 마력이 70으로 회복됩니다.
//		    > 경험치가 30 감소합니다.
//
//
//		  4. 민첩 스킬 dexSkill 메서드
//		    * 참고 : 케릭터가 먼저 공격하고, 그 다음 몬스터가 공격을 합니다.
//		               즉, 서로 한 번씩 돌아가며 공격합니다.
//
//		    ------- 케릭터 공격 차례
//		    - 마력이 19 미만이라면 스킬 사용 불가 ("마력이 부족해 스킬을 사용할 수 없습니다." 출력)
//		    - "몬스터가 민첩 스킬로 인해 OO의 피해를 입었습니다!" 출력
//		    - 몬스터가 민첩*0.7 만큼의 체력이 깍입니다. 
//		    - "몬스터가 민첩 스킬로 인해 OO의 피해를 입었습니다!" 출력
//		    - 몬스터가 민첩*0.7 만큼의 체력이 깍입니다.
//		    - "몬스터가 민첩 스킬로 인해 OO의 피해를 입었습니다!" 출력
//		    - 몬스터가 민첩*0.7 만큼의 체력이 깍입니다. (총 3회 공격)
//		    - 케릭터의 마력 19 감소
//
//		   ------- 케릭터 공격 차례(몬스터 처치 시)
//		    - 몬스터의 체력이 0 이하라면 "몬스터 사냥을 성공하셨습니다" 출력
//		    - 케릭터의 경험치 13 증가
//
//		    ------- 몬스터 공격
//		    - "몬스터가 공격했습니다!" 출력    
//		    - "케릭터가 OO의 피해를 입었습니다!" 출력
//		    - 몬스터 데미지 만큼 케릭터의 체력이 감소합니다.
//
//		    ------- 몬스터 공격(케릭터 사망 시)
//		    > 케릭터의 체력과 마력이 70으로 회복됩니다.
//		    > 경험치가 30 감소합니다.
//
//
//		  5. 지력 스킬 knowledgeSkill 메서드
//		    * 참고 : 케릭터가 먼저 공격하고, 그 다음 몬스터가 공격을 합니다.
//		               즉, 서로 한 번씩 돌아가며 공격합니다.
//
//		    ------- 케릭터 공격 차례
//		    - 마력이 28 미만이라면 스킬 사용 불가 ("마력이 부족해 스킬을 사용할 수 없습니다." 출력)
//		    - "몬스터가 지력 스킬로 인해 OO의 피해를 입었습니다!" 출력
//		    - 몬스터가 지력*3.6 만큼의 체력이 깍입니다.
//		    - 케릭터의 마력 28 감소
//
//		   ------- 케릭터 공격 차례(몬스터 처치 시)
//		    - 몬스터의 체력이 0 이하라면 "몬스터 사냥을 성공하셨습니다" 출력
//		    - 케릭터의 경험치 13 증가
//
//		    ------- 몬스터 공격
//		    - "몬스터가 공격했습니다!" 출력    
//		    - "케릭터가 OO의 피해를 입었습니다!" 출력
//		    - 몬스터 데미지 만큼 케릭터의 체력이 감소합니다.
//
//		    ------- 몬스터 공격(케릭터 사망 시)
//		    > 케릭터의 체력과 마력이 70으로 회복됩니다.
//		    > 경험치가 30 감소합니다.









		    
		  



















		
		
		
		
		
		
	}

}
