package services.validator;

import entity.User;
import menu.features.userCommand.ValidUsersList;

import java.util.List;

public class ValidateUserCorrectPassword implements Validator {
    private List<User> users;
    private String username;
    private String password;

    public ValidateUserCorrectPassword(String username, String password) {
        this.users = ValidUsersList.getInstance().getValidUsers();
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean isCheck() {
        for(User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
