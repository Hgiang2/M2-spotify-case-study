package menu.features.userCommand;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import entity.User;
import services.observer.Observer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ValidUsersList implements Observer {
    private List<User> validUsers = new ArrayList<>();
    private static ValidUsersList instance;

    private ValidUsersList() {

        Type userType = new TypeToken<List<User>>() {}.getType();
        validUsers = (ArrayList<User>) Constants.fileHandler.readFromFile(Constants.VALID_USER_FILE_PATH, userType);
//        validUsers = new ArrayList<>();
    }

    public static ValidUsersList getInstance() {
        if (instance == null) {
            instance = new ValidUsersList();
        }
        return instance;
    }

    public List<User> getValidUsers() {
        return validUsers;
    }

    @Override
    public void update() {
        Constants.fileHandler.saveToFile(Constants.VALID_USER_FILE_PATH, validUsers);
        System.out.println();
        System.out.println("Create new account successfully!");
    }
}
