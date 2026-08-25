
package com.profill.model;

public class PostDTO {
private int    postid;         
private int    categoryid;    
private String title;          
private String slug;           
private String summary;        
private String content;        
private String thumbnail;     
private int    readminutes;    
private String status;         
private String   publishedat;    
private int viewcount;
private String creadtedat;
private String updatedat;
public int getPostid() {
	return postid;
}
public void setPostid(int postid) {
	this.postid = postid;
}
public int getCategoryid() {
	return categoryid;
}
public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSlug() {
	return slug;
}
public void setSlug(String slug) {
	this.slug = slug;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getThumbnail() {
	return thumbnail;
}
public void setThumbnail(String thumbnail) {
	this.thumbnail = thumbnail;
}
public int getReadminutes() {
	return readminutes;
}
public void setReadminutes(int readminutes) {
	this.readminutes = readminutes;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPublishedat() {
	return publishedat;
}
public void setPublishedat(String publishedat) {
	this.publishedat = publishedat;
}
public int getViewcount() {
	return viewcount;
}
public void setViewcount(int viewcount) {
	this.viewcount = viewcount;
}
public String getCreadtedat() {
	return creadtedat;
}
public void setCreadtedat(String creadtedat) {
	this.creadtedat = creadtedat;
}
public String getUpdatedat() {
	return updatedat;
}
public void setUpdatedat(String updatedat) {
	this.updatedat = updatedat;
}

	
}