package services.validator;

import entity.User;
import menu.service.userCommand.ValidUsersList;

import java.util.List;

public class ValidateUserExisted implements Validator {
    private List<User> users;
    private String username;

    public ValidateUserExisted(String username) {
        this.users = ValidUsersList.getInstance().getValidUsers();
        this.username = username;
    }

    @Override
    public boolean isCheck() {
        for(User user: users) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
