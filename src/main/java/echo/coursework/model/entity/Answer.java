package echo.coursework.model.entity;

public class Answer {
    private int id;
    private String text;
    private int likes;
    private int userId;

    public Answer() {};

    public Answer(int id, String text, int userId) {
        this.id = id;
        this.text = text;
        this.likes = 0;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
