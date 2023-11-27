package services.validator;

import entity.User;
import entity.CurrentUser;
import entity.ValidUsersList;

import java.util.List;

public class ValidateUserExisted implements Validator {
    private List<User> users;
    private String username;

    public ValidateUserExisted(String username) {
        this.username = username;
        this.users = ValidUsersList.getInstance().getValidUsers();
    }

    @Override
    public boolean isCheck() {
        if (users != null) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
//                    CurrentUser.getInstance().getCurrentUser().setRole(user.getRole());
                    return true;
                }
            }
        }
        return false;
    }
}
