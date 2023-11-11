package menu.service.userCommand;

import entity.User;

import java.util.List;

public class CurrentUser {
    private List<User> users;
    private User currentUser;
    private CurrentUser() {
        users = ValidUsersList.getInstance().getValidUsers();
    }
    private static CurrentUser instance;
    public static CurrentUser getInstance() {
        if(instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return;
            }
        }
    }
}
