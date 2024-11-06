import org.example.lab.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//public class test {
//    public static void main(String[] args) throws SQLException {
//        DBUtil db = new DBUtil();
//        Connection conn = db.getConnection();
//        String INSERT = "INSERT INTO ACCOUNT\n" +
//                "      (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID)\n" +
//                "    VALUES\n" +
//                "      (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement ps = conn.prepareStatement(INSERT);
//        ps.setString(1, "test@test.com");
//        ps.setString(2, "testUser");
//        ps.setString(3, "undefined");
//        ps.setString(4, "OK");
//        ps.setString(5, "undefined");
//        ps.setString(6, "undefined");
//        ps.setString(7, "undefined");
//        ps.setString(8, "undefined");
//        ps.setString(9, "undefined");
//        ps.setString(10, "undefined");
//        ps.setString(11, "undefined");
//        ps.setString(12, "testUser");
//        int row = ps.executeUpdate();
//        System.out.println(row);
//
//    }
//}
