package com.gpg.amazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gpg.amazon.dao.ICommentDao;
import com.gpg.amazon.entity.Comment;
import com.gpg.amazon.util.C3P0Util;

public class CommentDaoImpl implements ICommentDao {
	QueryRunner qr = C3P0Util.getQueryRunner();

	@Override
	public List<Comment> queryAllComment() throws SQLException {
		String sql = "SELECT cid, reply, content, create_time, reply_time, nick_name, c_state FROM t_comment";
		return qr.query(sql, new BeanListHandler<>(Comment.class));
	}

	@Override
	public int addComment(Comment comment) throws SQLException {
		String sql = "INSERT INTO t_comment (content, create_time, nick_name) VALUES(?, ?, ?)";
		return qr.update(sql, comment.getContent(),comment.getCreate_time(),comment.getNick_name());
	}

}
