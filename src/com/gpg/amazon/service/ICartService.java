package com.gpg.amazon.service;

import java.util.List;

import com.gpg.amazon.entity.Cart;

public interface ICartService {
	public abstract List<Cart> queryCartByUid(long uid);

	public abstract List<Cart> queryCartByUid();

	public abstract int insertCart(Cart cart);
	
	public abstract int deleteCart(int cid);
	
	public abstract int alterCartCount(long quantity, long cid);
}
