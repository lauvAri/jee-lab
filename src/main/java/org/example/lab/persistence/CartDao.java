package org.example.lab.persistence;

import org.example.lab.domain.Cart;

public interface CartDao {
    Cart getCartItemIdByUsername(String username);
    void insertCart(Cart cart);
    void removeItemInCart(Cart cart,String itemId);
    void updateCart(Cart cart);
}
