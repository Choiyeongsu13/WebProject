package com.mnu.exShop.model;

public class MoneyDTO {
	private  int custno;
	private  int saleno;
	private  int amount;
	private  String pcode;
	private  String sdate;
	
	
	public MoneyDTO() {}
	
	public MoneyDTO(	int custno,int saleno,int amount
			,String pcode,String sdate) {
		
		this.custno=custno;
		this.saleno=saleno;
		this.amount=amount;
		this.pcode=pcode;
		this.sdate=sdate;
		
				
	}



	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getSaleno() {
		return saleno;
	}

	public void setSaleno(int saleno) {
		this.saleno = saleno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	

}
