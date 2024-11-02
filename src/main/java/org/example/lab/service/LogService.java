package org.example.lab.service;

import org.example.lab.persistence.LogDao;
import org.example.lab.persistence.impl.LogDaoImpl;

public class LogService {
    public static final int CATEGORY = 1;
    public static final int PRODUCT = 2;
    public static final int ITEM = 3;

    public void log(String user_id, String msg, int about) {
        LogDao logDao = new LogDaoImpl();
        switch (about) {
            case 1:
                logDao.insertIntoCategoryLog(user_id, msg);
                break;
            case 2:
                logDao.insertIntoProductLog(user_id, msg);
                break;
            case 3:
                logDao.insertIntoItemLog(user_id, msg);
                break;
        }
    }
}
