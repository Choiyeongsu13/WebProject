package com.profill.model;

public class ProjectDTO {
	private int project_id;
	private String title;
	private String subtitle;
	private String description;
	private String content;
	private String category_code;
	private String thumbnail;
	private String github_url;
	
	private String demo_url;
	private int team_size;
	private String my_role;
	private String started_on;
	private String ended_on;
	private boolean featured;
	private int sort_order;
	private String created_at;
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getGithub_url() {
		return github_url;
	}
	public void setGithub_url(String github_url) {
		this.github_url = github_url;
	}
	public String getDemo_url() {
		return demo_url;
	}
	public void setDemo_url(String demo_url) {
		this.demo_url = demo_url;
	}
	public int getTeam_size() {
		return team_size;
	}
	public void setTeam_size(int team_size) {
		this.team_size = team_size;
	}
	public String getMy_role() {
		return my_role;
	}
	public void setMy_role(String my_role) {
		this.my_role = my_role;
	}
	public String getStarted_on() {
		return started_on;
	}
	public void setStarted_on(String started_on) {
		this.started_on = started_on;
	}
	public String getEnded_on() {
		return ended_on;
	}
	public void setEnded_on(String ended_on) {
		this.ended_on = ended_on;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	

}
