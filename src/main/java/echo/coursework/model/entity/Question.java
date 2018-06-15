package echo.coursework.model.entity;

import java.util.ArrayList;

public class Question {
    private int id;
    private String title;
    private String text;
    private int userId;
    private int topicId;
    private ArrayList<Integer> answersId;

    public Question() {};

    public Question(int id, String title, String text, int userId, int topicId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.topicId = topicId;
        this.answersId = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public ArrayList<Integer> getAnswersId() {
        return answersId;
    }

    public void setAnswersId(int answersId) {
        if (this.answersId == null) {
            this.answersId = new ArrayList<Integer>(1);
        }
        this.answersId.add(answersId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                ", topicId=" + topicId +
                ", answersId=" + answersId +
                '}';
    }
}
