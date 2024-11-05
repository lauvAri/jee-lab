package org.example.lab.persistence;

import org.example.lab.domain.Cart;
import org.example.lab.domain.Item;

public interface CartDao {
    Cart getCartItemIdByUsername(String username);
    void insertCart(String username, boolean isInShock, Item item);
    void removeItemInCart(String username,String itemId);
    void updateCart(String username,String itemId,int quantity);
}
