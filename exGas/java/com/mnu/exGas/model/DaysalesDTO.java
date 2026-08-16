package com.mnu.exGas.model;


public class DaysalesDTO {
	private String oildate;    
	private String oilname;    
	private int cnt;           
	private int totalCost;     

	public String getOildate() {
		return oildate;
	}
	public void setOildate(String oildate) {
		this.oildate = oildate;
	}
	public String getOilname() {
		return oilname;
	}
	public void setOilname(String oilname) {
		this.oilname = oilname;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}