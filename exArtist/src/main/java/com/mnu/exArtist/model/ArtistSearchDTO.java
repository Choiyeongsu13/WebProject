package com.mnu.exArtist.model;

public class ArtistSearchDTO {
	
	private String artist_id;
	private String artist_name;
	private String artist_birth;
	private String mento_name;
	private String point;
	
	public ArtistSearchDTO() {}
	
	
	public ArtistSearchDTO(String artist_id,String artist_name, String artist_birth,
				String mento_name, String point) {
		this.artist_id=artist_id;
		this.artist_name=artist_name;
		this.artist_birth=artist_birth;
		this.mento_name=mento_name;
		this.point=point;
		
		
		
	}
	
	
	public String getMento_name() {
		return mento_name;
	}
	public void setMento_name(String mento_name) {
		this.mento_name = mento_name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getArtist_birth() {
		return artist_birth;
	}
	public void setArtist_birth(String artist_birth) {
		this.artist_birth = artist_birth;
	}

	

	
}
