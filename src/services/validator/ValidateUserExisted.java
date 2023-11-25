package services.validator;

import entity.User;
import entity.CurrentUser;
import entity.ValidUsersList;

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
                CurrentUser.getInstance().setRole(user.getRole());
                return true;
            }
        }
        return false;
    }
}
