package org.example.lab.persistence.impl;

import org.example.lab.domain.Account;
import org.example.lab.persistence.AccountDao;
import org.example.lab.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT\n" +
            "      SIGNON.USERNAME,\n" +
            "      ACCOUNT.EMAIL,\n" +
            "      ACCOUNT.FIRSTNAME,\n" +
            "      ACCOUNT.LASTNAME,\n" +
            "      ACCOUNT.STATUS,\n" +
            "      ACCOUNT.ADDR1 AS address1,\n" +
            "      ACCOUNT.ADDR2 AS address2,\n" +
            "      ACCOUNT.CITY,\n" +
            "      ACCOUNT.STATE,\n" +
            "      ACCOUNT.ZIP,\n" +
            "      ACCOUNT.COUNTRY,\n" +
            "      ACCOUNT.PHONE,\n" +
            "      PROFILE.LANGPREF AS languagePreference,\n" +
            "      PROFILE.FAVCATEGORY AS favouriteCategoryId,\n" +
            "      PROFILE.MYLISTOPT AS listOption,\n" +
            "      PROFILE.BANNEROPT AS bannerOption,\n" +
            "      BANNERDATA.BANNERNAME\n" +
            "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA\n" +
            "    WHERE ACCOUNT.USERID = ?\n" +
            "      AND SIGNON.PASSWORD = ?\n" +
            "      AND SIGNON.USERNAME = ACCOUNT.USERID\n" +
            "      AND PROFILE.USERID = ACCOUNT.USERID\n" +
            "      AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";


    private static final String GET_ACCOUNT_BY_USERNAME = "SELECT\n" +
            "          SIGNON.USERNAME,\n" +
            "          ACCOUNT.EMAIL,\n" +
            "          ACCOUNT.FIRSTNAME,\n" +
            "          ACCOUNT.LASTNAME,\n" +
            "          ACCOUNT.STATUS,\n" +
            "          ACCOUNT.ADDR1 AS address1,\n" +
            "          ACCOUNT.ADDR2 AS address2,\n" +
            "          ACCOUNT.CITY,\n" +
            "          ACCOUNT.STATE,\n" +
            "          ACCOUNT.ZIP,\n" +
            "          ACCOUNT.COUNTRY,\n" +
            "          ACCOUNT.PHONE,\n" +
            "          PROFILE.LANGPREF AS languagePreference,\n" +
            "          PROFILE.FAVCATEGORY AS favouriteCategoryId,\n" +
            "          PROFILE.MYLISTOPT AS listOption,\n" +
            "          PROFILE.BANNEROPT AS bannerOption,\n" +
            "          BANNERDATA.BANNERNAME\n" +
            "    FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA\n" +
            "    WHERE ACCOUNT.USERID = ? \n" +
            "      AND SIGNON.USERNAME = ACCOUNT.USERID\n" +
            "      AND PROFILE.USERID = ACCOUNT.USERID\n" +
            "      AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private final String INSERT_ACCOUNT = "INSERT INTO ACCOUNT\n" +
            "      (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID)\n" +
            "    VALUES\n" +
            "      (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?)";

    private final String INSERT_PROFILE = " INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID, MYLISTOPT, BANNEROPT)\n" +
            "    VALUES (?, ?, ?, ?, ?)";

    private static final String INSERT_SIGNON = "INSERT INTO SIGNON (PASSWORD,USERNAME)\n" +
            "    VALUES (?, ?)";

    private static final String UPDATE_SIGNON  = " UPDATE SIGNON SET PASSWORD = #{password}\n" +
            "    WHERE USERNAME = #{username}";

    private static final String UPDATE_ACCOUNT = "UPDATE ACCOUNT SET\n" +
            "      EMAIL = ?,\n" +
            "      FIRSTNAME = ?,\n" +
            "      LASTNAME = ?,\n" +
            "      STATUS = ?,\n" +
            "      ADDR1 = ?,\n" +
            "      ADDR2 = ?,\n" +
            "      CITY = ?,\n" +
            "      STATE = ?,\n" +
            "      ZIP = ?,\n" +
            "      COUNTRY = ?,\n" +
            "      PHONE = ?\n" +
            "    WHERE USERID = ?";

    private static final String UPDATE_PROFILE = "UPDATE PROFILE SET\n" +
            "      LANGPREF = ?,\n" +
            "      FAVCATEGORY = ?\n" +
            "    WHERE USERID = ?";

    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        try {
            account = new Account();
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account.setUsername(rs.getString("USERNAME"));
                account.setEmail(rs.getString("EMAIL"));
                account.setFirstName(rs.getString("FIRSTNAME"));
                account.setLastName(rs.getString("LASTNAME"));
                account.setAddress1(rs.getString("address1"));
                account.setAddress2(rs.getString("address2"));
                account.setCity(rs.getString("CITY"));
                account.setState(rs.getString("STATE"));
                account.setZip(rs.getString("ZIP"));
                account.setCountry(rs.getString("COUNTRY"));
                account.setPhone(rs.getString("PHONE"));
                account.setLanguagePreference(rs.getString("languagePreference"));
                account.setFavouriteCategoryId(rs.getString("favouriteCategoryId"));
                account.setListOption(rs.getInt("listOption") == 1);
                account.setBannerOption(rs.getInt("bannerOption") == 1);
                account.setBannerName(rs.getString("bannerName"));
            }
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account.setUsername(rs.getString("USERNAME"));
               account.setEmail(rs.getString("EMAIL"));
               account.setFirstName(rs.getString("FIRSTNAME"));
               account.setLastName(rs.getString("LASTNAME"));
               account.setStatus(rs.getString("STATUS"));
               account.setAddress1(rs.getString("address1"));
               account.setAddress2(rs.getString("address2"));
               account.setCity(rs.getString("CITY"));
               account.setState(rs.getString("STATE"));
               account.setZip(rs.getString("ZIP"));
               account.setCountry(rs.getString("COUNTRY"));
               account.setPhone(rs.getString("PHONE"));
               account.setLanguagePreference(rs.getString("languagePreference"));
               account.setFavouriteCategoryId(rs.getString("favouriteCategoryId"));
               account.setListOption(rs.getInt("listOption") == 1);
               account.setBannerOption(rs.getInt("bannerOption") == 1);
               account.setBannerName(rs.getString("bannerName"));
            } else {
                return null;
            }
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ACCOUNT);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getFirstName());
            ps.setString(3, account.getLastName());
            ps.setString(4, account.getStatus());
            ps.setString(5, account.getAddress1());
            ps.setString(6, account.getAddress2());
            ps.setString(7, account.getCity());
            ps.setString(8, account.getState());
            ps.setString(9, account.getZip());
            ps.setString(10, account.getCountry());
            ps.setString(11, account.getPhone());
            ps.setString(12, account.getUsername());
            int row = ps.executeUpdate();
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(connection);
            if (row > 0) {}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_PROFILE);
            ps.setString(1, account.getLanguagePreference());
            ps.setString(2, account.getFavouriteCategoryId());
            ps.setString(3, account.getUsername());
            ps.setInt(4, account.isListOption()?1:0);
            ps.setInt(5, account.isBannerOption()?1:0);
            int row = ps.executeUpdate();
            if (row > 0) {}
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_SIGNON);
            ps.setString(1, account.getPassword());
            ps.setString(2, account.getUsername());
            int row = ps.executeUpdate();
            if (row > 0) {}
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getFirstName());
            ps.setString(3, account.getLastName());
            ps.setString(4, account.getStatus());
            ps.setString(5, account.getAddress1());
            ps.setString(6, account.getAddress2());
            ps.setString(7, account.getCity());
            ps.setString(8, account.getState());
            ps.setString(9, account.getZip());
            ps.setString(10, account.getCountry());
            ps.setString(11, account.getPhone());
            ps.setString(12, account.getUsername());
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("success");
            }
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_PROFILE);
            ps.setString(1, account.getLanguagePreference());
            ps.setString(2, account.getFavouriteCategoryId());
            ps.setString(3, account.getUsername());
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("update profile success!");
                DBUtil.closeStatement(ps);
                DBUtil.closeConnection(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateSignon(Account account) {

    }

//    public static void main(String[] args) {
//        Connection connection = DBUtil.getConnection();
//        Account account = null;
//        AccountDao accountDao = new AccountDaoImpl();
//        account = accountDao.getAccountByUsername("j2ee");
//        System.out.println(account);
//    }
}
