package com.mnu.exGas.model;

public class SaleInfoDTO {
	private String saleno;
	private String oildate;
	private String oiltype;
	private int amount;
	private String paytype;
	private String custno;
	private String custname;
	private String creditcart;
	
	private String custtel1;
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCusttel1() {
		return custtel1;
	}
	public void setCusttel1(String custtel1) {
		this.custtel1 = custtel1;
	}
	public String getCusttel2() {
		return custtel2;
	}
	public void setCusttel2(String custtel2) {
		this.custtel2 = custtel2;
	}
	public String getCusttel3() {
		return custtel3;
	}
	public void setCusttel3(String custtel3) {
		this.custtel3 = custtel3;
	}
	private String custtel2;
	private String custtel3;
	
	public String getSaleno() {
		return saleno;
	}
	public void setSaleno(String saleno) {
		this.saleno = saleno;
	}
	public String getOildate() {
		return oildate;
	}
	public void setOildate(String oildate) {
		this.oildate = oildate;
	}
	public String getOiltype() {
		return oiltype;
	}
	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getCreditcart() {
		return creditcart;
	}
	public void setCreditcart(String creditcart) {
		this.creditcart = creditcart;
	}
	public int getOilcost() {
		return oilcost;
	}
	public void setOilcost(int oilcost) {
		this.oilcost = oilcost;
	}
	private int oilcost;
	
}
