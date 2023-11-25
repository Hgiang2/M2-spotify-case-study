package menu.features.userCommand.signInCommand;

import menu.features.userCommand.RequestUser;

public class RequestNewLogIn implements RequestUser {
    private String username;
    private String password;

    public RequestNewLogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
