package com.mnu.exArtist.model;

public class PointDTO {
	int serial_no;
	String artist_id;
	String mento_id;
	int point;
	
	
	public PointDTO() {}
	
	public PointDTO(int serial_no, String artist_id, String mento_id, int point) {
		this.artist_id=artist_id;
		this.serial_no=serial_no;
		this.mento_id=mento_id;
		this.point=point;
	}
	
}