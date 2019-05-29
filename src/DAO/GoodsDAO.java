package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Goods;

public class GoodsDAO {

	public  int loginUser(String name, String password){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int user_id = 0;
		String true_password = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select ID,pass_word from user where user_name=?");
			st.setString(1, name);
			rs = st.executeQuery();
			while(rs.next()){
				user_id = rs.getInt("ID");
				true_password = rs.getString("pass_word");
			}
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

		if(password.equals(true_password)){
			return user_id;
		}else{
			return 0;
		}
	}

	public ArrayList<Goods> showItemList(int user_id){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Goods> goodslist = new ArrayList<>();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select g.ID, name, category, image_uri, g.price as st_price, status, u.user_name, description, IFNULL(MAX(b.price), 0) as bid_price,deadtime "
					+ "from goods as g "
					+ "left join bids as b "
					+ "on g.ID = b.goods_id "
					+ "inner join user as u "
					+ "on g.owner_id = u.ID "
					+ "WHERE status = 1 AND owner_id != ? "
					+ "GROUP BY g.ID");
			st.setInt(1, user_id);
			rs = st.executeQuery();
			while(rs.next()){
				Goods gds = new Goods();
				int goods_id =  rs.getInt("ID");
				gds.setGoods_id(goods_id);
				gds.setGoods_name(rs.getString("name"));
				gds.setImage_uri(rs.getString("image_uri"));
				gds.setCategory(rs.getString("category"));
				gds.setPrice(rs.getInt("st_price"));
				gds.setOwner_name(rs.getString("user_name"));
				gds.setDescription(rs.getString("Description"));
				int bid_price = rs.getInt("bid_price");
				gds.setBid_price(bid_price);
				gds.setDead_time(rs.getString("deadtime"));
				gds.setMax_bid_name(this.maxBidderName(goods_id, bid_price));
				gds.setMax_bid_user_id(this.maxBidderId(goods_id, bid_price));
				goodslist.add(gds);
			}
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
	return goodslist;
	}
	public String maxBidderName(int goods_id, int bid_price){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String user_name = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select u.user_name from bids AS b "
					+ "INNER JOIN user AS u on b.user_id = u.ID where b.goods_id=? AND price=?");
			st.setInt(1, goods_id);
			st.setInt(2, bid_price);
			rs = st.executeQuery();
			while(rs.next()){
				user_name = rs.getString("user_name");
			}
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
		return user_name;
	}

	public int maxBidderId(int goods_id, int bid_price){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int user_id = 0;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select u.ID from bids AS b "
					+ "INNER JOIN user AS u on b.user_id = u.ID where b.goods_id=? AND price=?");
			st.setInt(1, goods_id);
			st.setInt(2, bid_price);
			rs = st.executeQuery();
			while(rs.next()){
				user_id = rs.getInt("ID");
			}
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
		return user_id;
	}

	public Goods showItem(int goods_id){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Goods gds = new Goods();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select g.ID, name, category, image_uri, g.price as st_price, status, owner_id, description, IFNULL(MAX(b.price), 0) as bid_price,deadtime "
					+ "from goods as g "
					+ "left join bids as b "
					+ "on g.ID = b.goods_id "
					+ "WHERE g.ID = ? "
					+ "GROUP BY g.ID ");
			st.setInt(1, goods_id);
			rs = st.executeQuery();
			while(rs.next()){
				gds.setGoods_id(rs.getInt("ID"));
				gds.setGoods_name(rs.getString("name"));
				gds.setImage_uri(rs.getString("image_uri"));
				gds.setCategory(rs.getString("category"));
				gds.setPrice(rs.getInt("st_price"));
				gds.setStatus(rs.getInt("status"));
				gds.setOwner_id(rs.getInt("owner_id"));
				gds.setDescription(rs.getString("Description"));
				gds.setBid_price(rs.getInt("bid_price"));
				gds.setDead_time(rs.getString("deadtime"));
			}
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
		return gds;
	}

	public  ArrayList<Goods> showSellingItem(int user_id){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Goods> goodslist = new ArrayList<>();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select ID, name, category, image_uri, price, status, owner_id, description,deadtime from goods  Where owner_id=?");
			st.setInt(1, user_id);
			rs = st.executeQuery();
			while(rs.next()){
				Goods gds = new Goods();
				gds.setGoods_id(rs.getInt("ID"));
				gds.setGoods_name(rs.getString("name"));
				gds.setImage_uri(rs.getString("image_uri"));
				gds.setCategory(rs.getString("category"));
				gds.setPrice(rs.getInt("price"));
				gds.setStatus(rs.getInt("status"));
				gds.setOwner_id(rs.getInt("owner_id"));
				gds.setDescription(rs.getString("Description"));
				gds.setDead_time(rs.getString("deadtime"));
				goodslist.add(gds);
			}
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
		return goodslist;
	}

	public void sellItem(Goods gds){
		Connection conn= null;
		PreparedStatement st = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("insert into goods(name,category,image_uri,price,status,owner_id,description,deadtime) values(?,?,?,?,?,?,?,?)");
			st.setString(1, gds.getGoods_name());
			st.setString(2, gds.getCategory());
			st.setString(3, gds.getImage_uri());
			st.setInt(4, gds.getPrice());
			st.setInt(5, 1);
			st.setInt(6, gds.getOwner_id());
			st.setString(7, gds.getDescription());
			st.setString(8, gds.getDead_time());
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

	public void finishSellItem(int goods_id){
		Connection conn= null;
		PreparedStatement st = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("UPDATE goods SET status=3 where ID = ?");
			st.setInt(1, goods_id);
			st.executeUpdate();

			st.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){

			}
		}
	}

	public void deleteSellItem(int goods_id){
		Connection conn= null;
		PreparedStatement st = null;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("DELETE FROM bids where ID=?");
			st.setInt(1, goods_id);
			st.executeUpdate();

			st.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("DELETE FROM goods where ID=?");
			st.setInt(1, goods_id);
			st.executeUpdate();

			st.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){

			}
		}
	}

	public  ArrayList<Goods> showBuddingItem(int user_id){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Goods> goodslist = new ArrayList<>();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select G.ID,G.name,G.image_uri,G.category,max(B.price) AS bid_price,G.status,G.owner_id,G.description,G.deadtime  from goods as G,bids as B where G.ID=B.goods_id AND B.user_id=? AND status=1 GROUP BY B.goods_id;");
			st.setInt(1, user_id);
			rs = st.executeQuery();
			while(rs.next()){
				Goods gds = new Goods();
				int goods_id =  rs.getInt("ID");
				gds.setGoods_id(goods_id);
				gds.setGoods_name(rs.getString("name"));
				gds.setImage_uri(rs.getString("image_uri"));
				gds.setCategory(rs.getString("category"));
				gds.setBid_price(rs.getInt("bid_price"));
				gds.setStatus(rs.getInt("status"));
				gds.setOwner_id(rs.getInt("owner_id"));
				int bid_price = this.MaxBidsPrice(goods_id);
				gds.setDescription(rs.getString("Description"));
				gds.setMax_bid_price(bid_price);
				gds.setDead_time(rs.getString("deadtime"));
				gds.setMax_bid_name(this.maxBidderName(goods_id, bid_price));
				gds.setMax_bid_user_id(this.maxBidderId(goods_id, bid_price));
				goodslist.add(gds);
			}
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
		return goodslist;
	}	public int MaxBidsPrice(int goods_id){
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int max_bids_price=0;
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select max(price) from bids "
					+ "where goods_id=? ");
			st.setInt(1, goods_id);
			rs = st.executeQuery();
			while(rs.next()){
				max_bids_price = rs.getInt("max(price)");
			}
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
		return max_bids_price;
	}

}
