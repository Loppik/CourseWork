package echo.coursework.model.entity.users;

public class RegUser extends User{
    private int id;
    private int rating;

    public RegUser(int id, String name, String password, int rating) {
        super(name, password);
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
