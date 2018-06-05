package echo.coursework.model.entity.users;

public class Guest extends User{
    public Guest() {
        super("guest", "1234");
    }

    public String getName() {
        return "Guest";
    }
}
