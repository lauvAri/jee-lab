package org.example.lab.persistence.impl;

import org.example.lab.domain.Cart;
import org.example.lab.domain.Item;
import org.example.lab.domain.Product;
import org.example.lab.persistence.CartDao;
import org.example.lab.persistence.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDaoImpl implements CartDao {
    private static final String GET_CART_LIST_BY_USER ="SELECT\n" +
            "      ITEMID,\n" +
            "      PRODUCTID,\n"+
            "      ISINSHOCK,\n" +
            "      QUANTITY,\n" +
            "      DESCRIPTION,\n" +
            "      LISTPRICE\n" +
            "      from CART \n"+
            "    where USERID = ?";

    private static final String INSERT_CART ="INSERT INTO CART \n" +
            "(USERID,ITEMID,PRODUCTID,ISINSHOCK,QUANTITY,DESCRIPTION,LISTPRICE)"+
            "VALUES(?,?,?,?,?,?,?)";

    private static final String ADD_QUANTITY_BY_USER_AND_ITEM ="UPDATE CART \n"+
            "SET QUANTITY = QUANTITY + 1 \n"+
            "WHERE USERID = ? AND ITEMID = ?";

    private static final String REMOVE_CART_ITEM_BY_USER_AND_ITEM ="DELETE FROM CART \n"+
            "WHERE USERID = ? AND ITEMID = ?";

    private static final String UPDATE_QUANTITY_BY_USER_AND_ITEM = "UPDATE CART \n"+
            "SET QUANTITY = ? \n"+
            "WHERE USERID = ? AND ITEMID = ?";

    @Override
    public Cart getCartItemIdByUsername(String username) {
        System.out.println("DaoImpl get cart func");
        Cart cart = new Cart();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_LIST_BY_USER);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setItemId(resultSet.getString("ITEMID"));
                //item.setProductId(resultSet.getString("PRODUCTID"));
                Product product = new Product();
                product.setProductId(resultSet.getString("PRODUCTID"));
                item.setProduct(product);
                item.setQuantity(resultSet.getInt("QUANTITY"));
                System.out.println("quantity="+item.getQuantity());
                BigDecimal listPrice = new BigDecimal(resultSet.getString("LISTPRICE"));
                item.setListPrice(listPrice);
                item.setAttribute1(resultSet.getString("DESCRIPTION"));

                boolean isInShock = resultSet.getBoolean("ISINSHOCK");
                cart.addItem(item,isInShock);
                cart.setQuantityByItemId(item.getItemId(), resultSet.getInt("QUANTITY"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public void insertCart(String username,boolean isInShock,Item item) {
        try{
            System.out.println("func insert SQL");
            System.out.println(isInShock);
            Connection connection = DBUtil.getConnection();
            if(isInShock){
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, item.getItemId());
                preparedStatement.setString(3, item.getProductId());
                preparedStatement.setString(4, "true");
                preparedStatement.setInt(5, item.getQuantity());
                preparedStatement.setString(6, item.getAttribute1());
                preparedStatement.setString(7, item.getListPrice().toString());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }else{
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUANTITY_BY_USER_AND_ITEM);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, item.getItemId());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeItemInCart(String username,String itemId) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_CART_ITEM_BY_USER_AND_ITEM);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, itemId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addItemQuantity(String username, String itemId) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUANTITY_BY_USER_AND_ITEM);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, itemId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCart(String username,String item,int quantity) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_BY_USER_AND_ITEM);
            preparedStatement.setInt(1,quantity);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,item);
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
