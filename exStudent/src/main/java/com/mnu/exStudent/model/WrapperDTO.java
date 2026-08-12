package com.mnu.exStudent.model;

public class WrapperDTO {
	private tbl_deptDTO tbl_dept;
	private tbl_scoreDTO tbl_score;
	private tbl_sutdentDTO tbl_student;
	private int scnt;

	public WrapperDTO(){
		this.tbl_dept = new tbl_deptDTO();
		this.tbl_score = new tbl_scoreDTO();
		this.tbl_student = new tbl_sutdentDTO();
	}
	public tbl_deptDTO getTbl_dept() {
		return tbl_dept;
	}

	public void setTbl_dept(tbl_deptDTO tbl_dept) {
		this.tbl_dept = tbl_dept;
	}
	public tbl_scoreDTO getTbl_score() {
		return tbl_score;
	}
	public void setTbl_score(tbl_scoreDTO tbl_score) {
		this.tbl_score = tbl_score;
	}
	public tbl_sutdentDTO getTbl_student() {
		return tbl_student;
	}
	public void setTbl_student(tbl_sutdentDTO tbl_student) {
		this.tbl_student = tbl_student;
	}
	public int getScnt() {
		return scnt;
	}
	public void setScnt(int scnt) {
		this.scnt = scnt;
	}

	public double getKorAvg() {
		if (scnt == 0) return 0;
		return Math.round(tbl_score.getKor() * 10.0 / scnt) / 10.0;
	}
	public double getEngAvg() {
		if (scnt == 0) return 0;
		return Math.round(tbl_score.getEng() * 10.0 / scnt) / 10.0;
	}
	public double getMatAvg() {
		if (scnt == 0) return 0;
		return Math.round(tbl_score.getMat() * 10.0 / scnt) / 10.0;
	}

}
