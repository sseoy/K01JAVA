package ex20io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class E13MyFriendDeserializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		
			ObjectInputStream in =new ObjectInputStream(
					new FileInputStream("src/ex20io/freind_info.obj"));
			
			while(true) {
				//저장된 파일에서 정보1개 읽어오기
				Friend friend = (Friend)in.readObject();
				//만약 읽어올 정보(객체)가 더이사 없다면 루프 탈출
				if(friend==null)break;
				//읽어온 객체를 통해 정보출력
				friend.showAllData();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
