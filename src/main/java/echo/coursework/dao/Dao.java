package echo.coursework.dao;

import echo.coursework.model.entity.Answer;
import echo.coursework.model.entity.Question;

import java.util.ArrayList;

public abstract class Dao {
    public abstract ArrayList<Question> getLastQuestions(int amount);
    public abstract ArrayList<Question> getPopularQuestions(int amount);
    public abstract ArrayList<Answer> getAnswers(int questionId);
}
