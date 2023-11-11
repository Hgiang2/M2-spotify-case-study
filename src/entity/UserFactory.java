package entity;

public class UserFactory {
    public User createNewUser(String username, String password) {
        return new User(username, password);
    }
}
