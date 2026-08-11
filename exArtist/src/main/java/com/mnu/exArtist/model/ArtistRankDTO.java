package com.mnu.exArtist.model;

public class ArtistRankDTO {
	
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
	public String getArtist_gender() {
		return artist_gender;
	}
	public void setArtist_gender(String artist_gender) {
		this.artist_gender = artist_gender;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}
	 private String artist_id;
	 private String artist_name;
	 private String artist_gender;
	 private int tot;
	 private double ave;

}