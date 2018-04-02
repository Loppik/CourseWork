package echo.coursework.dao;

import java.util.ArrayList;

public class MySqlDao {
    private static ArrayList<String> data = new ArrayList<String>(10);

    public static ArrayList<String> getQuestion() {
        data.add("Question №1");
        data.add("Question №2");
        data.add("Question №3");
        return data;
    }
}
