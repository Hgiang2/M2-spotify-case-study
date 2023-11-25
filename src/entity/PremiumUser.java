package entity;

import constant.Constants;

public class PremiumUser extends User{
    public PremiumUser(String username, String password) {
        super(username, password, "premium", true);
    }
}
