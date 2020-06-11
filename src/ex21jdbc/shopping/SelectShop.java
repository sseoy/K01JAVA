package ex21jdbc.shopping;

import java.sql.SQLException;

import ex21jdbc.connect.IConnectImpl;
import ex21jdbc.statement.SelectSQL1;

public class SelectShop extends IConnectImpl{
	
	public SelectShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
		stmt = con.createStatement();
		String query = "SELECT g_idx, goods_name, to_char(goods_price, '999,999,999,000') format2,  "
				+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') format1 , p_code "
				+ "  FROM sh_goods";
		
		rs = stmt.executeQuery(query);
			
		while(rs.next()) {
            String g_idx = rs.getString("g_idx");
            String goods_name = rs.getString("goods_name");
            String goods_price = rs.getString("format2");
            String regidate = rs.getString("format1");
            String p_code = rs.getString("p_code");
            
            System.out.printf("일련번호 : %-10s 상품명 : %-10s 가격 : %-13s 등록일 : %-20s 제품코드 : %-10s\n",
            		g_idx, goods_name, goods_price, regidate, p_code );
        }	
			
			
			
		}catch (Exception e) {
	        System.out.println("쿼리오류발생");
	        e.printStackTrace();
	    }finally {
	        close(); //DB자원반납
	    }
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectShop SelectShop = new SelectShop();
		SelectShop.execute();
	}

}
