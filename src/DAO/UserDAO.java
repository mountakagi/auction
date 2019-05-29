package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public  void insertUser(String name, String password){
		Connection conn= null;
		PreparedStatement st = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("insert into user(user_name,pass_word) values(?,?)");
			st.setString(1, name);
			st.setString(2, password);
			st.executeUpdate();

			st.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception e){

			}
		}
	}

	public  boolean checkUser(String user_name){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Boolean bln = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select ID from user where user_name=?");
			st.setString(1, user_name);
			rs = st.executeQuery();
			bln = rs.next();
			rs.close();
			st.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception e){

			}
		}
		return bln;
	}
}
