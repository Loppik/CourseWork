package echo.coursework.model;

import echo.coursework.dao.Dao;
import echo.coursework.dao.HardCodeDao;
import echo.coursework.dao.MySqlDao;

public class InformStorageModel {
    private static Dao dao = new MySqlDao();

    public static Dao getDao() {
        return dao;
    }
}
