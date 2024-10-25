package org.example.lab.persistence.impl;

import org.example.lab.domain.Item;
import org.example.lab.domain.Product;
import org.example.lab.persistence.DBUtil;
import org.example.lab.persistence.ItemDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDaoImpl implements ItemDao {

    private static final String GET_ITEM_LIST_BY_PRODUCT = "SELECT\n" +
            "      I.ITEMID,\n" +
            "      LISTPRICE,\n" +
            "      UNITCOST,\n" +
            "      SUPPLIER AS supplierId,\n" +
            "      I.PRODUCTID AS \"product.productId\",\n" +
            "      NAME AS \"product.name\",\n" +
            "      DESCN AS \"product.description\",\n" +
            "      CATEGORY AS \"product.categoryId\",\n" +
            "      STATUS,\n" +
            "      ATTR1 AS attribute1,\n" +
            "      ATTR2 AS attribute2,\n" +
            "      ATTR3 AS attribute3,\n" +
            "      ATTR4 AS attribute4,\n" +
            "      ATTR5 AS attribute5\n" +
            "    FROM ITEM I, PRODUCT P\n" +
            "    WHERE P.PRODUCTID = I.PRODUCTID\n" +
            "    AND I.PRODUCTID = ?";
    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {

    }

    private static final String GET_INVENTORY_QUANTITY = "SELECT QTY AS value\n" +
            "    FROM INVENTORY\n" +
            "    WHERE ITEMID = ?";
    @Override
    public int getInventoryQuantity(String itemId) {
        int quantity = 0;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_INVENTORY_QUANTITY);
            ps.setString(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return quantity;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> itemList = new ArrayList<Item>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ITEM_LIST_BY_PRODUCT);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getString(1));
                item.setListPrice(rs.getBigDecimal(2));
                item.setUnitCost(rs.getBigDecimal(3));
                item.setSupplierId(rs.getInt(4));
                Product product = new Product();
                product.setProductId(rs.getString(5));
                product.setName(rs.getString(6));
                product.setDescription(rs.getString(7));
                product.setCategoryId(rs.getString(8));
                item.setProduct(product);
                item.setStatus(rs.getString(9));
                item.setAttribute1(rs.getString(10));
                item.setAttribute2(rs.getString(11));
                item.setAttribute3(rs.getString(12));
                item.setAttribute4(rs.getString(13));
                item.setAttribute5(rs.getString(14));
                itemList.add(item);
            }
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    private static final String GET_ITEM = "select\n" +
            "      I.ITEMID,\n" +
            "      LISTPRICE,\n" +
            "      UNITCOST,\n" +
            "      SUPPLIER AS supplierId,\n" +
            "      I.PRODUCTID AS \"product.productId\",\n" +
            "      NAME AS \"product.name\",\n" +
            "      DESCN AS \"product.description\",\n" +
            "      CATEGORY AS \"product.categoryId\",\n" +
            "      STATUS,\n" +
            "      ATTR1 AS attribute1,\n" +
            "      ATTR2 AS attribute2,\n" +
            "      ATTR3 AS attribute3,\n" +
            "      ATTR4 AS attribute4,\n" +
            "      ATTR5 AS attribute5,\n" +
            "      QTY AS quantity\n" +
            "    from ITEM I, INVENTORY V, PRODUCT P\n" +
            "    where P.PRODUCTID = I.PRODUCTID\n" +
            "      and I.ITEMID = V.ITEMID\n" +
            "      and I.ITEMID = ?";

    @Override
    public Item getItem(String itemId) {
        Item item = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ITEM);
            ps.setString(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item();
                item.setItemId(rs.getString(1));
                item.setListPrice(rs.getBigDecimal(2));
                item.setUnitCost(rs.getBigDecimal(3));
                item.setSupplierId(rs.getInt(4));
                Product product = new Product();
                product.setProductId(rs.getString(5));
                product.setName(rs.getString(6));
                product.setDescription(rs.getString(7));
                product.setCategoryId(rs.getString(8));
                item.setProduct(product);
                item.setStatus(rs.getString(9));
                item.setAttribute1(rs.getString(10));
                item.setAttribute2(rs.getString(11));
                item.setAttribute3(rs.getString(12));
                item.setAttribute4(rs.getString(13));
                item.setAttribute5(rs.getString(14));
                item.setQuantity(rs.getInt(15));
            }
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
