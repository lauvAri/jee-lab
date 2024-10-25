package org.example.lab.persistence.impl;

import org.example.lab.domain.Product;
import org.example.lab.persistence.DBUtil;
import org.example.lab.persistence.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final String GET_PRODUCT_LIST_BY_CATEGORY = "SELECT\n" +
            "      PRODUCTID,\n" +
            "      NAME,\n" +
            "      DESCN as description,\n" +
            "      CATEGORY as categoryId\n" +
            "    FROM PRODUCT\n" +
            "    WHERE CATEGORY = ?";

    private static final String GET_PRODUCT = " SELECT\n" +
            "      PRODUCTID,\n" +
            "      NAME,\n" +
            "      DESCN as description,\n" +
            "      CATEGORY as categoryId\n" +
            "    FROM PRODUCT\n" +
            "    WHERE PRODUCTID = ?";

    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> list = new ArrayList<Product>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_PRODUCT_LIST_BY_CATEGORY);
            ps.setString(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategoryId(rs.getString(4));
                list.add(product);
            }
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_PRODUCT);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategoryId(rs.getString(4));
            }
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        return List.of();
    }
}
