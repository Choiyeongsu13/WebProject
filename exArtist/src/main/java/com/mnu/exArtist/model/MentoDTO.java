package com.mnu.exArtist.model;

public class MentoDTO {
	String mento_id;
	String mento_name;
	
	public MentoDTO() {}
	
	public MentoDTO(String mento_id , String mento_name) {
		this.mento_id=mento_id;
		this.mento_name=mento_name;
	}

	public String getMento_id() {
		return mento_id;
	}

	public void setMento_id(String mento_id) {
		this.mento_id = mento_id;
	}

	public String getMento_name() {
		return mento_name;
	}

	public void setMento_name(String mento_name) {
		this.mento_name = mento_name;
	}

}