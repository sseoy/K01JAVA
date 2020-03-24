package quiz_game;
/*
문제2) QuMyFriendDetailInfo.java
다음 상속관계에 있는 두 클래스의 적절한 생성자를 정의해보자.
main 함수에서는 MyFriendDetailInfo 클래스를 통해서 객체를 생성해야 하고 
생성된 정보를 확인할 수 있도록 해보자.

실행결과]
이름: 이순신
나이: 100
주소: 성균관
전화: 010-1000-8888
 */

//친구의 정보를 저장할 기본클래스
class MyFriendInfo {
	
	private String name;
	int age;
	
	//인자생성자
	public MyFriendInfo(String n, int a) {
		name = n;
		age = a;
	}
	
	public void ShowMyFriendInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
}

//친구의 기본정보 외 상세정보를 저장할 클래스
class MyFriendDetailInfo extends MyFriendInfo {
	
	private String addr;
    private String phone;
    
    //인자생성자
    public MyFriendDetailInfo(String _name, int _age, 
    		String _addr, String _phone) {
    	
    	super(_name, _age);    	
    	addr = _addr;
    	phone = _phone;
    }

	public void ShowMyFriendDetailInfo() {
		
		/*
		부모클래스의 멤버메소드를 호출할 때 명시적으로 super를 
		붙여주는것이 좋다.(안붙여도 오류는 안생김)
		 */
		super.ShowMyFriendInfo();
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
}

class QuMyFriendDetailInfo {
	
	public static void main(String[] args) {
		//이름, 나이, 주소, 전화번호를 인자로 객체를 생성…
		MyFriendDetailInfo info = new MyFriendDetailInfo
				("랩몬스터", 27, "빅히트Ent", "010-1234-5678");
		//정보Print
		info.ShowMyFriendDetailInfo();
	}
}
