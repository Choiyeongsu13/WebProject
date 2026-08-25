package com.profill.model;

public class PostcommentDTO {
private int commentid;      
private int postid;         
private int parentid;      
                               
private String nickname;       
private String password;       
private String content;        
private boolean secret;
private boolean deleted;

private String createdat;

private boolean reply;

public int getCommentid() {
	return commentid;
}

public void setCommentid(int commentid) {
	this.commentid = commentid;
}

public int getPostid() {
	return postid;
}

public void setPostid(int postid) {
	this.postid = postid;
}

public int getParentid() {
	return parentid;
}

public void setParentid(int parentid) {
	this.parentid = parentid;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public boolean isSecret() {
	return secret;
}

public void setSecret(boolean secret) {
	this.secret = secret;
}

public boolean isDeleted() {
	return deleted;
}

public void setDeleted(boolean deleted) {
	this.deleted = deleted;
}

public String getCreatedat() {
	return createdat;
}

public void setCreatedat(String createdat) {
	this.createdat = createdat;
}

public boolean isReply() {
	return reply;
}

public void setReply(boolean reply) {
	this.reply = reply;
}







}
