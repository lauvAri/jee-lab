package org.example.lab.service;

import org.example.lab.domain.Cart;
import org.example.lab.domain.Item;
import org.example.lab.persistence.CartDao;
import org.example.lab.persistence.impl.CartDaoImpl;

public class CartService {
    CartDao cartDao;

    public CartService() {
        this.cartDao = new CartDaoImpl();
    }

    public Cart getCart(String username) {
        return cartDao.getCartItemIdByUsername(username);
    }

    public void insertCart(String username, boolean isInShock, Item item) {
        System.out.println("func service insertCart");
        cartDao.insertCart(username, isInShock, item);
    }

    public void removeItemInCart(String username,String itemId) {
        cartDao.removeItemInCart(username, itemId);
    }

    public void updateCart(String username,String itemId,int quantity) {
        cartDao.updateCart(username, itemId, quantity);
    }
}
