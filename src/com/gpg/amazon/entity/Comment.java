package com.gpg.amazon.entity;

/**
 * 评论区
 * 
 * @author G
 *
 */
public class Comment {
	private long cid;
	private String reply;
	private String content;
	private String create_time;
	private String reply_time;
	private String nick_name;
	private String c_state;

	public Comment() {
		super();
	}

	public Comment(String reply, String content, String create_time, String reply_time, String nick_name,
			String c_state) {
		super();
		this.reply = reply;
		this.content = content;
		this.create_time = create_time;
		this.reply_time = reply_time;
		this.nick_name = nick_name;
		this.c_state = c_state;
	}

	public Comment(long cid, String reply, String content, String create_time, String reply_time, String nick_name,
			String c_state) {
		super();
		this.cid = cid;
		this.reply = reply;
		this.content = content;
		this.create_time = create_time;
		this.reply_time = reply_time;
		this.nick_name = nick_name;
		this.c_state = c_state;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getReply_time() {
		return reply_time;
	}

	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getC_state() {
		return c_state;
	}

	public void setC_state(String c_state) {
		this.c_state = c_state;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", reply=" + reply + ", content=" + content + ", create_time=" + create_time
				+ ", reply_time=" + reply_time + ", nick_name=" + nick_name + ", c_state=" + c_state + "]";
	}

}
