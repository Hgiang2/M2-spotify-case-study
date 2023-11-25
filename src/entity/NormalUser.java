package entity;

public class NormalUser extends User{
    public NormalUser(String username, String password) {
        super(username, password, "normal", false);
    }
}
