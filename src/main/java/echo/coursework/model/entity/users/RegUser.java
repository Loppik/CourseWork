package echo.coursework.model.entity.users;

public class RegUser extends User{
    private int id;
    private String name;
    private String password;
    private int rating;

    public RegUser(int id, String name, String password, int rating) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
