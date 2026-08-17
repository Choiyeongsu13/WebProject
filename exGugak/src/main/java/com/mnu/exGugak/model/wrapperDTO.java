package com.mnu.exGugak.model;

public class wrapperDTO {
	private tbl_entryDTO tbl_entryDTO;
	private tbl_recordDTO tbl_recordDTO;
	private tbl_refereeDTO tbl_refereeDTO;

	public wrapperDTO() {
		this.tbl_entryDTO = new tbl_entryDTO();
		this.tbl_recordDTO = new tbl_recordDTO();
		this.tbl_refereeDTO = new tbl_refereeDTO();
		
	}

	public tbl_entryDTO getTbl_entryDTO() {
		return tbl_entryDTO;
	}

	public void setTbl_entryDTO(tbl_entryDTO tbl_entryDTO) {
		this.tbl_entryDTO = tbl_entryDTO;
	}

	public tbl_recordDTO getTbl_recordDTO() {
		return tbl_recordDTO;
	}

	public void setTbl_recordDTO(tbl_recordDTO tbl_recordDTO) {
		this.tbl_recordDTO = tbl_recordDTO;
	}

	public tbl_refereeDTO getTbl_refereeDTO() {
		return tbl_refereeDTO;
	}

	public void setTbl_refereeDTO(tbl_refereeDTO tbl_refereeDTO) {
		this.tbl_refereeDTO = tbl_refereeDTO;
	}
	
	
}
