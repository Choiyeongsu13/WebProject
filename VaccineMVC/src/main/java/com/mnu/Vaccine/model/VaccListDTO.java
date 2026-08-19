package com.mnu.Vaccine.model;

public class VaccListDTO {
	private String hospcode; // 병원코두
	private String hospname; // 병원이름
	private String cnt; //접종예약
	public String getHospcode() {
		return hospcode;
	}
	public void setHospcode(String hospcode) {
		this.hospcode = hospcode;
	}
	public String getHospname() {
		return hospname;
	}
	public void setHospname(String hospname) {
		this.hospname = hospname;
	}
	public String getcnt() {
		return cnt;
	}
	public void setcnt(String cnt) {
		this.cnt = cnt;
	}

}
