package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BidDAO {

	public String buyItem(int user_id, int price, int goods_id){
		Connection conn= null;
		PreparedStatement st = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("CALL buyItem(?,?,?)");
			st.setInt(1, user_id);
			st.setInt(2, price);
			st.setInt(3, goods_id);
			st.executeUpdate();
			st.close();
		}catch(Exception e){
			e.printStackTrace();
			return "/jsp/buy_fail.jsp";
		}finally{
			try{
				conn.close();
			}catch(Exception e){

			}
		}
		return "/jsp/buy_result.jsp";
	}
}
