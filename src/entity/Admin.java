package entity;

import constant.Constants;

import java.util.List;

public class Admin extends User{
    private static User instance;
    private Admin() {
        super("admin", "admin12345@", Constants.ADMIN, false);
        ValidUsersList.getInstance().getValidUsers().add(this);
    }
    public static User getInstance() {
        try {
            instance = ValidUsersList.getInstance().getValidUsers().get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            instance = new Admin();
        }
        return instance;
    }

    public List<Request> getRequestList() {
        return RequestList.getInstance().getList();
    }
}
