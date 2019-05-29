package model;

import java.io.Serializable;

public class Goods implements Serializable{
	private int goods_id;
	private String goods_name;
	private String description;
	private String category;
	private String image_uri;
	private String owner_name;
	private String dead_time;
	private String max_bid_name;


	private int price;
	private int status;
	private int owner_id;
	private int bid_price;
	private int max_bid_user_id;
	private int max_bid_price;

	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage_uri() {
		return image_uri;
	}
	public void setImage_uri(String image_uri) {
		this.image_uri = image_uri;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getBid_price() {
		return bid_price;
	}
	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getDead_time() {
		return dead_time;
	}
	public void setDead_time(String dead_time) {
		this.dead_time = dead_time;
	}
	public String getMax_bid_name() {
		return max_bid_name;
	}
	public void setMax_bid_name(String max_bid_name) {
		this.max_bid_name = max_bid_name;
	}
	public int getMax_bid_user_id() {
		return max_bid_user_id;
	}
	public void setMax_bid_user_id(int max_bid_user_id) {
		this.max_bid_user_id = max_bid_user_id;
	}
	public int getMax_bid_price() {
		return max_bid_price;
	}
	public void setMax_bid_price(int max_bid_price) {
		this.max_bid_price = max_bid_price;
	}

}
