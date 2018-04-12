package com.gpg.amazon.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.dao.impl.CommentDaoImpl;
import com.gpg.amazon.entity.Comment;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	CommentDaoImpl commentDao = Factory.getInstance("commentDao", CommentDaoImpl.class);

	@Override
	public List<Comment> queryAllComment() {
		try {
			return commentDao.queryAllComment();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addComment(Comment comment) {
		try {
			return commentDao.addComment(comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
