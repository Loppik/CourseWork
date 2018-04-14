package echo.coursework.model;

import echo.coursework.dao.Dao;
import echo.coursework.dao.HardCodeDao;

public class InformStorageModel {
    private static Dao dao = new HardCodeDao();

    public static Dao getDao() {
        return dao;
    }
}
