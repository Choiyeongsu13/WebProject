package com.mnu.Vaccine.model; 

public class SearchresvDTO {
    private String pname;    //이름
    private String jumin;    //주민번호
    private String gender;   //성별
    private String tel;      //전화번호
    private String resvdate; //예약일자
    private String resvyime; //예약시간
    private String hospname; //병원명
    private String hosptel;  //병원전화(대표전화)
    private String hospaddr; //병원주소
    private String vname;    //백신종류
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getResvdate() {
		return resvdate;
	}
	public void setResvdate(String resvdate) {
		this.resvdate = resvdate;
	}
	public String getResvyime() {
		return resvyime;
	}
	public void setResvyime(String resvyime) {
		this.resvyime = resvyime;
	}
	public String getHospname() {
		return hospname;
	}
	public void setHospname(String hospname) {
		this.hospname = hospname;
	}
	public String getHosptel() {
		return hosptel;
	}
	public void setHosptel(String hosptel) {
		this.hosptel = hosptel;
	}
	public String getHospaddr() {
		return hospaddr;
	}
	public void setHospaddr(String hospaddr) {
		this.hospaddr = hospaddr;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}

   
}