package com.profill.model;

public class PhotoDTO {
private int     photoid;       
private int     albumid;       
private String  filename;     
private String  caption;      
private boolean cover;         
private int     sortorder;
private String takenat;
public int getPhotoid() {
	return photoid;
}
public void setPhotoid(int photoid) {
	this.photoid = photoid;
}
public int getAlbumid() {
	return albumid;
}
public void setAlbumid(int albumid) {
	this.albumid = albumid;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getCaption() {
	return caption;
}
public void setCaption(String caption) {
	this.caption = caption;
}
public boolean isCover() {
	return cover;
}
public void setCover(boolean cover) {
	this.cover = cover;
}
public int getSortorder() {
	return sortorder;
}
public void setSortorder(int sortorder) {
	this.sortorder = sortorder;
}
public String getTakenat() {
	return takenat;
}
public void setTakenat(String takenat) {
	this.takenat = takenat;
}




}
