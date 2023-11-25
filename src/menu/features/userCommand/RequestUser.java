package menu.features.userCommand;

public interface RequestUser {
    String getUsername();
    String getPassword();
    void setUsername(String newUsername);
    void setPassword(String newPassword);
}
