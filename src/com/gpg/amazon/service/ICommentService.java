package com.gpg.amazon.service;

import java.util.List;

import com.gpg.amazon.entity.Comment;

public interface ICommentService {
	public abstract List<Comment> queryAllComment();
	public abstract int addComment(Comment comment);
}
