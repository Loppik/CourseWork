package echo.coursework.services;

import echo.coursework.dao.MySqlDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GetQuestionsService {

    public static ArrayList<String> getQuestion() {
        return MySqlDao.getQuestion();
    }
}
