package com.mnu.Stock.model;

public class TBL_BUY_STOCK_DTO {
	private String buy_date;
	private String stock_item_code;
	private int buy_number;
	private int buy_price;
	private String dept_code;
	public String getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	public String getStock_item_code() {
		return stock_item_code;
	}
	public void setStock_item_code(String stock_item_code) {
		this.stock_item_code = stock_item_code;
	}
	public int getBuy_number() {
		return buy_number;
	}
	public void setBuy_number(int buy_number) {
		this.buy_number = buy_number;
	}
	public int getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

}
