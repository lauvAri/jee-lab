package org.example.lab.persistence.impl;

import org.example.lab.domain.Account;
import org.example.lab.persistence.AccountDao;
import org.example.lab.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    }

    @Override
    public void insertProfile(Account account) {

    }

    @Override
    public void insertSignon(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void updateProfile(Account account) {

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
