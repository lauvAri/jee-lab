package org.example.lab.persistence.impl;

import org.example.lab.persistence.DBUtil;
import org.example.lab.persistence.LogDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LogDaoImpl implements LogDao {
    @Override
    public void insertIntoCategoryLog(String user_id, String category_id) {
        String INSERT_INTO_CATEGORY_LOG = "insert into category_log (user_id, category_id) values(?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_CATEGORY_LOG);
            ps.setString(1, user_id);
            ps.setString(2, category_id);
            int affRows = ps.executeUpdate();
            if (affRows > 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
            DBUtil.closePreparedStatement(ps);
            DBUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertIntoProductLog(String user_id, String product_id) {
        String INSERT_INTO_PRODUCT_LOG = "insert into product_log (user_id, product_id) values(?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_PRODUCT_LOG);
            ps.setString(1, user_id);
            ps.setString(2, product_id);
            ps.executeUpdate();

            DBUtil.closePreparedStatement(ps);
            DBUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertIntoItemLog(String user_id, String item_id) {
        String INSERT_INTO_ITEM_LOG = "insert into item_log (user_id, item_id) values(?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_ITEM_LOG);
            ps.setString(1, user_id);
            ps.setString(2, item_id);
            ps.executeUpdate();

            DBUtil.closePreparedStatement(ps);
            DBUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
