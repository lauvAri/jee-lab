package org.example.lab.persistence;

public interface LogDao {
    void insertIntoCategoryLog(String user_id, String category_id);
    void insertIntoProductLog(String user_id, String product_id);
    void insertIntoItemLog(String user_id, String item_id);
}
