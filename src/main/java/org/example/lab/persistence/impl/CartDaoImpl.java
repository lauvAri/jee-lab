package org.example.lab.persistence.impl;

import org.example.lab.domain.Cart;
import org.example.lab.persistence.CartDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDaoImpl implements CartDao {
    private static final String GET_CART_LIST_BY_USER ="SELECT\n" +
            "      ITEMID,\n" +
            "      PRODUCTID,\n"+
            "      ISINSHOCK,\n" +
            "      DESCRIPTION,\n" +
            "      QUANTITY,\n" +
            "      LISTPRICE,\n" +
            "      FROM CART \n"+
            "    WHERE USERID = ?";

    @Override
    public Cart getCartItemIdByUsername(String username) {

    }

    @Override
    public void insertCart(Cart cart) {

    }

    @Override
    public void removeItemInCart(Cart cart, String itemId) {

    }

    @Override
    public void updateCart(Cart cart) {

    }
}
