package com.mnu.product.model;

public class wrapperDTO {
	private tbl_companyDTO tbl_company;
	private tbl_inoutDTO tbl_inout;
	private tbl_productDTO tbl_product;
	
	public wrapperDTO() {
		this.tbl_company = new tbl_companyDTO();
		this.tbl_inout = new tbl_inoutDTO();
		this.tbl_product = new tbl_productDTO();
		
	}

	public tbl_companyDTO getTbl_company() {
		return tbl_company;
	}

	public void setTbl_company(tbl_companyDTO tbl_company) {
		this.tbl_company = tbl_company;
	}

	public tbl_inoutDTO getTbl_inout() {
		return tbl_inout;
	}

	public void setTbl_inout(tbl_inoutDTO tbl_inout) {
		this.tbl_inout = tbl_inout;
	}

	public tbl_productDTO getTbl_product() {
		return tbl_product;
	}

	public void setTbl_product(tbl_productDTO tbl_product) {
		this.tbl_product = tbl_product;
	}
	

}
