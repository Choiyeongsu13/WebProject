package com.mnu.exArtist.model;

public class mentoScoreDTO {
		private int serial_no;
		private String artist_id;
		private String artist_name;
		private String artist_birth;
		private String mento_name;
		private int point;
		
		
		public int getSerial_no() {
			return serial_no;
		}
		public void setSerial_no(int serial_no) {
			this.serial_no = serial_no;
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
		public String getMento_name() {
			return mento_name;
		}
		public void setMento_name(String mento_name) {
			this.mento_name = mento_name;
		}
		public int getPoint() {
			return point;
		}
		public void setPoint(int point) {
			this.point = point;
		}
}