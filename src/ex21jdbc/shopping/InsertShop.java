package ex21jdbc.shopping;

import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;
import ex21jdbc.prepared.InsertQuery;

public class InsertShop extends IConnectImpl{
	public InsertShop() {
		super("kosmo", "1234");
	}
	
	@Override
	 public void execute() {
		try {
			String query = "insert into sh_goods "
					+ " values ( goods_seq.nextval, ?, ? , sysdate, ?)";  
			psmt = con.prepareStatement(query);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("상품명 : ");
	        String goods_name = scan.nextLine();
	        System.out.print("상품가격 : ");
	        String goods_price = scan.nextLine();
	        System.out.print("상품코드 : ");
	        String p_code = scan.nextLine();
	        
	        psmt.setString(1, goods_name);
	        psmt.setString(2, goods_price);
	        psmt.setString(3, p_code);
	        
	        
	        
	        int affected = psmt.executeUpdate();
	        System.out.println(affected + "행이 입력되었습니다.");
			
		}catch (Exception e) {
	         e.printStackTrace();
	    }finally {
	         close();
	    }
	}
	
	public static void main(String[] args) {
		new InsertShop().execute();
		
	}

}
