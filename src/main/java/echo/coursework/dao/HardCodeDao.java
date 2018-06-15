package echo.coursework.dao;

import echo.coursework.model.entity.Answer;
import echo.coursework.model.entity.Question;
import echo.coursework.model.entity.Topic;
import echo.coursework.model.entity.users.RegUser;
import echo.coursework.model.entity.users.User;

import java.util.ArrayList;
import java.util.List;


public class HardCodeDao extends Dao{
    private  ArrayList<Question> questions = new ArrayList<Question>(10);
    private  ArrayList<Answer> answers = new ArrayList<Answer>(10);
    private  ArrayList<User> users = new ArrayList<User>(10);
    private  ArrayList<Topic> topics = new ArrayList<Topic>(10);

    {
        User alex = new RegUser(0, "Alex", "123", 0);
        User nick = new RegUser(1, "Nick", "1234", 0);
        User egor = new RegUser(2, "Egor", "12345", 0);

        users.add(alex);
        users.add(nick);
        users.add(egor);
        questions.add(new Question(0, "Question1", "La-la-la ques1 text", 0, 1));
        questions.add(new Question(1, "Question2", "La-la-la ques2 text", 1, 6));
        questions.add(new Question(2, "Question3", "La-la-la ques3 text", 2, 2));

        answers.add(new Answer(0, "answer from user 1", 1));
        questions.get(0).setAnswersId(0);
    }


    public ArrayList<Question> getLastQuestions(int amount) {
        ArrayList<Question> lastQuestions = new ArrayList<Question>(amount);
        int i = questions.size() - 1;
        while(amount != 0 && i >= 0) {
            lastQuestions.add(questions.get(i));
            i--;
        }
        return lastQuestions;
    }

    public ArrayList<Question> getPopularQuestions(int amount) {
        return null;
    }

    public ArrayList<Answer> getAnswers(int questionId) {
        ArrayList<Answer> ans = new ArrayList<Answer>(3);
        Question question = questions.get(questionId);
        if (question.getAnswersId() != null) {
            for(Integer answerId : question.getAnswersId()) {
                ans.add(answers.get(answerId));
            }
        }
        return ans;
    }

    public boolean checkUser(String name, String password) {
        return false;
    }

    public User addUser(String name, String password) {
        return null;
    }

    public User getUser(String name) {
        return null;
    }

    public List<Question> searchQuestionsByTitle(String text) {
        return null;
    }
}
