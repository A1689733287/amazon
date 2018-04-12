package com.gpg.amazon.entity;

/**
 * 新闻类
 * 
 * @author G
 *
 */
public class News {
	private long nid;
	private String news_title;
	private String news_content;
	private String news_create_time;

	public News() {
		super();
	}

	public News(String news_title, String news_content, String news_create_time) {
		super();
		this.news_title = news_title;
		this.news_content = news_content;
		this.news_create_time = news_create_time;
	}

	public News(long nid, String news_title, String news_content, String news_create_time) {
		super();
		this.nid = nid;
		this.news_title = news_title;
		this.news_content = news_content;
		this.news_create_time = news_create_time;
	}

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public String getNews_content() {
		return news_content;
	}

	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}

	public String getNews_create_time() {
		return news_create_time;
	}

	public void setNews_create_time(String news_create_time) {
		this.news_create_time = news_create_time;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", news_title=" + news_title + ", news_content=" + news_content
				+ ", news_create_time=" + news_create_time + "]";
	}

}
