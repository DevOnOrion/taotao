package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

public interface CartService {

	TaotaoResult addCart(Long itemId,Integer num,
			HttpServletRequest request,HttpServletResponse response);
	List<CartItem> getCartItem(HttpServletRequest request);
	TaotaoResult updateCartItem(long itemId,Integer num,HttpServletRequest request,HttpServletResponse response);
	TaotaoResult deleteCartItem(long itemId,HttpServletRequest request,HttpServletResponse response);
}