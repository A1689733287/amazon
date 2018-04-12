package com.gpg.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.entity.Comment;

public interface ICommentDao {
	/**
	 * 查询多有的留言
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Comment> queryAllComment() throws SQLException;

	/**
	 * 添加留言
	 * 
	 * @param comment
	 * @return
	 * @throws SQLException
	 */
	public abstract int addComment(Comment comment) throws SQLException;
}
