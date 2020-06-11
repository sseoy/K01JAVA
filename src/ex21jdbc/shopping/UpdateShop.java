package ex21jdbc.shopping;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.callable.InsertProcCall;
import ex21jdbc.connect.IConnectImpl;

public class UpdateShop extends IConnectImpl{
	
	public UpdateShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			csmt = con.prepareCall("{callShopUpdateGoods(?,?,?,?,?)}");
			
			csmt.setString(1, scanValue("일련번호"));
			csmt.setString(2, scanValue("상품이름"));
			csmt.setString(3, scanValue("상품가격"));
			csmt.setString(4, scanValue("상품코드번호"));
			
			csmt.registerOutParameter(5, Types.NUMERIC);
			
			csmt.execute();
			
			int affected = csmt.getInt(5);
			
			if(affected==0)
				
				
				System.out.println("오류발생:입력실패");
			else
				System.out.println(affected+"행 입력성공");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new UpdateShop().execute();
	}

}
