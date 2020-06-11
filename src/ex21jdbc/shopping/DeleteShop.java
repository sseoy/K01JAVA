package ex21jdbc.shopping;

import java.sql.Types;

import ex21jdbc.callable.DeleteProcCall;
import ex21jdbc.connect.IConnectImpl;

public class DeleteShop extends IConnectImpl{
	
	public DeleteShop() {
		super("kosmo", "1234");
	}

	@Override
	   public void execute() {
	      try {
	         csmt = con.prepareCall("{call ShopDeleteGoods(?,?)}");
	         csmt.setString(1, scanValue("삭제할 상품 일련번호"));
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
	      
	      new DeleteShop().execute();

	   }

}
