package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class DeleteProcCall extends IConnectImpl {
/*
 JAVA에서 Oracle의 함수 호출하기
 
  1] 오라클에서 정의한 함수를 실해하기 위한 CallableStatement객체 생성
  -Connection객체의 prepareCall()메소드로 생성한다.
  -형식
  	prepareCall('{?=call 함수명(매개변수, 매개변수2.......)}");
  -첫번째 물음표는 반환값을 의미함
  	반환값은 파라미터 설정시 java.sql.Types클래스의 자료형으로 설정.
  	
  2] 아웃 파라미터 설정
  -함수는 반환값이 1개이므로 인덱스는 무조건 1이다.
  
  3] 매개변수는 인파라미터 즉 setXXX()계열의 메소드를 이용한다.
  
  4] 함수실행은 execute() 메소드를 이용한다.
  
  5]반환값은 무조건 1개이므로 인덱스는 1이고, getXXX()계열의 함수로
  읽어온다.
  
 */	
   
   public DeleteProcCall() {
      super("kosmo", "1234");
   }
   
   @Override
   public void execute() {
      try {
         csmt = con.prepareCall("{call KosmoMemberDelete(?,?)}");
         csmt.setString(1, scanValue("삭제할 아이디"));
         csmt.registerOutParameter(2, Types.VARCHAR);
         csmt.execute();
         
         System.out.println("삭제프로시저 실행결과 : ");
         System.out.println(csmt.getString(2));
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         close();
      }
   }
   
   public static void main(String[] args) {
      
      new DeleteProcCall().execute();

   }

}