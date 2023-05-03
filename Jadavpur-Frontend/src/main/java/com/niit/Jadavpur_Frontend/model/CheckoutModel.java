package com.niit.Jadavpur_Frontend.model;

import java.io.Serializable;
import java.util.List;

import com.niit.Jadavpur_Backend.modal.Address;
import com.niit.Jadavpur_Backend.modal.Cart;
import com.niit.Jadavpur_Backend.modal.CartLines;
import com.niit.Jadavpur_Backend.modal.User;

public class CheckoutModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	private User user;
	private Address shipping;
	private Cart cart;
	private List<CartLines> cartLines;
	private double checkoutTotal;

	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public double getCheckoutTotal() {
		return checkoutTotal;
	}

	public void setCheckoutTotal(double checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}

	public List<CartLines> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLines> cartLines) {
		this.cartLines = cartLines;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getShipping() {
		return shipping;
	}

	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
}